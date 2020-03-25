package cn.gsq.controller;

import cn.gsq.domain.Resource;
import cn.gsq.service.impl.ResourceServletImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 分享资源的controller类
 * @author mechrevo
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceServletImpl resourceServlet;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Resource> all = resourceServlet.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("resourceList", all);
        mv.setViewName("resource");
        return mv;
    }

    @RequestMapping("/findTag")
    public ModelAndView findByTag(String tag) {
        ModelAndView mv = new ModelAndView();
        List<Resource> byTag = resourceServlet.findByTag(tag);
        mv.setViewName("resource");
        mv.addObject("resourceList", byTag);
        return mv;
    }


}
