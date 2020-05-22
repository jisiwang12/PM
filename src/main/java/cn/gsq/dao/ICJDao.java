package cn.gsq.dao;

import cn.gsq.domain.CJ;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICJDao {


    @Select("select * from cj where cjcono=#{cono}")
    @Results(id = "cjMap",value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "cjcono", column = "cjcono"),
            @Result(property = "a", column = "a"),
            @Result(column = "b", property = "b"),
            @Result(column = "c", property = "c"),
            @Result(column = "f", property = "f"),
            @Result(column = "max", property = "max"),
            @Result(column = "min", property = "min"),
            @Result(column = "avg", property = "avg"),
            @Result(column = "cjcono", property = "course", javaType = cn.gsq.domain.Course.class, one = @One(select =
                    "cn.gsq.dao.ICourseDao.findByCono"))
    })
    public CJ findByCono(String cono);

    @Insert("insert into cj (cjcono, a, b, c, f, max, min, avg) values (#{cjcono},#{a},#{b},#{c},#{f},#{max},#{min},#{avg})")
    public void save(CJ cj) ;
}
