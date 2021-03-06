package cn.gsq.service.impl;

import cn.gsq.dao.IYXMSDao;
import cn.gsq.domain.Student;
import cn.gsq.domain.YXMS;
import cn.gsq.service.IYXMSService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YXMSServiceImpl implements IYXMSService {
    @Autowired
    IYXMSDao iyxmsDao;
    @Override
    public List<YXMS> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return iyxmsDao.findAll();
    }

    @Override
    public YXMS findById(String id) {
        return iyxmsDao.findById(id);
    }

    @Override
    public void save(String name, String age, String sex, String yxid) {
        iyxmsDao.save(name, age, sex, yxid);
    }

    @Override
    public void update(String id, String name, String age, String sex, String yxid) {

    }


    public void update(String id, String name, String age, String sex) {
        iyxmsDao.update(id, name, age, sex);
    }

    @Override
    public void del(String id) {
        iyxmsDao.del(id);
    }
}
