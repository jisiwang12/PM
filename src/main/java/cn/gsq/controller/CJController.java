//package cn.gsq.controller;
//
//import cn.gsq.domain.Course;
//import cn.gsq.domain.KQ;
//import cn.gsq.domain.Student;
//import cn.gsq.service.impl.KQServiceImpl;
//import com.github.pagehelper.PageInfo;
//import com.sun.corba.se.spi.orbutil.threadpool.Work;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/work")
//public class CJController {
//    @Autowired
//    CJServiceImpl cjService;
//
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
//                                @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
//
//        List<CJ> all_total = cjService.findAll();
//        System.out.println();
//        PageInfo pageInfo = new PageInfo(all_total);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("cj-list");
//        modelAndView.addObject("pageInfo", pageInfo);
//        return modelAndView;
//    }
//    @RequestMapping("/findById")
//    public ModelAndView findById(@RequestParam(name = "id") String id) {
//        ModelAndView mv = new ModelAndView();
//        KQ byId = cjService.findById(id);
//        mv.addObject("cj", byId);
//        mv.setViewName("cj-show");
//        return mv;
//    }
//
//    @RequestMapping("/save")
//    public String save(@RequestParam(name = "id") String id,
//                       @RequestParam(name = "cid") String cid,
//                       @RequestParam(name = "coid") String coid,
//                       @RequestParam(name = "a") String a,
//                       @RequestParam(name = "b") String b,
//                       @RequestParam(name = "c") String c,
//                       @RequestParam(name = "avg") String avg,
//                       @RequestParam(name = "max") String max,
//                       @RequestParam(name = "min") String min)
//    {
//        cjService.save(id,cid,coid,a,b,c,avg,max,max);
//        return "redirect:findAll";
//    }
//
//    @RequestMapping("/page")
//    public ModelAndView page() {
//        List<Course> all_cour = courseService.findAll();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("courseList", all_cour);
//        mv.setViewName("cj-add");
//        return mv;
//    }
//
//    @RequestMapping("/update")
//    public String save(@RequestParam(name = "id") String id,
//                       @RequestParam(name = "cid") String cid,
//                       @RequestParam(name = "coid") String coid,
//                       @RequestParam(name = "a") String a,
//                       @RequestParam(name = "b") String b,
//                       @RequestParam(name = "c") String c,
//                       @RequestParam(name = "avg") String avg,
//                       @RequestParam(name = "max") String max,
//                       @RequestParam(name = "min") String min)
//
//    {
//        cjService.update(id,cid,coid,a,b,c,avg,max,max);
//        return "redirect:findAll";
//    }
//
//    @RequestMapping("/del")
//    public String del(String[] ids) {
//        if (ids != null && ids.length != 0) {
//            for (String id:ids) {
//                cjService.del(id);
//            }
//        }
//        return "redirect:findAll";
//    }
//}
