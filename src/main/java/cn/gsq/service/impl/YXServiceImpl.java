package cn.gsq.service.impl;

import cn.gsq.dao.IYXDao;
import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;
import cn.gsq.service.IYXMSService;
import cn.gsq.service.IYXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YXServiceImpl implements IYXService {
    @Autowired
    IYXDao iyxDao;

    @Override
    public YX findById(String id) {
        return iyxDao.findById(id);
    }

    @Override
    public List<YX> findAll() {
        return iyxDao.findAll();
    }
}
