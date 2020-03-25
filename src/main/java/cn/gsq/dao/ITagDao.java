package cn.gsq.dao;

import cn.gsq.domain.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 标签
 * @author mechrevo
 */
public interface ITagDao {

    @Select("select * from tag where id=#{id}")
    public Tag findById(String id);

    @Select("select * from tag")
    List<Tag> findAll();
}
