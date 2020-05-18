package cn.gsq.service;

import cn.gsq.domain.Teacher;
import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;

import java.util.List;

public interface ITeacherService {

    List<Teacher> findAll(int page, int pageSize);

    Teacher findById(String id);

    void save(String name, String age, String sex, String yxid);

    public void update(String id, String name, String age, String sex, String yxid);

    void del(String id);
}
