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
    @Select("select * from user where uname=#{arg0}")
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
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "rid",javaType = java.util.List.class,
                    many = @Many(select = "cn.gsq.dao.IRoleDao.findRoleById"))
    })
    public List<UserInfo> findAll();

    /**
     * 保存用户
     *
     * @param userInfo
     */
    @Insert("insert into user (uname,upass,status,rid) VALUES (#{uName},#{uPass},#{status},#{rid})")
    void save(UserInfo userInfo);

    /**
     * 通过用户id查找用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{arg0}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(id = true, property = "uPass", column = "upass"),
            @Result(id = true, property = "uName", column = "uname"),
            @Result(id = true, property = "status", column = "status"),
            @Result(property = "roles",column = "rid",javaType = java.util.List.class,
                    many = @Many(select = "cn.gsq.dao.IRoleDao.findRoleById"))
    })
    UserInfo findById(String id);

    @Delete("delete from user where id=#{arg0}")
    public void del(String id);

    @Update("update user set upass=#{uPass},status=#{status},rid=#{rid},uname=#{uName} where id=#{id}")
            public void update(UserInfo userInfo);

    /**
     * 学生的账号名修改
     * @param sNo
     */
    @Update("update user set sno")
    public void changeSno(String sNo);

    @Update("update user set upass=#{arg1} where uname=#{arg0}")
    void updatePw(String uname, String newpw);
}
