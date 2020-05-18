package cn.gsq.dao;

import cn.gsq.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMessageDao {

    @Select("select * from student")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sNo", column = "Sno"),
            @Result(property = "sSex", column = "sex"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_class")),
            @Result(column = "zyid", property = "zy", javaType = cn.gsq.domain.ZY.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_zy")),
            @Result(column = "syxid", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    List<Student> findAll_stu();

    @Select("select * from student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sNo", column = "Sno"),
            @Result(property = "sSex", column = "sex"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_class")),
            @Result(column = "zyid", property = "zy", javaType = cn.gsq.domain.ZY.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_zy")),
            @Result(column = "syxid", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findById_yx"))
    })
    Student findById_stu(String id);

    /**
     * 管理员用户
     * @param id
     * @param sNo
     * @param sName
     * @param sSex
     * @param classid
     * @param zyid
     * @param yxid
     * @param age
     * @param phone
     */
    @Update("update student set sno=#{arg1},sname=#{arg2},sex=#{arg3},syxid=#{arg6},zyid=#{arg5},scid=#{arg4},age=#{arg7},phone=#{arg8} where id=#{arg0}")
    void update(String id, String sNo, String sName, String sSex, String classid, String zyid, String yxid,String age,String phone);

    /**
     * 学生用户使用
     * @param id
     * @param phone
     */
    @Update("update student set phone=#{arg1} where id=#{arg0}")
    void update_stu(String id,String phone);

    @Insert("insert into student (sno, sname, sex, zyid, syxid, scid,age,phone) VALUES (#{arg0},#{arg1},#{arg2},#{arg3},#{arg4},#{arg5},#{arg6},#{arg7})")
    void save(String sNo, String sName, String sSex, String zyid, String yxid,String classid,String age,String phone);

    @Delete("delete from student where id=#{id}")
    void del(String id);
}
