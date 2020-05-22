package cn.gsq.service.impl;

import cn.gsq.dao.IRoleDao;
import cn.gsq.domain.Role;
import cn.gsq.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
