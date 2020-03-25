package cn.gsq.service.impl;

import cn.gsq.dao.IResourceDao;
import cn.gsq.domain.Resource;
import cn.gsq.service.IResourceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceServletImpl implements IResourceServlet {
    @Autowired
    IResourceDao resourceDao;
    @Override
    public List<Resource> findAll() {

        return resourceDao.findAll();
    }

    @Override
    public List<Resource> findByTag(String tag) {
        return resourceDao.findByTag(tag);
    }
}
