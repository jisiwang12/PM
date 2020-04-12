package cn.gsq.service;

import cn.gsq.domain.User11;

public interface ILoginService {
    User11 findUserByUname(String uName);
}
