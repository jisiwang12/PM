package cn.gsq.service.impl;

import cn.gsq.dao.IKQDao;
import cn.gsq.dao.IScoreDao;
import cn.gsq.domain.KQ;
import cn.gsq.service.IKQService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 考勤查询
 */
@Service
public class KQServiceImpl implements IKQService {
    @Autowired
    IKQDao kqDao;
    @Autowired
    IScoreDao scoreDao;
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<KQ> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return kqDao.findAll();
    }

    @Override
    public KQ findById(String id) {
        return kqDao.findById(id);
    }

    @Override
    public void update(String id, String cd, String kk) {
        int count = 100;
        if (Integer.parseInt(kk) >= 3) {
            count = 0;
        } else {
            for (int i = 1; i <=Integer.parseInt(kk); i++) {
                count-=10;
            }
            for (int i = 1; i <=Integer.parseInt(cd) ; i++) {
                count-=5;
            }
        }
        kqDao.update(id,cd,kk,count);
    }

    /**
     * 教师录入学生成绩
     * @param cd
     * @param kk
     */
    @Override
    public void save(String sno, String cd, String kk,String kqscore,String cono) {
        int count = 100;
        if (Integer.parseInt(kk) >= 3) {
            count = 0;
        } else {
            for (int i = 1; i <=Integer.parseInt(kk); i++) {
                count-=10;
            }
            for (int i = 1; i <=Integer.parseInt(cd) ; i++) {
                count-=5;
            }
        }
        kqDao.save(sno,cd,kk,kqscore,cono);
    }


    /**
     * 学生用户按学期查询成绩
     * @param time
     * @param sno
     * @return
     */
    @Override
    public List<KQ> findByTime(String sno, String time) {
        List<KQ> bySno = kqDao.findBySno(sno);
        ArrayList<KQ> kqList = new ArrayList<>();
        for (KQ kq : bySno) {
            System.out.println("开始了");
            System.out.println(kq.getCourse().getTime());
            if (kq.getCourse().getTime().equals(time)) {

                kqList.add(kq);
            }
        }
        return kqList;
    }

    /**
     * 通过学号查询个人考勤成绩不分页
     * @param sno
     * @return
     */
    @Override
    public List<KQ> findBySno(String sno) {
        return kqDao.findBySno(sno);
    }
}
