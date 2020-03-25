package cn.gsq.dao;

import cn.gsq.domain.Resource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 分享资源
 */
public interface IResourceDao {
    /**
     * 查询resource表所有
     *
     * @return
     */
    @Select("select * from resource")
    List<Resource> findAll();

    /**
     * 通过tag查询resource表
     */
    @Select("select * from resource where tag=#{tag}")
    List<Resource> findByTag(String tag);
}
