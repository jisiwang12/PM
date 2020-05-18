package cn.gsq.service;

import cn.gsq.domain.YX;

import java.util.List;

public interface IYXService {

    YX findById(String id);

    List<YX> findAll();
}
