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
                    "cn.gsq.dao.ICourseDao.findByCono"))
    })
    List<Score> findBySno(String sno);


    @Insert("insert into score(sno, cono, kq, work, sj, score) VALUES (#{sno},#{cono},#{kq},#{work},#{sj},#{score})")
    void save(Score score);

    @Update("update score set kq=#{arg2},score=0 where sno=#{arg0} and cono=#{arg1}")
    void savekq(String sno, String cono, int count);

    @Update("update score set kq=0,score=-1 where sno=#{arg0} and cono=#{arg1}")
    void savekq3(String sno, String cono, int count);

    @Update("update score set work=#{arg2} where sno=#{arg0} and cono=#{arg1}")
    void savework(String sno, String cono, int count);


    @Select("select * from score where cono=#{id} order by sno asc")
    @ResultMap("scoreMap")
    List<Score> findByCono(String id);


    @Update("update score set sj=#{sj},score=#{score} where id=#{id}")
    void update(Score score);

    @Select("select * from score where id=#{id}")
    @ResultMap("scoreMap")
    Score findById(String id);
}
