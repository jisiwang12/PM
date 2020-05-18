package cn.gsq.dao;

import cn.gsq.domain.KQ;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考勤成绩
 * @author mechrevo
 */
public interface IKQDao {
    /**
     * 考勤查询所有
     * @return
     */
    @Select("select * from kq")
    @Results(id = "kqMap",value = {
            @Result(property = "kqid", column = "kqid", id = true),
            @Result(property = "sno", column = "ksno"),
            @Result(property = "cd", column = "cd"),
            @Result(column = "kk", property = "kk"),
            @Result(column = "kqsc", property = "kqscore"),
            @Result(column = "kcono", property = "cono"),
            @Result(property = "student",column = "ksno",  javaType = cn.gsq.domain.Student.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findBySno")),
            @Result(column = "kcono", property = "course", javaType = cn.gsq.domain.Course.class, one = @One(select =
                    "cn.gsq.dao.ICourseDao.findById"))
    })
    public List<KQ> findAll();

    //通过ID查询单个成绩
    @Select("select * from kq where kqid=#{id}")
    @ResultMap("kqMap")
    public KQ findById(String id);

    @Update("update kq set kq.cd=#{arg1},kq.kk=#{arg2},kqsc=#{arg3} where kq.kqid=#{arg0}")
    public void update(String id, String cd, String kq,int count);

    @Select("select * from kq")
    @Results({
            @Result(property = "kqid", column = "kqid", id = true),
            @Result(property = "sno", column = "ksno"),
            @Result(property = "sSex", column = "kcono"),
            @Result(column = "scid", property = "classn", javaType = cn.gsq.domain.Class.class, one = @One(select =
                    "cn.gsq.dao.StudentDao.findById_class")),
            @Result(column = "zyid", property = "zy", javaType = cn.gsq.domain.ZY.class, one = @One(select =
                    "cn.gsq.dao.StudentDao.findById_zy")),
            @Result(column = "syxid", property = "yx", javaType = cn.gsq.domain.YX.class, one = @One(select =
                    "cn.gsq.dao.StudentDao.findById_yx"))
    })
    public List<KQ> findBycoid(String id);


    @Insert("insert into kq ( ksno, kcono, cd, kk, kqsc) values (#{arg0},#{arg4},#{arg1},#{arg2},#{arg3})")
    void save(String sno, String cd, String kk, String kqscore, String cono);

    /**
     * 学生用户查询个人所有课程考勤成绩
     * @param sno

     * @return
     */
    @Select("select * from kq where ksno=#{sno}")
    @ResultMap("kqMap")
    List<KQ> findBySno(String sno);
}
