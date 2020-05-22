package cn.gsq.domain;

public class CJ {
    private String id;
    private String cjcono;
    private String a;
    private String b;
    private String c;
    private String f;
    private String max;
    private String min;
    private String avg;
    private Course course;

    @Override
    public String toString() {
        return "CJ{" +
                "id='" + id + '\'' +
                ", cjcono='" + cjcono + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", f='" + f + '\'' +
                ", max='" + max + '\'' +
                ", min='" + min + '\'' +
                ", avg='" + avg + '\'' +
                ", course=" + course +
                '}';
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCjcono() {
        return cjcono;
    }

    public void setCjcono(String cjcono) {
        this.cjcono = cjcono;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }
}
