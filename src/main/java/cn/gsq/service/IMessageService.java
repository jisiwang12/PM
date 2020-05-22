package cn.gsq.service;

import cn.gsq.domain.Student;

import java.util.List;

public interface IMessageService {

    public List<Student> findAll_stu(int page,int pageSize);

    List<Student> findAll_stu();

    public void update(String id, String sNo, String sName, String sSex, String classid,String age,String phone);

    public void update_stu(String id,String phone);



    void del(String id);
}
