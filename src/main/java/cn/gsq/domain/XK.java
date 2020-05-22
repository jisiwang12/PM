package cn.gsq.domain;

public class XK {
    private String xsno;
    private String xcoid;
    private Student student;
    private Course course;

    public String getXsno() {
        return xsno;
    }

    public void setXsno(String xsno) {
        this.xsno = xsno;
    }

    public String getXcoid() {
        return xcoid;
    }

    public void setXcoid(String xcoid) {
        this.xcoid = xcoid;
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
