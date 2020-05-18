package cn.gsq.domain;

public class YX {
    private String id;
    private String yxname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYxname() {
        return yxname;
    }

    public void setYxname(String yxname) {
        this.yxname = yxname;
    }

    @Override
    public String toString() {
        return "YX{" +
                "id='" + id + '\'' +
                ", yxname='" + yxname + '\'' +
                '}';
    }
}
