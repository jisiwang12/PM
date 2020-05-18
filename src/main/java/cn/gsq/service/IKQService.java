package cn.gsq.service;

import cn.gsq.domain.KQ;

import java.util.List;

/**
 * 考勤
 *
 * @author mechrevo
 */
public interface IKQService {
    public List<KQ> findAll(int page,int pageSize);

    KQ findById(String id);

    void update(String id, String cd, String kk);

    void save(String sno, String cd, String kk, String kqscore, String cono);

    List<KQ> findBySno(String sno);

    List<KQ> findByTime(String time, String sno);
}
