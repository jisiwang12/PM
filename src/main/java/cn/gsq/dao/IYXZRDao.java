package cn.gsq.dao;

import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;
import cn.gsq.domain.YXZR;
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
            @Result(column = "yx_id", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    List<YXZR> findAll();

    @Select("select * from yxzr where id=#{id}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result( property = "name",column = "name"),
            @Result( property = "sex",column = "sex"),
            @Result( property = "phone",column = "phone"),
            @Result(property = "age",column = "age"),
            @Result(property = "yxid",column = "yx_id"),
            @Result(column = "yx_id", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    YXZR findById(String id);

    @Insert("insert into yxzr (name, age, sex, yx_id,phone) value (#{name},#{age},#{sex},#{yxid},#{phone})")
    void save(YXZR yxzr);

    @Update("update yxzr set name=#{name},age=#{age},sex=#{sex},yx_id=#{yxid},phone=#{phone} where id=#{id}")
    void update(YXZR yxzr);

    @Delete("delete from yxzr where id=#{id}")
    void del(String id);
}
