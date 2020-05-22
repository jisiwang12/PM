package cn.gsq.controller;

import cn.gsq.domain.Course;
import cn.gsq.domain.KQ;
import cn.gsq.domain.Student;
import cn.gsq.domain.Work;
import cn.gsq.service.impl.CourseServiceImpl;
import cn.gsq.service.impl.KQServiceImpl;
import cn.gsq.service.impl.WorkServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkServiceImpl workService;
    @Autowired
    HttpServletRequest request;

    @Autowired
    CourseServiceImpl courseService;
    /**
     * 学生用户按学号查询成绩
     * @param sno
     * @return
     */
    @RequestMapping("/findBySno")
    public ModelAndView findBySno(String sno) {
        ModelAndView mv = new ModelAndView();
        String substring = sno.substring(1, sno.length());
        List<Work> workList = workService.findBySno(substring);
        HashSet<String> strings = new HashSet<>();
        for (Work work : workList) {
            String time = work.getCourse().getTime();
            strings.add(time);
        }
        request.getSession().setAttribute("timeList",strings);
        mv.addObject("workList", workList);
        mv.addObject("timeList", strings);
        mv.setViewName("work-list");
        return mv;
    }

    /**
     * 学生用户按学期查询成绩
     * @param time
     * @param sno
     * @return
     */
    @RequestMapping("/findByTime")
    public ModelAndView findByTime(@RequestParam(name = "time") String time,
                                   @RequestParam(name = "sno") String sno
    ) {
        ModelAndView mv = new ModelAndView();
        List<Work> byTime = workService.findByTime(sno, time);
        HashSet<String> timeList = (HashSet<String>) request.getSession().getAttribute("timeList");
        mv.addObject("workList",byTime);
        mv.addObject("timeList",timeList);
        mv.setViewName("work-list");
        return mv;
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        String tid = name.substring(1, name.length());
        List<Course> courseList = courseService.findByTid(tid);
        mv.addObject("courseList", courseList);
        mv.setViewName("teacher-work");
        return mv;

    }

    @RequestMapping("/findByCono")
    public ModelAndView findByCono(String id) {
        ModelAndView mv = new ModelAndView();
        List<Work> workList=workService.findByCono(id);
        mv.addObject("workList", workList);
        mv.setViewName("work-list");
        return mv;
    }


    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id") String id) {
        ModelAndView mv = new ModelAndView();
        Work byId = workService.findById(id);
        mv.addObject("cj", byId);
        mv.setViewName("work-show");
        return mv;
    }

    @RequestMapping("update")
    public String update(Work work) {
        workService.update(work);
        Work byId = workService.findById(work.getId().toString());
        Course course = byId.getCourse();
        String cono = course.getCono();
        return "redirect:findByCono?id="+cono;
    }

}
