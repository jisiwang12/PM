package cn.gsq.dao;

import cn.gsq.domain.Class;
import cn.gsq.domain.Student;
import cn.gsq.domain.YX;
import cn.gsq.domain.ZY;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from student order by sno asc")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sNo", column = "Sno"),
            @Result(property = "sSex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "scid", column = "scid"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IClassDao.findById")),
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
            @Result(property = "scid", column = "scid"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IClassDao.findById")),
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
            @Result(property = "scid", column = "scid"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IClassDao.findById")),
            @Result(column = "zyid", property = "zy", javaType = cn.gsq.domain.ZY.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_zy")),
            @Result(column = "syxid", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    Student findBySno(String sno);

    @Insert("insert into student (sno, sname, sex, zyid, syxid, scid,age,phone) VALUES (#{arg0},#{arg1},#{arg2},#{arg3},#{arg4},#{arg5},#{arg6},#{arg7})")
    void save(String sNo, String sName, String sSex, String zyid, String yxid,String classid,String age,String phone);

    @Select("select * from student where scid=#{cid} order by sno desc")
    List<Student> findByCid(String cid);

    @Delete("delete from student where id=#{id}")
    void del(String id);

    @Update("update student set sno=#{arg1},sname=#{arg2},sex=#{arg3},syxid=#{arg6},zyid=#{arg5},scid=#{arg4},age=#{arg7},phone=#{arg8} where id=#{arg0}")
    void update(String id, String sNo, String sName, String sSex, String classid, String zyid, String yxid,String age,String phone);
}
