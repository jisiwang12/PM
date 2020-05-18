package cn.gsq.service;

import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;

import java.util.List;

public interface IYXMSService {

    List<YXMS> findAll(int page, int pageSize);

    YXMS findById(String id);

    void save(String name, String age, String sex, String yxid);

    public void update(String id, String name, String age, String sex, String yxid);

    void del(String id);
}
