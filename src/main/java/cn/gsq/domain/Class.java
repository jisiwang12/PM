package cn.gsq.domain;

public class Class {
    //班级编号
    private String cid;
    //班级名字
    private String cname;
    //年级
    private String grade;

    private String czyid;

    public String getCzyid() {
        return czyid;
    }

    public void setCzyid(String czyid) {
        this.czyid = czyid;
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
