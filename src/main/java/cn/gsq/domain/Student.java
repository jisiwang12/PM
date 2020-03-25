package cn.gsq.domain;

public class Student {
    //学号
    private String sNo;
    //姓名
    private String sName;
    //班级
    private String sClass;
    //性别
    private String sSex;

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo='" + sNo + '\'' +
                ", sName='" + sName + '\'' +
                ", sClass='" + sClass + '\'' +
                ", sSex='" + sSex + '\'' +
                '}';
    }
}
