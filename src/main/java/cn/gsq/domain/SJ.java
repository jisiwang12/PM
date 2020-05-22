package cn.gsq.domain;

public class SJ {
    private String id;
    private String sjcono;
    private String max;
    private String min;
    private String minlv;
    private String maxlv;
    private Course course;

    @Override
    public String toString() {
        return "SJ{" +
                "id='" + id + '\'' +
                ", sjcono='" + sjcono + '\'' +
                ", max='" + max + '\'' +
                ", min='" + min + '\'' +
                ", minlv='" + minlv + '\'' +
                ", maxlv='" + maxlv + '\'' +
                ", course=" + course +
                '}';
    }

    public String getMinlv() {
        return minlv;
    }

    public void setMinlv(String minlv) {
        this.minlv = minlv;
    }

    public String getMaxlv() {
        return maxlv;
    }

    public void setMaxlv(String maxlv) {
        this.maxlv = maxlv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSjcono() {
        return sjcono;
    }

    public void setSjcono(String sjcono) {
        this.sjcono = sjcono;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}


