package cn.gsq.dao;

import cn.gsq.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface ILoginDao {
    @Select("select * from user where uname=#{uName}")
    User findUserByUname(String uName);
}
