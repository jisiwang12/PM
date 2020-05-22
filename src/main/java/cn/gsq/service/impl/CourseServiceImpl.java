package cn.gsq.service.impl;

import cn.gsq.dao.*;
import cn.gsq.domain.*;
import cn.gsq.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    ICourseDao courseDao;
    @Autowired
    IKQDao kqDao;
    @Autowired
    IWorkDao workDao;
    @Autowired
    IScoreDao scoreDao;
    @Autowired
    IXKDao xkDao;
    @Autowired
    ICJDao icjDao;
    @Autowired
    SJServiceImpl sjService;
    @Autowired
    ScoreServiceImpl scoreService;
    @Autowired
    ISJDao isjDao;
    @Override
    public Course findById(String id) {
        return courseDao.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public void update(Course course) {
        Course byId = courseDao.findById(course.getCoid());
        Work work = new Work();
        work.setFirst(0);
        work.setSecond(0);
        work.setThird(0);
        work.setWcono(byId.getCono());
        work.setWscore(0);
        Score score = new Score();
        score.setKq(100);
        score.setWork(0);
        score.setScore(0);
        score.setSj(0);
        score.setCono(byId.getCono());
        if (course.getStatus()==0) {
            List<XK> studentByCoid = xkDao.findStudentByCoid(course.getCoid());
            for (XK xk : studentByCoid) {
                String xsno = xk.getXsno();
                kqDao.save(xsno,"0","0","100",byId.getCono());
                work.setWsno(xsno);
                workDao.save(work);
                score.setSno(xsno);
                scoreDao.save(score);
            }
        }
        courseDao.update(course);
    }

    @Override
    public void save(Course course) {
        List<Course> allBydesc = courseDao.findAllBydesc();
        String cono = allBydesc.get(0).getCono();
        Integer i = Integer.parseInt(cono);
        i = i + 1;
        String s = i.toString();
        course.setCono(s);
        course.setStatus(1);
        courseDao.save(course);
    }

    public void del(String id) {
        courseDao.del(id);
    }


    public List<Course> findByTid(String tid) {
        return courseDao.findByTid(tid);

    }

    public void back(String id) {
        courseDao.back(id);
    }

    public void go(String id) {
        Course byCono = courseDao.findByCono(id);
        Integer status = byCono.getStatus();
        if (status == 0) {
            status = 2;
        } else {
            status += 1;
        }
        courseDao.go(id,status.toString());
    }

    /**
     * 院长审核成绩
     * @param id
     */
    public void go_yz(String id) {
        Course course = courseDao.findByCono(id);
        List<Score> scoreList = scoreDao.findByCono(id);
        Integer size1 = scoreList.size();
        float size = size1.floatValue();
        DecimalFormat df = new DecimalFormat("#");
        Float a=0F;
        Float al=0F;
        Float b=0F;
        Float bl=0F;
        Float c=0F;
        Float cl=0F;
        Float f=0F;
        Float fl=0F;
        Integer max=0;
        Integer min = 100;
        Float total = 0F;
        Float avg = 0F;
        for (Score score : scoreList) {
            Integer score1 = score.getScore();
            if (score1 >= max) {
                max = score1;
            }
            if (score1 <= min&&score1>=0) {
                min = score1;
            }
            if (score1 == -1) {
                total += 0;
            } else {
                total += score1;
            }
            if (score1 < 60) {
                f += 1;
            }
            if (score1 >= 80 && score1 < 90) {
                b += 1;
            }
            if (score1 >= 90) {
                a += 1;
            }

        }
        al = a / size*100;
        bl = b / size*100;
        fl = f / size*100;
        cl = 100 - fl;
        avg = total / size;
        CJ cj = new CJ();
        cj.setCjcono(id);
        cj.setA(df.format(al)+"%");
        cj.setB(df.format(bl) + "%");
        cj.setC(df.format(cl) + "%");
        cj.setF(df.format(fl) + "%");
        cj.setMax(max.toString());
        cj.setMin(min.toString());
        cj.setAvg(df.format(avg));
        SJ sj = new SJ();
        sj.setSjcono(id);
        isjDao.save(sj);
        icjDao.save(cj);
        courseDao.go(id,"5");
    }

    public Course findByCono(String id) {
        return courseDao.findByCono(id);
    }
}
