package cn.gsq.service.impl;

import cn.gsq.dao.ICourseDao;
import cn.gsq.domain.Course;
import cn.gsq.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    ICourseDao courseDao;
    @Override
    public Course findById(String id) {
        return courseDao.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
