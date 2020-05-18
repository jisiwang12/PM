package cn.gsq.dao;

import cn.gsq.domain.Class;
import cn.gsq.domain.Student;
import cn.gsq.domain.YX;
import cn.gsq.domain.ZY;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao {

    @Select("select * from yx where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "yxname",column = "yxname"),
    })
    public YX findById_yx(String id);

    @Select("select * from zy where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "zyname",column = "zyname")
    })
    public ZY findById_zy(String id);


@Select("SELECT * from class where cid=#{id}")
@Results({
        @Result(property = "cid", column = "cid", id = true),
        @Result(property = "cname",column = "cname"),
        @Result(property = "grade",column = "grade")
})
    public Class findById_class(String id);

    @Select("select * from student")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sNo", column = "Sno"),
            @Result(property = "sSex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "phone", column = "phone"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_class")),
            @Result(column = "zyid", property = "zy", javaType = cn.gsq.domain.ZY.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_zy")),
            @Result(column = "syxid", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    List<Student> findAll();

    @Select("select * from student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sNo", column = "Sno"),
            @Result(property = "sSex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "phone", column = "phone"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_class")),
            @Result(column = "zyid", property = "zy", javaType = cn.gsq.domain.ZY.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_zy")),
            @Result(column = "syxid", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    Student findById(String id);

    @Select("select * from student where sno=#{sno}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sNo", column = "Sno"),
            @Result(property = "sSex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "phone", column = "phone"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_class")),
            @Result(column = "zyid", property = "zy", javaType = cn.gsq.domain.ZY.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_zy")),
            @Result(column = "syxid", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    Student findBySno(String sno);
}
