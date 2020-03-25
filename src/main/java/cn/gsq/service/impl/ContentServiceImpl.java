package cn.gsq.service.impl;

import cn.gsq.dao.IContentDao;
import cn.gsq.domain.Content;
import cn.gsq.service.IContentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements IContentService {
    @Autowired
    IContentDao contentDao;


    @Override
    public List<Content> findAllByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return contentDao.findAll();
    }

    @Override
    public List<Content> findAll() {
        return contentDao.findAll();
    }

    @Override
    public Content findById(String id) {
        return contentDao.findById(id);
    }

    @Override
    public void save(Content content) {
        contentDao.save(content);
    }

    @Override
    public List<Content> findRecommend() {
        return contentDao.findRecommend();
    }
}
