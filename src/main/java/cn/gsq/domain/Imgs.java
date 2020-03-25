package cn.gsq.domain;

public class Imgs {
    private String id;
    private String imgPath;
    private String cid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Imgs{" +
                "id='" + id + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
