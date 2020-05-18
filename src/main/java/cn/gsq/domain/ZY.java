package cn.gsq.domain;

public class ZY {
    private String id;
    private String zyname;
    private String yxid;

    public String getYxid() {
        return yxid;
    }

    public void setYxid(String yxid) {
        this.yxid = yxid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZyname() {
        return zyname;
    }

    public void setZyname(String zyname) {
        this.zyname = zyname;
    }

    @Override
    public String toString() {
        return "ZY{" +
                "id='" + id + '\'' +
                ", zyname='" + zyname + '\'' +
                '}';
    }
}
