package cn.gsq.domain;

public class YXZR {
    private String id;
    private String name;
    private String sex;
    private String age;
    private YX yx;
    private int yxid;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public YX getYx() {
        return yx;
    }

    public void setYx(YX yx) {
        this.yx = yx;
    }

    public int getYxid() {
        return yxid;
    }

    public void setYxid(int yxid) {
        this.yxid = yxid;
    }
}
