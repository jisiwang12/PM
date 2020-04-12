package cn.gsq.dao;

import cn.gsq.domain.KQ;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("select kq.kqid,student.sno,class.cname,student.sname,course.coname,kq.cd,kq.kk,score.kqscore " +
            "from student,kq,class,course,score " +
            "where student.sno=score.sno and student.sno=kq.ksno")
    public List<KQ> findAll();

    //通过ID查询单个成绩
    @Select("select kq.kqid,student.sno,student.sname,course.coname,kq.cd,kq.kk from kq,course,student where student.sno=kq.ksno and " +
            "kq.kqid=#{id}")
    public KQ findById(String id);

    @Update("update kq set kq.cd=#{arg1},kq.kk=#{arg2} where kq.kqid=#{arg0}")
    public void save(String id, String cd, String kk,int count);
}
