package cn.gsq.controller;

import cn.gsq.domain.Content;
import cn.gsq.domain.Tag;
import cn.gsq.service.ITagService;
import cn.gsq.service.impl.ContentServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 首页的Controller
 * @author mechrevo
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    ContentServiceImpl contentService;
    @Autowired
    ITagService tagService;

    /**
     * 查询所有文章
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page" ,required = true,defaultValue = "1") int page,
                                @RequestParam(name = "pageSize" ,required = true,defaultValue = "6")int pageSize,
                                HttpServletRequest request) {
        List<Content> all = contentService.findAllByPage(page,pageSize);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(all);
        ServletContext servletContext = request.getServletContext();
        //优化
        if (servletContext.getAttribute("reList") == null) {
            List<Content> recommend = contentService.findRecommend();
            servletContext.setAttribute("reList", recommend);
            System.out.println("初始化");
        }
        mv.setViewName("home");
        mv.addObject("pageInfo", pageInfo);
        System.out.println(all);
        return mv;
    }

    /**
     * 通过ID查找一篇文章
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Content content=contentService.findById(id);
        modelAndView.setViewName("detail");
        List<Tag> tagList=tagService.findAll();
        modelAndView.addObject("tagList", tagList);
        modelAndView.addObject("content", content);
        System.out.println(content.getImgs());
        return modelAndView;
    }


    /**
     * 添加文章
     * @param text
     * @param title
     * @param short_text
     * @return
     */
    @RequestMapping(value = "/test")
    public  ModelAndView  test(@RequestParam(name = "test-editormd-html-code",required = true) String text,
                               @RequestParam(name ="title" ,required = true) String title,
                               @RequestParam(name = "short_text" ,required = true) String short_text) {
        Content content = new Content();
        content.setTitle(title);
        content.setShort_text(short_text);
        content.setText(text);
        contentService.save(content);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("detail");
//        modelAndView.addObject("content", text);
        return modelAndView;
    }
}
