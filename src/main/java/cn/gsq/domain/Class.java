package cn.gsq.domain;

public class Class {
    //班级编号
    private String cSNo;
    //班级名字
    private String cName;
    //所属学院
    private String cSchool;

    public String getcSNo() {
        return cSNo;
    }

    public void setcSNo(String cSNo) {
        this.cSNo = cSNo;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcSchool() {
        return cSchool;
    }

    public void setcSchool(String cSchool) {
        this.cSchool = cSchool;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cSNo='" + cSNo + '\'' +
                ", cName='" + cName + '\'' +
                ", cSchool='" + cSchool + '\'' +
                '}';
    }
}
