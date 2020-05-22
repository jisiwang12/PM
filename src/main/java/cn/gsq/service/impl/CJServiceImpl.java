package cn.gsq.service.impl;

import cn.gsq.dao.ICJDao;
import cn.gsq.domain.CJ;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CJServiceImpl {

    @Autowired
    ICJDao cjDao;

    public CJ findByCono(String cono) {
      return   cjDao.findByCono(cono);
    }


    public void save(CJ cj) {
        cjDao.save(cj);

    }
}
