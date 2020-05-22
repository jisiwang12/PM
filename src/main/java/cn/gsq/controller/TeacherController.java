package cn.gsq.controller;

import cn.gsq.domain.*;
import cn.gsq.domain.Class;
import cn.gsq.service.impl.TeacherServiceImpl;
import cn.gsq.service.impl.YXServiceImpl;
import cn.gsq.service.impl.ZYServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.ManifestEntryVerifier;

import java.util.List;

/**
 * 教学秘书
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    YXServiceImpl yxService;

    @RequestMapping("findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Teacher> all = teacherService.findAll();
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("teacher-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Teacher byId_stu = teacherService.findById(id);
        modelAndView.addObject("teacher", byId_stu);
        modelAndView.setViewName("teacher-show");
        return modelAndView;
    }

    @RequestMapping("/page")
    public ModelAndView page(String id) {
        Teacher teacher = teacherService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("teacher", teacher);
        mv.setViewName("teacher-add");
        return mv;
    }

    @RequestMapping("save")
    public String save(@RequestParam(name = "name", required = true) String name,
                       @RequestParam(name = "age", required = true) String age,
                       @RequestParam(name = "sex", required = true) String sex,
                       @RequestParam(name = "phone", required = true) String phone,
                       @RequestParam(name = "yxid", required = true) String yxid) {
        teacherService.save(name, age, sex, yxid, phone);
        return "redirect:findAll";
    }

    @RequestMapping("update")
    public String update(@RequestParam(name = "id", required = true) String id,
                         @RequestParam(name = "name", required = true) String name,
                         @RequestParam(name = "age", required = true) String age,
                         @RequestParam(name = "sex", required = true) String sex,
                         @RequestParam(name = "phone", required = true) String phone,
                         @RequestParam(name = "yxid", required = true) String yxid) {
        teacherService.update(id, name, age, sex, yxid, phone);
        return "redirect:findAll";
    }

    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                teacherService.del(id);
            }
        }
        return "redirect:findAll";
    }


    /**
     * 教师用户通过用户名查询
     *
     * @return
     */
    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        String tname = name.substring(1, name.length());
        Teacher byId = teacherService.findById(tname);
        ModelAndView mv = new ModelAndView();
        mv.addObject("teacher", byId);
        mv.setViewName("teacher-self");
        return mv;
    }

    @RequestMapping("/update_teacher")
    public String update_teacher(@RequestParam(name = "id", required = true) String id,
                               @RequestParam(name = "phone", required = true) String phone) {
        teacherService.update_teacher(id,phone);
        Teacher byId = teacherService.findById(id);
        String name = byId.getName();
        return "redirect:findByName?name=t"+id;
    }
}
