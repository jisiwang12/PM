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
            @Result(id = true, property = "status", column = "status"),
            @Result(property = "roles",column = "rid",javaType = java.util.List.class,
                    many = @Many(select = "cn.gsq.dao.IRoleDao.findRoleById"))
    })
    public UserInfo findUserByUsername(String username) throws Exception;

    /**
     * 找到所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "uName",column = "uname"),
            @Result(property = "uPass",column = "upass"),
            @Result(property = "status", column = "status")
    })
    public List<UserInfo> findAll();

    /**
     * 保存用户
     *
     * @param userInfo
     */
    @Insert("insert into user (uname,upass,status) VALUES (#{uName},#{uPass},#{status})")
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
            @Result(id = true, property = "uPass", column = "upass"),
            @Result(id = true, property = "uName", column = "uname"),
            @Result(id = true, property = "status", column = "status")
    })
    UserInfo findById(String id);

    @Delete("delete from user where id=#{id}")
    public void del(String id);

    @Update("update user set upass=#{uPass},status=#{status} where id=#{id}")
            public void update(UserInfo userInfo);


    @Update("update user set upass=#{arg1} where uname=#{arg0}")
    void updatePw(String uname,String newpw);
}
