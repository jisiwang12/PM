package cn.gsq.service.impl;

import cn.gsq.dao.IStudentDao;
import cn.gsq.dao.IXKDao;
import cn.gsq.domain.Student;
import cn.gsq.domain.XK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XKServiceImpl {

    @Autowired
    IStudentDao studentDao;
    @Autowired
    IXKDao xkDao;

    /**
     * 保存选课信息
     * @param xk
     */
    public void save(XK xk) {
        xkDao.save(xk);
    }


    /**
     * 查询选课的学生
     * @param id
     * @return
     */
    public List<XK> findByCoid(String id) {
        return xkDao.findStudentByCoid(id);
    }

    /**
     * 将学生从选课表中删除
     * @param sno
     */
    public void del(String sno) {
        xkDao.del(sno);
    }
}
