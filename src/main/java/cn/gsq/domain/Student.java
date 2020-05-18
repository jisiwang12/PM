package cn.gsq.domain;

public class Student {
    //id
    private int id;
    //学号
    private String sNo;
    //姓名
    private String sName;
    //班级
    private String sClass;
    //性别
    private String sSex;

    private ZY zy;

    private YX yx;

    private Class classn;

    private String classid;
    private String zyid;
    private String yxid;
    private String age;
    private String phone;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getZyid() {
        return zyid;
    }

    public void setZyid(String zyid) {
        this.zyid = zyid;
    }

    public String getYxid() {
        return yxid;
    }

    public void setYxid(String yxid) {
        this.yxid = yxid;
    }

    public Class getClassn() {
        return classn;
    }

    public void setClassn(Class classn) {
        this.classn = classn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public ZY getZy() {
        return zy;
    }

    public void setZy(ZY zy) {
        this.zy = zy;
    }

    public YX getYx() {
        return yx;
    }

    public void setYx(YX yx) {
        this.yx = yx;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sNo='" + sNo + '\'' +
                ", sName='" + sName + '\'' +
                ", sClass='" + sClass + '\'' +
                ", sSex='" + sSex + '\'' +
                ", zy=" + zy +
                ", yx=" + yx +
                ", classn=" + classn +
                ", classid='" + classid + '\'' +
                ", zyid='" + zyid + '\'' +
                ", yxid='" + yxid + '\'' +
                '}';
    }
}
