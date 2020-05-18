package cn.gsq.dao;

import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IYXZRDao {

    @Select("select * from yxzr")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result( property = "name",column = "name"),
            @Result( property = "sex",column = "sex"),
            @Result( property = "phone",column = "phone"),
            @Result(property = "age",column = "age"),
            @Result(property = "yxid",column = "yx_id"),
            @Result(column = "yx_id", property = "yx", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    List<YXMS> findAll();

    @Select("select * from yxzr where id=#{id}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result( property = "name",column = "name"),
            @Result( property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "yxid",column = "yx_id"),
            @Result(column = "yx", property = "yx", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    YXMS findById(String id);

    @Insert("insert into yxzr (name, age, sex, yx_id) value (#{arg0},#{arg1},#{arg2},#{arg3})")
    void save(String name, String age, String sex, String yxid);

    @Update("update yxzr set name=#{arg1},age=#{arg2},sex=#{arg3},yx_id=#{arg4} where id=#{arg0}")
    void update(String id, String name, String age, String sex, String yxid);

    @Delete("delete from yxzr where id=#{id}")
    void del(String id);
}
