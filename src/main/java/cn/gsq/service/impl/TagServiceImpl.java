package cn.gsq.service.impl;

import cn.gsq.dao.ITagDao;
import cn.gsq.domain.Tag;
import cn.gsq.service.ITagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {
    @Autowired
    ITagDao tagDao;

    @Override
    public Tag findById(String id) {
        return tagDao.findById(id);
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }
}
