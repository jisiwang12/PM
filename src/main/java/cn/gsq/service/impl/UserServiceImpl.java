package cn.gsq.service.impl;

import cn.gsq.dao.IUserDao;
import cn.gsq.domain.Role;
import cn.gsq.domain.UserInfo;
import cn.gsq.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IUserDao userDao;

    /**
     * 登录验证
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo =null;
        try {
            userInfo=userDao.findUserByUsername(s);
            System.out.println(userInfo.getuName());
            System.out.println(userInfo.getuPass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getuName(), userInfo.getuPass(),
                userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()) );
        return user;
    }

    /**
     * 获取用户的权限
     * @param roles
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role:roles
        ) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRole_Name()));
        }

        return list;
    }

    /**
     * 查找全部用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    /**
     * 保存用户
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        userInfo.setuPass(bCryptPasswordEncoder.encode(userInfo.getuPass()));
        userDao.save(userInfo);
    }

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(String id) {
        UserInfo byId = userDao.findById(id);
        return byId;
    }

    /**
     * 通过id删除用户
     * @param id
     */
    @Override
    public void del(String id) {
        userDao.del(id);
    }

    /**
     * 修改用户
     * @param userInfo
     */
    @Override
    public void update(UserInfo userInfo) {
        UserInfo byId = userDao.findById(userInfo.getId());
        if (!userInfo.getuPass().equals(byId.getuPass())) {
            userInfo.setuPass(bCryptPasswordEncoder.encode(userInfo.getuPass()));
        }
        userDao.update(userInfo);
    }

    /**
     * 用户更改个人密码
     * @param uname
     * @param old
     * @param newpw
     * @return
     * @throws Exception
     */
    @Override
    public boolean changePW(String uname, String old, String newpw) throws Exception {
        UserInfo userByUsername = userDao.findUserByUsername(uname);
        String pass = userByUsername.getuPass();
        boolean matches = bCryptPasswordEncoder.matches(old, pass);
        if (matches) {
            String encode = bCryptPasswordEncoder.encode(newpw);
            userDao.updatePw(uname,encode);
            return true;
        }
        return false;
    }


}
