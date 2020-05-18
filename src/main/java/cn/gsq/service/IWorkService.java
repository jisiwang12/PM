package cn.gsq.service;



import cn.gsq.domain.Work;

import java.util.List;

public interface IWorkService {

    public List<Work> findBySno(String sno);

    public List<Work> findByTime(String sno, String time);


}
