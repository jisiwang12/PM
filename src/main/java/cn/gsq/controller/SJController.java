//package cn.gsq.controller;
//
//import cn.gsq.domain.Class;
//import cn.gsq.domain.Student;
//import cn.gsq.domain.YX;
//import cn.gsq.domain.YXMS;
//import cn.gsq.service.impl.YXMSServiceImpl;
//import cn.gsq.service.impl.YXServiceImpl;
//import cn.gsq.service.impl.ZYServiceImpl;
//import com.github.pagehelper.PageInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import sun.security.util.ManifestEntryVerifier;
//
//import java.util.List;
//
///**
// * 教学秘书
// */
//@Controller
//@RequestMapping("/yxms")
//public class SJController {
//    @Autowired
//    YXMSServiceImpl yxmsService;
//    @Autowired
//    YXServiceImpl sjService;
//
//    @RequestMapping("findAll")
//    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
//                                @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
//        ModelAndView mv = new ModelAndView();
//        List<SJ> all = sjService.findAll(page, pageSize);
//        PageInfo pageInfo = new PageInfo(all);
//        mv.addObject("pageInfo", pageInfo);
//        mv.setViewName("sj-list");
//        return mv;
//    }
//
//    @RequestMapping("/findById")
//    public ModelAndView findById(String id) {
//        ModelAndView modelAndView = new ModelAndView();
//        YXMS byId_stu = sjService.findById(id);
//        modelAndView.addObject("sj", byId_stu);
//        modelAndView.setViewName("sj-show");
//        return modelAndView;
//    }
//
//
//    @RequestMapping("save")
//    public String save(@RequestParam(name = "coid", required = true) String coid,
//                       @RequestParam(name = "tid", required = true) String tid,
//                       @RequestParam(name = "max", required = true) String max,
//                       @RequestParam(name = "min", required = true) String min) {
//        yxmsService.save(coid,tid,max,min);
//        return "redirect:findAll";
//    }
//
//    @RequestMapping("update")
//    public String update(@RequestParam(name = "id", required = true) String id,
//                         @RequestParam(name = "coid", required = true) String coid,
//                         @RequestParam(name = "tid", required = true) String tid,
//                         @RequestParam(name = "max", required = true) String max,
//                         @RequestParam(name = "min", required = true) String min) {
//        yxmsService.update(id, coid,tid,max,min);
//        return "redirect:findAll";
//    }
//
//    @RequestMapping("/del")
//    public String del(String[] ids) {
//        if (ids != null && ids.length != 0) {
//            for (String id:ids) {
//                yxmsService.del(id);
//            }
//        }
//        return "redirect:findAll";
//    }
//}
