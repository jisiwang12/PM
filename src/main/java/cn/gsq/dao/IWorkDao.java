package cn.gsq.dao;

import cn.gsq.domain.KQ;
import cn.gsq.domain.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IWorkDao {
    /**
     * 通过学号查询课程
     * @param sno
     * @return
     */
@Select("select * from work where wsno=#{sno}")
@Results(id = "workMap",value = {
        @Result(property = "id", column = "id", id = true),
        @Result(property = "wsno", column = "wsno"),
        @Result(property = "wcono", column = "wcono"),
        @Result(column = "1st", property = "first"),
        @Result(column = "2nd", property = "second"),
        @Result(column = "3rd", property = "third"),
        @Result(column = "wscore", property = "wscore"),
        @Result(property = "student",column = "wsno",  javaType = cn.gsq.domain.Student.class, one = @One(select =
                "cn.gsq.dao.IStudentDao.findBySno")),
        @Result(column = "wcono", property = "course", javaType = cn.gsq.domain.Course.class, one = @One(select =
                "cn.gsq.dao.ICourseDao.findByCono"))
})
    List<Work> findBySno(String sno);

@Insert("insert into work(wsno, wcono, `1st`, `2nd`, `3rd`, wscore) VALUES (#{wsno},#{wcono},#{first},#{second},#{third},#{wscore})")
    void save(Work work);

    @Select("select * from work where wcono=#{id} order by wsno asc")
    @ResultMap("workMap")
    List<Work> findByCono(String id);

    @Select("select * from work where id=#{arg0}")
    @ResultMap("workMap")
    Work findById(String id);

    @Update("update work set `1st`=#{first},`2nd`=#{second},`3rd`=#{third}, wscore=#{wscore} where id=#{id}")
    void update(Work work);

}
