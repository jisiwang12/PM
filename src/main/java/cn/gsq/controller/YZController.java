package cn.gsq.controller;

import cn.gsq.domain.YX;
import cn.gsq.domain.YXZR;
import cn.gsq.domain.YZ;
import cn.gsq.service.impl.YXServiceImpl;
import cn.gsq.service.impl.YXZRServiceImpl;
import cn.gsq.service.impl.YZServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/yz")
public class YZController {
    @Autowired
    YZServiceImpl yzService;
    @Autowired
    YXServiceImpl yxService;

    @RequestMapping("findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<YZ> all = yzService.findAll();
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("yz-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        YZ byId_stu = yzService.findById(id);
        List<YX> all = yxService.findAll();
        modelAndView.addObject("yxList", all);
        modelAndView.addObject("yxms", byId_stu);
        modelAndView.setViewName("yz-show");
        return modelAndView;
    }

    @RequestMapping("/page")
    public ModelAndView page(String id) {
        YZ yz = yzService.findById(id);
        List<YX> yx = yxService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("yxList", yx);
        mv.addObject("yxms", yz);
        mv.setViewName("yz-add");
        return mv;
    }

    @RequestMapping("save")
    public String save(YZ yz) {
        yzService.save(yz);
        return "redirect:findAll";
    }

    @RequestMapping("update")
    public String update(YZ yz) {
        yzService.update(yz);
        return "redirect:findAll";
    }

    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                yzService.del(id);
            }
        }
        return "redirect:findAll";
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        String id = name.substring(1, name.length());
        YZ yz = yzService.findById(id);
        mv.addObject("yz", yz);
        mv.setViewName("yz-list");
        return mv;
    }

    @RequestMapping("/update_yz")
    public String update_yz(YZ yz) {
        String id = yz.getId();
        yzService.update(yz);
        return "redirect:findByName?name=y"+id;
    }
}
