package cn.gsq.dao;

import org.apache.ibatis.annotations.Update;

/**
 * 学生对应的所有成绩
 */
public interface IScoreDao {
    /**
     * 更新考勤成绩
     * @param id
     * @param count
     */
    @Update("update score set score.kqscore=#{arg1} where score.sckqid=#{arg0}")
    public void updateKq(String id, int count);
}
