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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo =null;
        try {
            userInfo=userDao.findUserByUsername(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getuName(), userInfo.getuPass(),
                userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()) );
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role:roles
        ) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRole_Name()));
        }

        return list;
    }

    @Override
    public List<UserInfo> findAll(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setuPass(bCryptPasswordEncoder.encode(userInfo.getuPass()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo byId = userDao.findById(id);
        return byId;
    }

    @Override
    public void del(String id) {
        userDao.del(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfo.setuPass(bCryptPasswordEncoder.encode(userInfo.getuPass()));
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
