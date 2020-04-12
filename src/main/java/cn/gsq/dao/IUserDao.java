package cn.gsq.dao;

import cn.gsq.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 用户登录
 */
public interface IUserDao {
    /**
     * 通过username查找用户
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from user where uname=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uName", column = "uname"),
            @Result(property = "uPass", column = "upass"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "cn.gsq.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findUserByUsername(String username) throws Exception;

    /**
     * 找到所有用户
     *
     * @return
     */
    @Select("select * from user")
    public List<UserInfo> findAll();

    /**
     * 保存用户
     *
     * @param userInfo
     */
    @Insert("insert into user (uname,upass) VALUES (#{uName},#{uPass})")
    void save(UserInfo userInfo);

    /**
     * 通过用户id查找用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(id = true, property = "upass", column = "upass"),
            @Result(id = true, property = "uname", column = "uname")
    })
    UserInfo findById(String id);


}
