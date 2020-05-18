package cn.gsq.dao;

import cn.gsq.domain.Work;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
                "cn.gsq.dao.ICourseDao.findById"))
})
    List<Work> findBySno(String sno);
}
