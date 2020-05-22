package cn.gsq.controller;


import cn.gsq.domain.CJ;
import cn.gsq.domain.Course;
import cn.gsq.domain.Score;
import cn.gsq.service.impl.CJServiceImpl;
import cn.gsq.service.impl.CourseServiceImpl;
import cn.gsq.service.impl.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cj")
public class CJController {

    @Autowired
    ScoreServiceImpl scoreService;
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    CJServiceImpl cjService;

    @RequestMapping("/findByCono")
    public ModelAndView findByCono(String id) {
        ModelAndView mv = new ModelAndView();
        CJ byCono = cjService.findByCono(id);
        mv.addObject("cj", byCono);
        mv.setViewName("cj-show");
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
        ArrayList<CJ> cjList = new ArrayList<>();
        for (Course course : courseList) {
            String cono = course.getCono();
            CJ byCono = cjService.findByCono(cono);
            if (byCono != null) {
                cjList.add(byCono);
            }
        }
        mv.addObject("cjList", cjList);
        mv.setViewName("cj-show");
        return mv;
    }

    @RequestMapping("/findByConotoxx")
    public ModelAndView findByConotoxx(String id) {
        ModelAndView mv = new ModelAndView();
        List<Score> scoreList=scoreService.findByCono(id);
        mv.addObject("scoreList", scoreList);
        mv.setViewName("cj-score-list");
        return mv;
    }
}
