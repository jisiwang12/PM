package cn.gsq.dao;

import cn.gsq.domain.Teacher;
import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITeacherDao {

    @Select("select * from teacher")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result( property = "name",column = "name"),
            @Result( property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "yxid",column = "tyx"),
            @Result(column = "tyx", property = "yx", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    List<Teacher> findAll();

    @Select("select * from teacher where id=#{id}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result( property = "name",column = "name"),
            @Result( property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "yxid",column = "tyx"),
            @Result(column = "tyx", property = "yx", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    Teacher findById(String id);

    @Insert("insert into teacher (name, age, sex, tyx,phone) value (#{arg0},#{arg1},#{arg2},#{arg3},#{arg4})")
    void save(String name, String age, String sex, String yxid,String phone);

    @Update("update teacher set name=#{arg1},age=#{arg2},sex=#{arg3},tyx=#{arg4},phone=#{arg5} where id=#{arg0}")
    void update(String id, String name, String age, String sex, String yxid,String phone);

    @Delete("delete from teacher where id=#{id}")
    void del(String id);

    @Update("update teacher set phone=#{arg1} where id=#{arg0}")
    void update_teacher(String id,String phone);
}
