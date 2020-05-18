package cn.gsq.dao;

import cn.gsq.domain.Score;
import cn.gsq.domain.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 学生对应的所有成绩
 */
public interface IScoreDao {

    /**
     * 学生用户查询个人成绩
     * @param sno
     * @return
     */
    @Select("select * from score where sno=#{sno}")
    @Results(id = "scoreMap",value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sno", column = "sno"),
            @Result(property = "cono", column = "cono"),
            @Result(column = "kq", property = "kq"),
            @Result(column = "work", property = "work"),
            @Result(column = "sj", property = "sj"),
            @Result(column = "score", property = "score"),
            @Result(property = "student",column = "sno",  javaType = cn.gsq.domain.Student.class, one = @One(select =
                    "cn.gsq.dao.IStudentDao.findBySno")),
            @Result(column = "cono", property = "course", javaType = cn.gsq.domain.Course.class, one = @One(select =
                    "cn.gsq.dao.ICourseDao.findById"))
    })
    List<Score> findBySno(String sno);
}
