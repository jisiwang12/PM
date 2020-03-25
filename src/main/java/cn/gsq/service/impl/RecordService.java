package cn.gsq.service.impl;

import cn.gsq.dao.IRecordDao;
import cn.gsq.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService implements IRecordService {
    @Autowired
    IRecordDao recordDao;

    @Override
    public void save(String ip) {
        recordDao.save(ip);
    }
}
