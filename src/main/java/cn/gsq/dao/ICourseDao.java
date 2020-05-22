package cn.gsq.dao;

import cn.gsq.domain.Course;
import cn.gsq.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICourseDao {

    @Select("select * from course where coid=#{id}")
    @Results(id = "courseMap", value = {
            @Result(id = true, property = "coid", column = "coid"),
            @Result(property = "cono", column = "cono"),
            @Result(property = "xf", column = "xf"),
            @Result(property = "coname", column = "coname"),
            @Result(property = "tid", column = "tid"),
            @Result(property = "time", column = "time"),
            @Result(property = "status", column = "status"),
            @Result(property = "teacher", column = "tid", javaType = cn.gsq.domain.Teacher.class, one = @One(select =
                    "cn.gsq.dao.ITeacherDao.findById"))
    })
    public Course findById(String id);


    @Select("select *from course order by time asc ")
    @ResultMap("courseMap")
    public List<Course> findAll();

    @Select("select *from course order by cono desc ")
    @ResultMap("courseMap")
    public List<Course> findAllBydesc();

    @Delete("delete from course where coid=#{id}")
    public void del(String id);

    @Update("update course set status=#{status},xf=#{xf},coname=#{coname},time=#{time},tid=#{tid} where coid=#{coid}")
    public void update(Course course);

    @Insert("insert into course (cono,xf, coname, tid, time,status) values (#{cono},#{xf},#{coname},#{tid},#{time},#{status})")
    void save(Course course);


    @Select("select * from course where cono=#{cono}")
    @ResultMap("courseMap")
    public Course findByCono(String cono);

    @Select("select * from course where tid=#{tid} order by time asc")
    @ResultMap("courseMap")
    public List<Course> findByTid(String tid);


    @Update("update course set status=1 where cono=#{id}")
    void back(String id);

    @Update("update course set status=#{arg1} where cono=#{arg0}")
    void go(String id,String status);


}
