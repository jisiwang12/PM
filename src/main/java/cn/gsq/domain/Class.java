package cn.gsq.domain;

public class Class {
    //班级编号
    private String cid;
    //班级名字
    private String cname;
    //年级
    private String grade;

    private String zyid;

    public String getZyid() {
        return zyid;
    }

    public void setZyid(String zyid) {
        this.zyid = zyid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
