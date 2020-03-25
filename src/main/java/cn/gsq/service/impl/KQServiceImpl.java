package cn.gsq.service.impl;

import cn.gsq.dao.IKQDao;
import cn.gsq.domain.KQ;
import cn.gsq.service.IKQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KQServiceImpl implements IKQService {
    @Autowired
    IKQDao kqDao;

    @Override
    public List<KQ> findAll() {
        return kqDao.findAll();
    }

    @Override
    public KQ findById(String id) {
        return kqDao.findById(id);
    }

    @Override
    public void save(String id, String cd, String kk) {
        kqDao.save(id,cd,kk);
    }
}
