package cn.gsq.service;

import cn.gsq.domain.ZY;

import java.util.List;

public interface IZYService {

    public ZY findById(String id);
    public List<ZY> findAll();
}
