package cn.gsq.service.impl;

import cn.gsq.dao.*;
import cn.gsq.domain.Student;
import cn.gsq.service.IMessageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    IMessageDao messageDao;

    @Autowired
    IStudentDao studentDao;

    @Autowired
    IZYDao zyDao;

    @Autowired
    IYXDao yxDao;

    @Autowired
    IClassDao classDao;
    @Override
    public List<Student> findAll_stu(int page, int pageSize) {

        PageHelper.startPage(page, pageSize);
        return studentDao.findAll();
    }
    @Override
    public List<Student> findAll_stu() {
        return studentDao.findAll();
    }
    /**
     * 学生信息改变
     * @param id
     * @param sNo
     * @param sName
     * @param sSex
     * @param classid
     */
    @Override
    public void update(String id,String sNo,String sName,String sSex,String classid,String age,String phone) {
       String zyid = classDao.findById(classid).getZyid();
        System.out.println(zyid);
        String yxid = zyDao.findById(zyid).getYxid();
        messageDao.update(id,sNo,sName,sSex,classid,zyid,yxid,age,phone);
    }

    @Override
    public void update_stu(String id, String phone) {
        messageDao.update_stu(id,phone);
    }

    @Override
    public void save(String sNo, String sName, String sSex,String classid,String age,String phone) {
        String zyid = classDao.findById(classid).getZyid();
        System.out.println(zyid);
        String yxid = zyDao.findById(zyid).getYxid();
        messageDao.save(sNo,sName,sSex,classid,zyid,yxid,age,phone);
    }

    @Override
    public void del(String id) {
        messageDao.del(id);
    }

    public Student findById_stu(String id) {
        Student byId_stu = studentDao.findById(id);
        return byId_stu;
    }

    public Student findBySno(String sno){
        Student bySno = studentDao.findBySno(sno);
        return bySno;
    }

}
