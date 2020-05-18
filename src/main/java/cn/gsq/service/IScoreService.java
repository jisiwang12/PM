package cn.gsq.service;

import cn.gsq.domain.Score;

import java.util.List;

public interface IScoreService {

    public List<Score> findBySno(String sno);

    public List<Score> findByTime(String sno, String time);
}
