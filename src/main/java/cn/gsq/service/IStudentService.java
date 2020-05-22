package cn.gsq.service;

import cn.gsq.domain.Student;

import java.util.List;

public interface IStudentService {


    public void save(String sName, String sSex, String classid, String age, String phone);

    void update(String id,String sNo, String sName, String sSex, String classid, String age, String phone);

    List<Student> findAll();

    void del(String id) throws Exception;
}
