package cn.gsq.dao;

import cn.gsq.domain.Class;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IClassDao {

    @Select("select * from class")
    @Results({
            @Result(property = "cid", column = "cid", id = true),
            @Result(property = "cname", column = "cname"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "czyid", column = "czyid")
    })
    public List<Class> findAll();

    @Select("select * from class where cid=#{id}")
    @Results({
            @Result(property = "cid", column = "cid", id = true),
            @Result(property = "cname", column = "cname"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "czyid", column = "czyid")
    })
    public Class findById(String id);



}
