package cn.gsq.controller;

import cn.gsq.domain.UserInfo;
import cn.gsq.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userService.findById(id);
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                userService.del(id);
            }
        }
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public String update(UserInfo userInfo) {
        userService.update(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/changePW")
    public ModelAndView changePW(String uname,String old,String newpw) throws Exception {
        ModelAndView mv = new ModelAndView();
        boolean changestatus=userService.changePW(uname, old, newpw);
        String pwStatus = null;
        if (changestatus) {
             pwStatus = "1";
        } else {
            pwStatus = "0";
        }
        mv.addObject("pwStatus", pwStatus);
        mv.setViewName("changepassword");
        return mv;
    }
 }
