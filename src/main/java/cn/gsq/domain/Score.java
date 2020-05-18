package cn.gsq.domain;

//成绩
public class Score {
    //总成绩ID
    private Integer id;
    //学号
    private String sno;
    //课程id
    private String cono;
    //考勤分数
    private Integer kq;
    //课程作业分数
    private Integer work;
    //试卷分数
    private Integer sj;
    //总成绩
    private Integer score;

    private Student student;

    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public Integer getKq() {
        return kq;
    }

    public void setKq(Integer kq) {
        this.kq = kq;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Integer getSj() {
        return sj;
    }

    public void setSj(Integer sj) {
        this.sj = sj;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
