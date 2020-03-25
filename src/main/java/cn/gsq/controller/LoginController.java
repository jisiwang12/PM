package cn.gsq.controller;

import cn.gsq.domain.User;
import cn.gsq.service.ILoginService;
import cn.gsq.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录
 * @author mechrevo
 */
@Controller
public class LoginController {
    @Autowired
    ILoginService loginService;

    /**
     * 密码验证
     * @param uName
     * @param passWd
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(name = "username") String uName,@RequestParam(name="password") String passWd) {
        User user = loginService.findUserByUname(uName);
        ModelAndView mv = new ModelAndView();
        if (user == null || !passWd.equals(user.getuPass())) {
            mv.addObject("status", 0);
            mv.setViewName("login");
        } else {
            mv.setViewName("main");
            mv.addObject("user", user);
        }
        return mv;
    }
}
