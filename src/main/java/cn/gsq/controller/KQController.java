package cn.gsq.controller;

import cn.gsq.domain.KQ;
import cn.gsq.service.IKQService;
import cn.gsq.service.impl.KQServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import java.util.List;

/**
 * 考勤管理
 *
 * @author mechrevo
 */
@Controller
@RequestMapping("/kq")
public class KQController {
    @Autowired
    KQServiceImpl kqService;

    /**
     * 查询所有信息
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "2") int pageSize) {
        List<KQ> all = kqService.findAll(page, pageSize);
        //分页
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(all);
        modelAndView.setViewName("orders-list");
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    /**
     * 通过成绩ID查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id") String id) {
        ModelAndView mv = new ModelAndView();
        KQ byId = kqService.findById(id);
        System.out.println(byId);
        mv.addObject("cj", byId);
        mv.setViewName("role-add");
        return mv;
    }

    /**
     * 修改考勤数据
     *
     * @param id
     * @param cd
     * @param kk
     * @return
     */
    @RequestMapping("/save")
    public String save(@RequestParam(name = "id") String id,
                             @RequestParam(name = "cd") String cd,
                             @RequestParam(name = "kk") String kk)
                              {
        kqService.save(id, cd, kk);
        return "redirect:findAll";
    }
}
