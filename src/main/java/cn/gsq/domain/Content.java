package cn.gsq.domain;


import cn.gsq.utils.DateUtil;

import java.util.Date;
import java.util.List;

public class Content {
    private String id;
    private String title;
    private String short_text;
    private String text;
    private Date time;
    private String timeStr;
    private String firstImg;
    private List<Imgs> imgs;
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Imgs> getImgs() {
        return imgs;
    }

    public void setImgs(List<Imgs> imgs) {
        this.imgs = imgs;
    }

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }



    public String getTimeStr() {
        String s = DateUtil.DateToStr(time, "yyyy-MM-dd HH:mm:ss");
        return s;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_text() {
        return short_text;
    }

    public void setShort_text(String short_text) {
        this.short_text = short_text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", short_text='" + short_text + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", timeStr='" + timeStr + '\'' +
                ", firstImg='" + firstImg + '\'' +
                ", imgs=" + imgs +
                ", tag=" + tag +
                '}';
    }
}
