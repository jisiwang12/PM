package cn.gsq.controller;

import cn.gsq.domain.Content;
import cn.gsq.domain.Tag;
import cn.gsq.service.IArticleService;
import cn.gsq.service.ITagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文章的Controller
 * @author mechrevo
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    IArticleService articleService;
    @Autowired
    ITagService tagService;

    /**
     * 搜索和查询所有文章
     * @param page
     * @param pageSize
     * @param key
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page" ,required = true,defaultValue = "1") int page,
                                @RequestParam(name = "pageSize" ,required = true,defaultValue = "6")int pageSize,
                                String key) {
        List<Content> all = articleService.findAllByPage(page,pageSize,key);
        ModelAndView mv = new ModelAndView();
        //分页
        PageInfo pageInfo = new PageInfo(all);
        //推荐文章
        List<Tag> tagList=tagService.findAll();
        mv.setViewName("article");
        //标签
        mv.addObject("tagList", tagList);
        //文章分页
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("key", key);
        System.out.println(all);
        return mv;
    }

    /**
     * 通过ID查询文章
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Content content=articleService.findById(id);
        List<Tag> tagList=tagService.findAll();
        modelAndView.setViewName("detail");
        modelAndView.addObject("tagList", tagList);
        modelAndView.addObject("content", content);
        System.out.println(content.getImgs());
        return modelAndView;
    }

    /**
     * 通过文章的标签查找文章
     * @param page
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/findByTagId")
    public ModelAndView findByTagId(@RequestParam(name = "page" ,required = true,defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize" ,required = true,defaultValue = "6")int pageSize,
                                    @RequestParam(name = "id",required = true) String id) {
        ModelAndView mv = new ModelAndView();
        List<Content> contents = articleService.findByTagId(page, pageSize, id);
        List<Tag> tagList=tagService.findAll();
        PageInfo pageInfo = new PageInfo(contents);
        mv.addObject("pageInfoTag", pageInfo);
        mv.addObject("tagList", tagList);
        mv.setViewName("article");
        System.out.println(contents);
        return mv;
    }
}
