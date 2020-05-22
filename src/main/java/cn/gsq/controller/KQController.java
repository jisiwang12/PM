package cn.gsq.controller;

import cn.gsq.domain.Course;
import cn.gsq.domain.KQ;
import cn.gsq.domain.Student;
import cn.gsq.service.IKQService;
import cn.gsq.service.impl.CourseServiceImpl;
import cn.gsq.service.impl.KQServiceImpl;
import cn.gsq.service.impl.MessageServiceImpl;
import com.github.pagehelper.PageInfo;
import com.sun.corba.se.impl.interceptors.PICurrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 考勤管理
 *
 * @author mechrevo
 */
@Controller
@RequestMapping("/kq")
public class KQController {
    @Autowired
    KQServiceImpl kqService;
    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    HttpServletRequest request;

    /**
     * 查询所有信息
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
        List<KQ> all = kqService.findAll(page, pageSize);
        //分页
        System.out.println();
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("kq-list");
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    /**
     * 通过成绩ID查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id") String id) {
        ModelAndView mv = new ModelAndView();
        KQ byId = kqService.findById(id);
        mv.addObject("cj", byId);
        mv.setViewName("kq-show");
        return mv;
    }

    /**
     * 学生用户查询个人考勤成绩
     * @param sno
     * @return
     */
    @RequestMapping("/findBySno")
    public ModelAndView findBySno(@RequestParam(name = "sno") String sno) {
        ModelAndView mv = new ModelAndView();
        String substring = sno.substring(1, sno.length());
        List<KQ> kqList = kqService.findBySno(substring);
        HashSet<String> strings = new HashSet<>();
        for (KQ kq : kqList) {
            String time = kq.getCourse().getTime();
            strings.add(time);
        }
        request.getSession().setAttribute("timeList",strings);
        mv.addObject("kqList", kqList);
        mv.addObject("timeList", strings);
        mv.setViewName("kq-list");
        return mv;
    }

    /**
     * 按学期查找成绩
     * @param time
     * @param sno
     * @return
     */
    @RequestMapping("/findByTime")
    public ModelAndView findByTime(@RequestParam(name = "time") String time,
                                   @RequestParam(name = "sno") String sno
                                 ) {
        ModelAndView mv = new ModelAndView();
        List<KQ> byTime = kqService.findByTime(sno, time);
        HashSet<String> timeList = (HashSet<String>) request.getSession().getAttribute("timeList");
        mv.addObject("kqList",byTime);
        mv.addObject("timeList",timeList);
        mv.setViewName("kq-list");
        return mv;
    }
    /**
     * 修改考勤数据
     * @param cd
     * @param kk
     * @return
     */
    @RequestMapping("/save")
    public String save(@RequestParam(name = "sno") String sno,
                             @RequestParam(name = "cd") String cd,
                             @RequestParam(name = "cono") String cono,
                             @RequestParam(name = "kk") String kk,
                             @RequestParam(name = "kqscore") String kqscore)
                              {
        kqService.save(sno, cd, kk,kqscore,cono);
        return "redirect:findAll";
    }

    @RequestMapping("/page")
    public ModelAndView page() {
        List<Student> all_stu = messageService.findAll_stu();
        List<Course> all_cour = courseService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("studentList", all_stu);
        mv.addObject("courseList", all_cour);
        mv.setViewName("kq-add");
        return mv;
    }

    @RequestMapping("/update")
    public String save(@RequestParam(name = "id") String id,
                       @RequestParam(name = "cd") String cd,
                       @RequestParam(name = "kk") String kk)
    {
        KQ byId = kqService.findById(id);
        String cono = byId.getCono();
        kqService.update(id,cd,kk);
        return "redirect:findByCono?id="+cono;
    }

    /**
     * 教师用户使用
     * @param name
     * @return
     */
    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        String tid = name.substring(1, name.length());
        List<Course> courseList = courseService.findByTid(tid);
        mv.addObject("courseList", courseList);
        mv.setViewName("teacher-kq");
        return mv;
    }

    @RequestMapping("/findByCono")
    public ModelAndView findByCono(String id) {
        ModelAndView mv = new ModelAndView();
        List<KQ> kqList=kqService.findByCono(id);
        for (KQ kq : kqList) {
            System.out.println(kq.getSno());
            System.out.println(kq.getKqscore());
        }
        mv.addObject("kqList", kqList);
        mv.setViewName("kq-list");
        return mv;
    }

}
