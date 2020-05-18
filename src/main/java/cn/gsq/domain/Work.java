package cn.gsq.domain;

public class Work {
    //作业ID
    private Integer id;
    //学号
    private String wsno;
    //课程id
    private String wcono;
    //第一次成绩
    private Integer first;
    //第二次成绩
    private Integer second;
    //第三次成绩
    private Integer third;

    //作业总成绩
    private Integer wscore;
    //学生
    private Student student;
    //课程
    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWsno() {
        return wsno;
    }

    public void setWsno(String wsno) {
        this.wsno = wsno;
    }

    public String getWcono() {
        return wcono;
    }

    public void setWcono(String wcono) {
        this.wcono = wcono;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getThird() {
        return third;
    }

    public void setThird(Integer third) {
        this.third = third;
    }

    public Integer getWscore() {
        return wscore;
    }

    public void setWscore(Integer wscore) {
        this.wscore = wscore;
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
