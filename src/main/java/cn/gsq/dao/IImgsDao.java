package cn.gsq.dao;

import cn.gsq.domain.Imgs;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 每篇文章相应的图片
 */
public interface IImgsDao {

    @Select("select * from imgs where cid=#{id}")
    List<Imgs> findAllById(String id);


}
