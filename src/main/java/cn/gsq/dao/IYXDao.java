package cn.gsq.dao;

import cn.gsq.domain.YX;
import cn.gsq.domain.ZY;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IYXDao {
    @Select("select * from yx where yx.id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "yxname",column = "yxname")
    })
    public YX findById(String id);

    @Select("select * from yx")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "yxname",column = "yxname")
    })
    public List<YX> findAll();
}
