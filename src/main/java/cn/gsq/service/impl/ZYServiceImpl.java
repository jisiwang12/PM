package cn.gsq.service.impl;

import cn.gsq.dao.IZYDao;
import cn.gsq.domain.ZY;
import cn.gsq.service.IZYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业
 */
@Service
public class ZYServiceImpl implements IZYService {
    @Autowired
    IZYDao izyDao;

    /**
     * 通过id查找
     * @param id
     * @return
     */
    @Override
    public ZY findById(String id) {

        return izyDao.findById(id);
    }

    /**
     * 查找全部
     * @return
     */
    @Override
    public List<ZY> findAll() {
        return izyDao.findAll();
    }
}
