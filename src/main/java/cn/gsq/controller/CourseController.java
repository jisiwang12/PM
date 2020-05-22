package cn.gsq.controller;

import cn.gsq.domain.Course;
import cn.gsq.domain.Teacher;
import cn.gsq.domain.UserInfo;
import cn.gsq.service.impl.CourseServiceImpl;
import cn.gsq.service.impl.TeacherServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    TeacherServiceImpl teacherService;

    /**
     * 查询全部课程
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView finaAll() {
        ModelAndView mv = new ModelAndView();
        List<Course> couerList = courseService.findAll();
        mv.addObject("courseList", couerList);
        mv.setViewName("course-list");
        return mv;
    }

    /**
     * 通过id查询课程信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();
        List<Teacher> teacherList = teacherService.findAll();
        Course course = courseService.findById(id);
        mv.addObject("course", course);
        mv.addObject("teacherList", teacherList);
        mv.setViewName("course-show");
        return mv;
    }

    /**
     * 修改课程信息
     *
     * @param course
     * @return
     */
    @RequestMapping("/update")
    public String update(Course course) {
        courseService.update(course);
        return "redirect:/course/findAll";
    }

    /**
     * 新建课程
     *
     * @param course
     * @return
     */
    @RequestMapping("/save")
    public String save(Course course) {
        courseService.save(course);
        return "redirect:/course/findAll";
    }

    @RequestMapping("/page")
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView();
        List<Teacher> all = teacherService.findAll();
        mv.addObject("teacherList", all);
        mv.setViewName("course-add");
        return mv;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/del")
    public String del(String[] ids) throws Exception {
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                courseService.del(id);
            }
        }
        return "redirect:/course/findAll";
    }

    @RequestMapping("/back")
    public String back(String id) {
        courseService.back(id);
        return "redirect:/course/findAll";
    }

    @RequestMapping("/go")
    public String go(String id) {
        courseService.go(id);
        return "redirect:/course/findAll";
    }

    /**
     * 院长审核成绩
     *
     * @param id
     * @return
     */
    @RequestMapping("/go_yz")
    public String go_yz(String id) {
        courseService.go_yz(id);
        return "redirect:/course/findAll";
    }

    @RequestMapping("/go_teacher")
    public String go_teacher(String id) {
        Course co = courseService.findByCono(id);
        String tid = co.getTid();
        courseService.go(id);
        return "redirect:/score/findByName?name=t" + tid;
    }

    @RequestMapping("/go_admin")
    public String go_admin(String id) {
        Course co = courseService.findByCono(id);
        String tid = co.getTid();
        courseService.go(id);
        return "redirect:/course/findAll_admin";
    }

    @RequestMapping("/back_admin")
    public String back_admin(String id) {
        courseService.back(id);
        return "redirect:/course/findAll_admin";
    }

    /**
     * 教学秘书审核课程成绩
     *
     * @return
     */
    @RequestMapping("/findAll_admin")
    public ModelAndView findAll_admin() {
        ModelAndView mv = new ModelAndView();
        List<Course> couerList = courseService.findAll();
        mv.addObject("courseList", couerList);
        mv.setViewName("course-list-admin");
        return mv;
    }
}