package cn.gsq.domain;

//成绩
public class Score {
    private String sNo;
    private String sCNo;
    private String score;

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsCNo() {
        return sCNo;
    }

    public void setsCNo(String sCNo) {
        this.sCNo = sCNo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sNo='" + sNo + '\'' +
                ", sCNo='" + sCNo + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
