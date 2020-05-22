package cn.gsq.service;

import cn.gsq.domain.Course;

import java.util.List;

public interface ICourseService {

    public Course findById(String id);
    public List<Course> findAll();

    void update(Course course);

    void save(Course course);
}
