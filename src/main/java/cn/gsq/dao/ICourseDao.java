package cn.gsq.dao;

import cn.gsq.domain.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICourseDao {

    @Select("select * from course where coid=#{id}")
    @Results(id = "courseMap",value = {
            @Result(id = true,property = "id",column = "coid"),
            @Result(property = "cono",column = "cono"),
            @Result(property = "xf",column = "xf"),
            @Result(property = "coname",column = "coname"),
            @Result(property = "time",column = "time"),
            @Result(property = "teacher",column = "tid",  javaType = cn.gsq.domain.Teacher.class, one = @One(select =
                    "cn.gsq.dao.ITeacherDao.findById"))
    })
    public Course findById(String id);


    @Select("select *from course")
    @ResultMap("courseMap")
    public List<Course> findAll();

}
