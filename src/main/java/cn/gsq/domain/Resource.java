package cn.gsq.domain;

/**
 * 资源分享
 */
public class Resource {
    private Integer id;
    private String title;
    private String text;
    private String path;
    private String tag;
    private String img;
    private String tagStr;

    public String getTagStr() {
        if ("book".equals(tag)) {
            return "源码";
        }
        if ("utils".equals(tag)) {
            return "电子书";
        }
        if ("code".equals(tag)) {
            return "源码";
        }
        return tag;
    }

    public void setTagStr(String tagStr) {
        this.tagStr = tagStr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", path='" + path + '\'' +
                ", tag='" + tag + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
