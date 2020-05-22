package cn.gsq.controller;

import cn.gsq.domain.*;
import cn.gsq.domain.Class;
import cn.gsq.service.impl.YXMSServiceImpl;
import cn.gsq.service.impl.YXServiceImpl;
import cn.gsq.service.impl.YXZRServiceImpl;
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
@RequestMapping("/yxzr")
public class YXZRController {
    @Autowired
    YXZRServiceImpl yxzrService;
    @Autowired
    YXServiceImpl yxService;

    @RequestMapping("findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<YXZR> all = yxzrService.findAll();
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("yxzr-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        YXZR byId_stu = yxzrService.findById(id);
        List<YX> all = yxService.findAll();
        modelAndView.addObject("yxList", all);
        modelAndView.addObject("yxms", byId_stu);
        modelAndView.setViewName("yxzr-show");
        return modelAndView;
    }

    @RequestMapping("/page")
    public ModelAndView page(String id) {
        YXZR yxms = yxzrService.findById(id);
        List<YX> yx = yxService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("yxList", yx);
        mv.addObject("yxms", yxms);
        mv.setViewName("yxzr-add");
        return mv;
    }

    @RequestMapping("save")
    public String save(YXZR yxzr) {
        yxzrService.save(yxzr);
        return "redirect:findAll";
    }

    @RequestMapping("update")
    public String update(YXZR yxzr) {
        yxzrService.update(yxzr);
        return "redirect:findAll";
    }

    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                yxzrService.del(id);
            }
        }
        return "redirect:findAll";
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        String yxzrid = name.substring(1, name.length());
        YXZR yxzr = yxzrService.findById(yxzrid);
        mv.addObject("yxzr", yxzr);
        mv.setViewName("yxzr-list");
        return mv;
    }

    @RequestMapping("/update_yxzr")
    public String update_yxzr(YXZR yxzr) {
        String id = yxzr.getId();
        yxzrService.update(yxzr);
        return "redirect:findByName?name=x"+id;
    }
}
