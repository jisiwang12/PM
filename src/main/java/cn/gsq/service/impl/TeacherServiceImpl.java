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
    ITeacherDao teacherDao;
    @Override
    public List<Teacher> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return teacherDao.findAll();
    }

    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Teacher findById(String id) {
        return teacherDao.findById(id);
    }



    @Override
    public void save(String name, String age, String sex, String yxid, String phone) {

        teacherDao.save(name, age, sex, yxid,phone);
    }

    @Override
    public void update(String id, String name, String age, String sex, String yxid,String phone) {
        teacherDao.update(id, name, age, sex, yxid,phone);
    }

    @Override
    public void del(String id) {
        teacherDao.del(id);
    }

    public void update_teacher(String id,String phone) {
        teacherDao.update_teacher(id,phone);
    }
}
