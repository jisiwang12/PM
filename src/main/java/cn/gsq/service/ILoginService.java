package cn.gsq.service;

import cn.gsq.domain.User;

public interface ILoginService {
    User findUserByUname(String uName);
}
