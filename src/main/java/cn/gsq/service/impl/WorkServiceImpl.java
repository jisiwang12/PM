package cn.gsq.service.impl;

import cn.gsq.dao.IWorkDao;
import cn.gsq.domain.KQ;
import cn.gsq.domain.Work;
import cn.gsq.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WorkServiceImpl implements IWorkService {

    @Autowired
    IWorkDao workDao;
    /**
     * 学生用户查成绩
     * @param sno
     * @return
     */
    @Override
    public List<Work> findBySno(String sno) {
        return workDao.findBySno(sno);
    }


    /**
     * 学生用户通过学期查成绩
     * @param sno
     * @param time
     * @return
     */
    @Override
    public List<Work> findByTime(String sno, String time) {
        List<Work> bySno = workDao.findBySno(sno);
        ArrayList<Work> workList = new ArrayList<>();
        for (Work work : bySno) {
            System.out.println(work.getCourse().getTime());
            if (work.getCourse().getTime().equals(time)) {
                workList.add(work);
            }
        }
        return workList;
    }
}
