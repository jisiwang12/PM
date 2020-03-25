package cn.gsq.service;

import cn.gsq.domain.Resource;

import java.util.List;

public interface IResourceServlet {

    List<Resource> findAll();

    List<Resource> findByTag(String tag);
}
