package cn.gsq.dao;

import org.apache.ibatis.annotations.Insert;

public interface IRecordDao {


    @Insert("insert into record (ip) VALUES(#{ip}) ")
    public void save(String ip);


}
