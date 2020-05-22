package cn.gsq.service.impl;

import cn.gsq.dao.*;
import cn.gsq.domain.Student;
import cn.gsq.domain.UserInfo;
import cn.gsq.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生service
 */
@Service

public class StudentServiceImpl implements IStudentService {
    @Autowired
    IClassDao classDao;
    @Autowired
    IZYDao zyDao;
    @Autowired
    IStudentDao studentDao;
    @Autowired
    private BCryptPasswordEncoder bcp;
    @Autowired
    IUserDao userDao;
    /**
     * 新建学生用户
     * @param sName
     * @param sSex
     * @param classid
     * @param age
     * @param phone
     */
    @Override
    public void save( String sName, String sSex,String classid,String age,String phone) {
        String zyid = classDao.findById(classid).getCzyid();
        String yxid = zyDao.findById(zyid).getYxid();
        List<Student> byCid = studentDao.findByCid(classid);
        String s = byCid.get(0).getsNo();
        Long i = Long.parseLong(s)+1;
        String s1 = i.toString();
        UserInfo userInfo = new UserInfo();
        userInfo.setStatus(1);
        userInfo.setRid("2");
        userInfo.setuName("s"+s1);
        userInfo.setuPass(bcp.encode("123"));
        userDao.save(userInfo);
        studentDao.save(s1,sName,sSex,zyid,yxid,classid,age,phone);
    }

    /**
     * 修改学生信息
     * @param sNo
     * @param sName
     * @param sSex
     * @param classid
     * @param age
     * @param phone
     */
    @Override
    public void update(String id,String sNo, String sName, String sSex, String classid, String age, String phone) {
        String zyid = classDao.findById(classid).getCzyid();
        String yxid = zyDao.findById(zyid).getYxid();
        Student bySno = studentDao.findBySno(sNo);
       /* String classid1 = bySno.getClassn().getCid();
        if (!classid.equals(classid1)) {
            List<Student> byCid = studentDao.findByCid(classid);
            String s = byCid.get(0).getsNo();
            Long i = Long.parseLong(s)+1;
            String s1 = i.toString();
            sNo = s1;
            UserInfo userInfo = new UserInfo();
            userInfo.setId(id);
            userInfo.setStatus(1);
            userInfo.setRid("2");
            userInfo.setuName("t"+s1);
            userInfo.setuPass(bcp.encode("123"));
            userDao.update(userInfo);
        }*/

        studentDao.update(id,sNo,sName,sSex,classid,zyid,yxid,age,phone);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void del(String id) throws Exception {
        Student student = studentDao.findById(id);
        UserInfo userByUsername = userDao.findUserByUsername("t" + student.getsNo());
        userDao.del(userByUsername.getId());
        studentDao.del(id);
    }
}
