package cn.gsq.dao;

import cn.gsq.domain.YX;
import cn.gsq.domain.YXMS;
import cn.gsq.domain.YZ;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IYZDao {

    @Select("select * from yz")
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
    List<YZ> findAll();

    @Select("select * from yz where id=#{id}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result( property = "name",column = "name"),
            @Result( property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "yxid",column = "yx_id"),
            @Result(column = "yx_id", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    YZ findById(String id);

    @Insert("insert into yz (name, age, sex, yx_id,phone) value (#{name},#{age},#{sex},#{yxid},#{phone})")
    void save(YZ yz);

    @Update("update yz set name=#{name},age=#{age},sex=#{sex},yx_id=#{yxid},phone=#{phone} where id=#{id}")
    void update(YZ yz);

    @Delete("delete from yz where id=#{id}")
    void del(String id);
}
