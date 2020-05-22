package cn.gsq.service;

import cn.gsq.domain.YXMS;
import cn.gsq.domain.YXZR;

import java.util.List;

public interface IYXZRService {

    List<YXMS> findAll(int page, int pageSize);

    YXZR findById(String id);

    void save(YXZR yxzr);

    public void update(YXZR yxzr);

    void del(String id);
}
