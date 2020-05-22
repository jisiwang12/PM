package cn.gsq.controller;

import cn.gsq.domain.Class;
import cn.gsq.domain.Student;
import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;
import cn.gsq.service.impl.YXMSServiceImpl;
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
@RequestMapping("/yxms")
public class YXMSController {
    @Autowired
    YXMSServiceImpl yxmsService;
    @Autowired
    YXServiceImpl yxService;

    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<YXMS> all = yxmsService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("yxms-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        YXMS byId_stu = yxmsService.findById(id);
        List<YX> all = yxService.findAll();
        modelAndView.addObject("yxList", all);
        modelAndView.addObject("yxms", byId_stu);
        modelAndView.setViewName("yxms-show");
        return modelAndView;
    }

    @RequestMapping("/page")
    public ModelAndView page(String id) {
        YXMS yxms = yxmsService.findById(id);
        List<YX> yx = yxService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("yxList", yx);
        mv.addObject("yxms", yxms);
        mv.setViewName("yxms-add");
        return mv;
    }

    @RequestMapping("save")
    public String save(@RequestParam(name = "name", required = true) String name,
                       @RequestParam(name = "age", required = true) String age,
                       @RequestParam(name = "sex", required = true) String sex,
                       @RequestParam(name = "yxid", required = true) String yxid) {
        yxmsService.save(name, age, sex, yxid);
        return "redirect:findAll";
    }

    @RequestMapping("update")
    public String update(@RequestParam(name = "id", required = true) String id,
                         @RequestParam(name = "name", required = true) String name,
                         @RequestParam(name = "age", required = true) String age,
                         @RequestParam(name = "sex", required = true) String sex
                       ) {
        yxmsService.update(id, name, age, sex);
        return "redirect:findByName?name=admin";
    }

    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id:ids) {
                yxmsService.del(id);
            }
        }
        return "redirect:findAll";
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(String name) {
        ModelAndView mv = new ModelAndView();
        List<YXMS> all = yxmsService.findAll(1, 2);
        if ("admin".equals(name)) {
            YXMS byId = yxmsService.findById(all.get(0).getId());
            mv.addObject("yxms", byId);
        } else {
            YXMS byId = yxmsService.findById(name.substring(1, name.length()));
            mv.addObject("yxms", byId);
        }
        mv.setViewName("yxms-list");
        return mv;
    }
}
