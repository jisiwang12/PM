package cn.gsq.controller;

import cn.gsq.domain.Class;
import cn.gsq.domain.Student;
import cn.gsq.domain.UserInfo;
import cn.gsq.service.impl.ClassServiceImpl;
import cn.gsq.service.impl.MessageServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * 学生信息
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    MessageServiceImpl messageService;

    @Autowired
    ClassServiceImpl classService;


    /**
     * 查询所有
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll_Stu(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
        List<Student> all_stu = messageService.findAll_stu(page,pageSize);
        System.out.println(all_stu);
        PageInfo pageInfo = new PageInfo(all_stu);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student-list");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }


    /**
     * 通过id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById_stu(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Student byId_stu = messageService.findById_stu(id);
        List<Class> all = classService.findAll();
        modelAndView.addObject("classList", all);
        modelAndView.addObject("student", byId_stu);
        modelAndView.setViewName("student-show");
        return modelAndView;
    }

    /**
     * 学生用户使用的findById
     * @param sno
     * @return
     */

    @RequestMapping("/findBySno")
    public ModelAndView findBySno(String sno) {
        String substring = sno.substring(1, sno.length());
        System.out.println(substring);
        ModelAndView modelAndView = new ModelAndView();
        Student bySno = messageService.findBySno(substring);
        modelAndView.addObject("student", bySno);
        modelAndView.setViewName("student-list");
        return modelAndView;
    }

    /**
     * 管理员修改学生信息
     * @param id
     * @param sNo
     * @param sName
     * @param sSex
     * @param classid
     * @return
     */
    @RequestMapping("/update")
    public String   update(@RequestParam(name = "id", required = true) String id,
    @RequestParam(name = "sNo", required = true) String sNo,
    @RequestParam(name = "sName", required = true) String sName,
    @RequestParam(name = "sSex", required = true) String sSex,
    @RequestParam(name = "age", required = true) String age,
    @RequestParam(name = "phone", required = true) String phone,
    @RequestParam(name = "classid", required = true) String classid){
        System.out.println(sName);
        messageService.update(id,sNo,sName,sSex,classid,age,phone);
        return "redirect:findAll";
    }

    /**
     * 学生用户修改个人信息
     * @param id
     * @param phone
     * @return
     */
    @RequestMapping("/update_stu")
    public String   update_stu(@RequestParam(name = "id", required = true) String id,
                           @RequestParam(name = "phone", required = true) String phone){

        Student byId_stu = messageService.findById_stu(id);
        String sno = byId_stu.getsNo();
        messageService.update_stu(id,phone);
        return "redirect:findBySno?sno=t"+sno;
    }

    /**
     * 新建
     * @param sNo
     * @param sName
     * @param sSex
     * @param classid
     * @return
     */
    @RequestMapping("/save")
    public String save(@RequestParam(name = "sNo", required = true) String sNo,
                       @RequestParam(name = "sName", required = true) String sName,
                       @RequestParam(name = "sSex", required = true) String sSex,
                       @RequestParam(name = "age", required = true) String age,
                       @RequestParam(name = "phone", required = true) String phone,
                       @RequestParam(name = "classid", required = true) String classid) {


        messageService.save(sNo,sName,sSex,classid,age,phone);
        return "redirect:findAll";

    }

    /**
     * 新建跳转
     * @return
     */
    @RequestMapping("/page")
    public ModelAndView page() {
        List<Class> all = classService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("classList",all);
        mv.setViewName("student-add");
        return mv;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id:ids) {
                messageService.del(id);
            }
        }
        return "redirect:findAll";
    }


}
