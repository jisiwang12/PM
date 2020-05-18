package cn.gsq.service.impl;

import cn.gsq.dao.IClassDao;
import cn.gsq.domain.Class;
import cn.gsq.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    IClassDao classDao;;
    @Override
    public List<Class> findAll() {
        List<Class> all = classDao.findAll();
        return all;
    }
}
