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

    void save(String id, String cd, String kk);
}
