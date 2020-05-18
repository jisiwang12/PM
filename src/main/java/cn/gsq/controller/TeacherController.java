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
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Teacher> all = teacherService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("teacher-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Teacher byId_stu = teacherService.findById(id);
        List<YX> all = yxService.findAll();
        modelAndView.addObject("yxList", all);
        modelAndView.addObject("teacher", byId_stu);
        modelAndView.setViewName("teacher-show");
        return modelAndView;
    }

    @RequestMapping("/page")
    public ModelAndView page(String id) {
        Teacher teacher = teacherService.findById(id);
        List<YX> yx = yxService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("yxList", yx);
        mv.addObject("teacher", teacher);
        mv.setViewName("teacher-add");
        return mv;
    }

    @RequestMapping("save")
    public String save(@RequestParam(name = "name", required = true) String name,
                       @RequestParam(name = "age", required = true) String age,
                       @RequestParam(name = "sex", required = true) String sex,
                       @RequestParam(name = "yxid", required = true) String yxid) {
        teacherService.save(name, age, sex, yxid);
        return "redirect:findAll";
    }

    @RequestMapping("update")
    public String update(@RequestParam(name = "id", required = true) String id,
                         @RequestParam(name = "name", required = true) String name,
                         @RequestParam(name = "age", required = true) String age,
                         @RequestParam(name = "sex", required = true) String sex,
                         @RequestParam(name = "yxid", required = true) String yxid) {
        teacherService.update(id, name, age, sex, yxid);
        return "redirect:findAll";
    }

    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id:ids) {
                teacherService.del(id);
            }
        }
        return "redirect:findAll";
    }
}
