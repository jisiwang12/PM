package cn.gsq.service.impl;

import cn.gsq.dao.IYXZRDao;
import cn.gsq.domain.YXMS;
import cn.gsq.domain.YXZR;
import cn.gsq.service.IYXZRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YXZRServiceImpl implements IYXZRService {
    @Autowired
    IYXZRDao yxzrDao;
    @Override
    public List<YXMS> findAll(int page,int pageSize) {
        return null;
    }

    public List<YXZR> findAll() {
        return yxzrDao.findAll();
    }

    @Override
    public YXZR findById(String id) {
        return yxzrDao.findById(id);
    }

    @Override
    public void save(YXZR yxzr) {
        yxzrDao.save(yxzr);
    }

    @Override
    public void update(YXZR yxzr) {
        yxzrDao.update(yxzr);
    }

    @Override
    public void del(String id) {
        yxzrDao.del(id);
    }
}
