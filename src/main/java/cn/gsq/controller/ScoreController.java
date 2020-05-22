package cn.gsq.controller;

import cn.gsq.domain.Course;
import cn.gsq.domain.KQ;
import cn.gsq.domain.Score;
import cn.gsq.domain.Work;
import cn.gsq.service.IScoreService;
import cn.gsq.service.impl.CourseServiceImpl;
import cn.gsq.service.impl.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreServiceImpl scoreService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    CourseServiceImpl courseService;
    /**
     * 学生用户查询个人考勤成绩
     * @param sno
     * @return
     */
    @RequestMapping("/findBySno")
    public ModelAndView findBySno(@RequestParam(name = "sno") String sno) {
        ModelAndView mv = new ModelAndView();
        String substring = sno.substring(1, sno.length());
        List<Score> scoreList = scoreService.findBySno(substring);
        HashSet<String> strings = new HashSet<>();
        for (Score score : scoreList) {
            String time = score.getCourse().getTime();
            strings.add(time);
        }
        request.getSession().setAttribute("timeList", strings);
        mv.addObject("scoreList", scoreList);
        mv.addObject("timeList", strings);
        mv.setViewName("score-list");
        return mv;
    }

    /**
     * 按学期查找成绩
     *
     * @param time
     * @param sno
     * @return
     */
    @RequestMapping("/findByTime")
    public ModelAndView findByTime(@RequestParam(name = "time") String time,
                                   @RequestParam(name = "sno") String sno
    ) {
        ModelAndView mv = new ModelAndView();
        List<Score> byTime = scoreService.findByTime(sno, time);
        HashSet<String> timeList = (HashSet<String>) request.getSession().getAttribute("timeList");
        mv.addObject("scoreList", byTime);
        mv.addObject("timeList", timeList);
        mv.setViewName("score-list");
        return mv;
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        String tid = name.substring(1, name.length());
        List<Course> courseList = courseService.findByTid(tid);
        mv.addObject("courseList", courseList);
        mv.setViewName("teacher-score");
        return mv;
    }

    @RequestMapping("update")
    public String update(Score score) {
        scoreService.update(score);
        Score byId = scoreService.findById(score.getId().toString());
        Course course = byId.getCourse();
        String cono = course.getCono();
        return "redirect:findByCono?id="+cono;
    }

    @RequestMapping("/findByCono")
    public ModelAndView findByCono(String id) {
        ModelAndView mv = new ModelAndView();
        List<Score> scoreList=scoreService.findByCono(id);
        mv.addObject("scoreList", scoreList);
        mv.setViewName("score-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id") String id) {
        ModelAndView mv = new ModelAndView();
        Score byId = scoreService.findById(id);
        mv.addObject("cj", byId);
        mv.setViewName("score-show");
        return mv;
    }
}
