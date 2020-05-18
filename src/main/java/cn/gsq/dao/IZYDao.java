package cn.gsq.dao;

import cn.gsq.domain.ZY;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IZYDao {

    @Select("select * from zy where zy.id=#{id}")
    @Results({
        @Result(id = true,property = "id",column = "id"),
        @Result(property = "zyname",column = "zyname"),
        @Result(property = "yxid",column = "yxid"),
    })
    public ZY findById(String id);

    @Select("select * from zy")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "zyname",column = "zyname"),
            @Result(property = "yxid",column = "yxid"),
    })
    public List<ZY> findAll();

}
