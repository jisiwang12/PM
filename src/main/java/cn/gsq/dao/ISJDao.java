package cn.gsq.dao;

import cn.gsq.domain.SJ;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISJDao {




    @Select("select * from sj where sjcono=#{arg0}")
    @Results(id = "sjMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sjcono", column = "sjcono"),
            @Result(column = "max", property = "max"),
            @Result(column = "min", property = "min"),
            @Result(column = "maxlv", property = "maxlv"),
            @Result(column = "minlv", property = "minlv"),
            @Result(column = "sjcono", property = "course", javaType = cn.gsq.domain.Course.class, one = @One(select =
                    "cn.gsq.dao.ICourseDao.findByCono"))
    })
    public SJ findByCono(String id);

    @Select("select * from cj;")
    @ResultMap("sjMap")
    public List<SJ> findAll();

    @Update("update sj set max=#{max},min=#{min},maxlv=#{maxlv},minlv=#{minlv} where id=#{id}")
    public void update(SJ sj);

    @Insert("insert into sj(sjcono, max, min, maxlv, minlv) VALUES (#{sjcono},#{max},#{min},#{maxlv},#{minlv})")
    public void save(SJ sj);

    @Delete("delete from sj where id=#{id}")
    public void del(String id);

    @Select("select * from sj where id=#{id}")
    @ResultMap("sjMap")
    public SJ findById(String id);
}
