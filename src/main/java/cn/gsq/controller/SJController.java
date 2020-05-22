package cn.gsq.controller;


import cn.gsq.domain.*;
import cn.gsq.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sj")
public class SJController {

    @Autowired
    ScoreServiceImpl scoreService;
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    SJServiceImpl sjService;
    @Autowired
    TeacherServiceImpl teacherService;

    @RequestMapping("/findByCono")
    public ModelAndView findByCono(String id) {
        ModelAndView mv = new ModelAndView();
        SJ byCono = sjService.findByCono(id);
        mv.addObject("sj", byCono);
        mv.setViewName("sj-list");
        return mv;
    }

    public ModelAndView page(String name) {
        ModelAndView mv = new ModelAndView();
        String id = name.substring(1, name.length());
        List<Course> courseList = courseService.findByTid(id);
        mv.addObject("courseList", courseList);
        mv.setViewName("sj-add");
        return mv;
    }

    @RequestMapping("/update")
    public String update(SJ sj) {
        SJ sj1 = sjService.findByID(sj.getId());
        Course course = sj1.getCourse();
        String tid = course.getTid();
        sjService.update(sj);
        return "redirect:findByName?name=t" + tid;

    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();
        SJ byID = sjService.findByID(id);
        mv.setViewName("sj-show");
        mv.addObject("sj", byID);
        return mv;
    }

/*    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        String tid = name.substring(1, name.length());
        List<Course> courseList = courseService.findByTid(tid);
        mv.addObject("courseList", courseList);
        mv.setViewName("cj-list");
        return mv;
    }*/

    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        String tid = name.substring(1, name.length());
        List<Course> courseList = courseService.findByTid(tid);
        ArrayList<SJ> sjList = new ArrayList<>();
        if (courseList != null && courseList.size() != 0) {
            Teacher teacher = courseList.get(0).getTeacher();
            mv.addObject("teacher", teacher);
            for (Course course : courseList) {
                String cono = course.getCono();
                SJ byCono = sjService.findByCono(cono);
                if (byCono != null) {
                    sjList.add(byCono);
                }
            }
        }
        mv.addObject("sjList", sjList);

        mv.setViewName("sj-list");
        return mv;
    }

    @RequestMapping("/findByConotoxx")
    public ModelAndView findByConotoxx(String id) {
        ModelAndView mv = new ModelAndView();
        List<Score> scoreList = scoreService.findByCono(id);
        mv.addObject("scoreList", scoreList);
        mv.setViewName("cj-score-list");
        return mv;
    }

    @RequestMapping("/del")
    public String del(String[] ids) {
        SJ byID = sjService.findByID(ids[0]);
        String tid = byID.getCourse().getTid();
        tid = "t" + tid;
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                sjService.del(id);
            }
        }
        return "redirect:findByName?id=" + tid;
    }

    @RequestMapping("/test")
    public void test() {
        SJ byCono = sjService.findByCono("1");
        System.out.println(byCono);
    }

}
