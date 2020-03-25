package cn.gsq.service.impl;

import cn.gsq.dao.ILoginDao;
import cn.gsq.domain.User;
import cn.gsq.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    ILoginDao loginDao;
    @Override
    public User findUserByUname(String uName) {
        return loginDao.findUserByUname(uName);
    }
}
