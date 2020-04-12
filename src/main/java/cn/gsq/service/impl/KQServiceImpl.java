package cn.gsq.service.impl;

import cn.gsq.dao.IKQDao;
import cn.gsq.dao.IScoreDao;
import cn.gsq.domain.KQ;
import cn.gsq.service.IKQService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 考勤查询
 */
@Service
public class KQServiceImpl implements IKQService {
    @Autowired
    IKQDao kqDao;
    @Autowired
    IScoreDao scoreDao;
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<KQ> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return kqDao.findAll();
    }

    @Override
    public KQ findById(String id) {
        return kqDao.findById(id);
    }

    /**
     * 保存
     * @param id
     * @param cd
     * @param kk
     */
    @Override
    public void save(String id, String cd, String kk) {
        int count = 100;
        if (Integer.parseInt(kk) >= 3) {
            count = 0;
        } else {
            for (int i = 1; i <=Integer.parseInt(kk); i++) {
                count-=10;
            }
            for (int i = 1; i <=Integer.parseInt(cd) ; i++) {
                count-=5;
            }
        }
        scoreDao.updateKq(id,count);
        kqDao.save(id,cd,kk,count);
    }
}
