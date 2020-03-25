package cn.gsq.domain;

/**
 * 考勤实体类
 * @author mechrevo
 */
public class KQ {
    //学号
    private String sno;
    //学生姓名
    private String cname;
    //班级
    private String sname;
    //课程名字
    private String coname;
    //迟到次数
    private Integer cd;
    //旷课次数
    private Integer kk;
    //分数
    private Integer kqscore;
    //考勤ID
    private Integer kqid;

    public Integer getKqid() {
        return kqid;
    }

    public void setKqid(Integer kqid) {
        this.kqid = kqid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public Integer getCd() {
        return cd;
    }

    public void setCd(Integer cd) {
        this.cd = cd;
    }

    public Integer getKk() {
        return kk;
    }

    public void setKk(Integer kk) {
        this.kk = kk;
    }

    public Integer getKqscore() {
        return kqscore;
    }

    public void setKqscore(Integer kqscore) {
        this.kqscore = kqscore;
    }

    @Override
    public String toString() {
        return "KQ{" +
                "sno='" + sno + '\'' +
                ", cname='" + cname + '\'' +
                ", sname='" + sname + '\'' +
                ", coname='" + coname + '\'' +
                ", cd=" + cd +
                ", kk=" + kk +
                ", kqscore=" + kqscore +
                ", kqid=" + kqid +
                '}';
    }
}
