package cn.gsq.dao;

import cn.gsq.domain.User11;
import org.apache.ibatis.annotations.Select;

public interface ILoginDao {
    @Select("select * from user where uname=#{uName}")
    User11 findUserByUname(String uName);
}
