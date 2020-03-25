package cn.gsq.service;

import cn.gsq.domain.Tag;

import java.util.List;


public interface ITagService {

    public Tag findById(String id);

    List<Tag> findAll();
}
