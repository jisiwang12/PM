package cn.gsq.service.impl;

import cn.gsq.dao.IArticleDao;
import cn.gsq.domain.Content;
import cn.gsq.service.IArticleService;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.bcel.internal.generic.IADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    IArticleDao articleDao;

    /**
     * 查询所有文章并分页
     * @param page
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public List<Content> findAllByPage(int page, int pageSize, String key) {
        if (key != null && key.length() != 0) {
            key = "%" + key + "%";
            System.out.println(key);
        } else {
            key = "%%";
        }
        PageHelper.startPage(page, pageSize);
        return articleDao.findAll(key);
    }

    /**
     * 查询所有文章不分页
     * @param key
     * @return
     */
    @Override
    public List<Content> findAll(String key) {
        if (key != null && key.length() != 0 && !"null".equals(key)) {
            key = "%" + key + "%";
            System.out.println(key);
        } else {
            key = "%%";
        }
        return articleDao.findAll(key);
    }

    /**
     * 通过ID查询文章
     * @param id
     * @return
     */
    @Override
    public Content findById(String id) {
        return articleDao.findById(id);
    }

    /**
     * 保存文章
     * @param content
     */
    @Override
    public void save(Content content) {
        articleDao.save(content);
    }

    /**
     * 通过标签ID查询文章
     * @param page
     * @param pageSize
     * @param tid
     * @return
     */
    @Override
    public List<Content> findByTagId(int page, int pageSize, String tid) {
        PageHelper.startPage(page, pageSize, tid);
        return articleDao.findAllByTagId(tid);
    }

    /**
     * 查询推荐文章
     * @return
     */
    @Override
    public List<Content> findRecommend() {
        return articleDao.findRecommend();
    }
}

