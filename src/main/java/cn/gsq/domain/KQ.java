package cn.gsq.domain;

/**
 * 考勤实体类
 * @author mechrevo
 */
public class KQ {
    //考勤ID
    private Integer kqid;
    //学号
    private String sno;
    //课程id
    private String cono;
    //迟到次数
    private Integer cd;
    //旷课次数
    private Integer kk;
    //分数
    private Integer kqscore;

    private Student student;

    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

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
                "kqid=" + kqid +
                ", sno='" + sno + '\'' +
                ", cono='" + cono + '\'' +
                ", cd=" + cd +
                ", kk=" + kk +
                ", kqscore=" + kqscore +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
