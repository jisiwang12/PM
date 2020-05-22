package cn.gsq.service.impl;

import cn.gsq.dao.IScoreDao;
import cn.gsq.domain.KQ;
import cn.gsq.domain.Score;
import cn.gsq.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生总成绩
 */
@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    IScoreDao scoreDao;



    public List<Score> findByCono(String id) {
        return scoreDao.findByCono(id);

    }

    public void update(Score score) {
        Integer kq = score.getKq();
        Integer work = score.getWork();
        Integer sj = score.getSj();
        Integer sscore = (kq * 2+ work * 2 + sj * 6)/10;
        score.setScore(sscore);
        scoreDao.update(score);
    }

    /**
     * 学生用户通过学号查询成绩
     * @param sno
     * @return
     */
    @Override
    public List<Score> findBySno(String sno) {
        return scoreDao.findBySno(sno);
    }

    /**
     * 学生用户通过学期查询成绩
     * @param sno
     * @param time
     * @return
     */
    @Override
    public List<Score> findByTime(String sno, String time) {
        List<Score> bySno = scoreDao.findBySno(sno);
        ArrayList<Score> scoreList = new ArrayList<>();
        for (Score score : bySno) {
            System.out.println("开始了");
            System.out.println(score.getCourse().getTime());
            if (score.getCourse().getTime().equals(time)) {

                scoreList.add(score);
            }
        }
        return scoreList;
    }


    public Score findById(String id) {
        return scoreDao.findById(id);
    }
}
