package cn.gsq.service;

import cn.gsq.domain.Content;

import java.util.List;

public interface IContentService {
    List<Content> findAllByPage(int page,int pageSize);

    List<Content> findAll();

    Content findById(String id);

    void save(Content content);

    List<Content> findRecommend();
}
