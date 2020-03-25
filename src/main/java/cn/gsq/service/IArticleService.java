package cn.gsq.service;

import cn.gsq.domain.Content;

import java.util.List;

public interface IArticleService {
    List<Content> findAllByPage(int page, int pageSize, String key);

    List<Content> findAll(String key);

    Content findById(String id);

    /**
     * 保存文章
     * @param content
     */
    void save(Content content);

    /**
     * 通过标签获取文章
     * @param page
     * @param pageSIze
     * @param tid
     * @return
     */
    List<Content> findByTagId(int page,int pageSIze,String tid);

    /**
     * 推荐文章
     * @return
     */
    List<Content> findRecommend();
}
