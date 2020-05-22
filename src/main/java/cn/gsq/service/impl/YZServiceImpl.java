package cn.gsq.service.impl;

import cn.gsq.dao.IYXZRDao;
import cn.gsq.dao.IYZDao;
import cn.gsq.domain.YXMS;
import cn.gsq.domain.YXZR;
import cn.gsq.domain.YZ;
import cn.gsq.service.IYXZRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YZServiceImpl {
    @Autowired
    IYZDao iyzDao;

    public List<YZ> findAll(int page, int pageSize) {
        return null;
    }

    public List<YZ> findAll() {
        return iyzDao.findAll();
    }


    public YZ findById(String id) {
        return iyzDao.findById(id);
    }


    public void save(YZ yz) {
        iyzDao.save(yz);
    }


    public void update(YZ yz) {
        iyzDao.update(yz);
    }


    public void del(String id) {
        iyzDao.del(id);
    }
}
