package cn.gsq.service.impl;

import cn.gsq.dao.ITeacherDao;
import cn.gsq.dao.IYXMSDao;
import cn.gsq.domain.Student;
import cn.gsq.domain.Teacher;
import cn.gsq.domain.YXMS;
import cn.gsq.service.ITeacherService;
import cn.gsq.service.IYXMSService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    ITeacherDao iyxmsDao;
    @Override
    public List<Teacher> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return iyxmsDao.findAll();
    }

    @Override
    public Teacher findById(String id) {
        return iyxmsDao.findById(id);
    }

    @Override
    public void save(String name, String age, String sex, String yxid) {
        iyxmsDao.save(name, age, sex, yxid);
    }

    @Override
    public void update(String id, String name, String age, String sex, String yxid) {
        iyxmsDao.update(id, name, age, sex, yxid);
    }

    @Override
    public void del(String id) {
        iyxmsDao.del(id);
    }
}
