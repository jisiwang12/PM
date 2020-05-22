package cn.gsq.service;

import cn.gsq.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    void del(String id);

    void update(UserInfo userInfo);

    boolean changePW(String uname, String old, String newpw) throws Exception;
}
