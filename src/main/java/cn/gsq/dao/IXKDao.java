package cn.gsq.dao;

import cn.gsq.domain.XK;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IXKDao {

    @Select("select * from xk where xcoid=#{coid} order by xsno asc")
    @Results(id = "xkMap", value = {
            @Result(id = true, property = "xsno", column = "xsno"),
            @Result(property = "xcoid", column = "xcoid"),
            @Result(property = "student", column = "xsno", javaType = cn.gsq.domain.Student.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findBySno")),
            @Result(property = "course", column = "xcoid", javaType = cn.gsq.domain.Course.class, one = @One(select =
                    "cn.gsq.dao.ICourseDao.findById"))
    })
    List<XK> findStudentByCoid(String coid);


    @Insert("insert into xk(xsno, xcoid) VALUES (#{xsno},#{xcoid})")
    void save(XK xk);

    @Delete("delete from xk where xsno=#{sno}")
    void del(String sno);

}
