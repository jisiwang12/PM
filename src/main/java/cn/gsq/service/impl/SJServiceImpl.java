package cn.gsq.service.impl;

import cn.gsq.dao.ISJDao;
import cn.gsq.domain.SJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SJServiceImpl {

    @Autowired
    ISJDao sjDao;
    public SJ findByCono(String id) {
        return sjDao.findByCono(id);
    }

    public List<SJ> findAll() {
        return sjDao.findAll();
    }

    public void save(SJ sj) {
        sjDao.save(sj);
    }

    public void update(SJ sj) {
        sjDao.update(sj);
    }

    public void del(String id) {
        sjDao.del(id);
    }

    public SJ findByID(String id) {
        return sjDao.findById(id);
    }
}
