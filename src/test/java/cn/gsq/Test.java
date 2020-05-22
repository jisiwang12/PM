package cn.gsq;

import cn.gsq.domain.CJ;
import cn.gsq.domain.Course;
import cn.gsq.domain.Score;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test {
    @org.junit.Test
    public void findBySno() {
        Float size = 10F;
        DecimalFormat df = new DecimalFormat("#");
        Float a=0F;
        Float al=0F;
        Float b=0F;
        Float bl=0F;
        Float c=0F;
        Float cl=0F;
        Float f=0F;
        Float fl=0F;
        Integer max=0;
        Integer min = 100;
        Float total = 0F;
        Float avg = 0F;
        ArrayList<Score> scoreList = new ArrayList<>();
        Score score2 = new Score();
        score2.setScore(100);
        Score score3 = new Score();
        score3.setScore(90);
        Score score4 = new Score();
        score4.setScore(55);
        Score score5 = new Score();
        score5.setScore(70);
        scoreList.add(score2);
        scoreList.add(score3);
        scoreList.add(score4);
        scoreList.add(score5);
        for (Score score : scoreList) {
            Integer score1 = score.getScore();
            if (score1 >= max) {
                max = score1;
            }
            if (score1 <= min&&score1>=0) {
                min = score1;
            }
            if (score1 == -1) {
                total += 0;
            } else {
                total += score1;
            }
            if (score1 < 60) {
                f += 1;
            }
            if (score1 >= 80 && score1 < 90) {
                b += 1;
            }
            if (score1 >= 90) {
                a += 1;
            }

        }
        al = a / size*100;
        bl = b / size*100;
        fl = f / size*100;
        cl = 100 - fl;
        avg = total / size;
        CJ cj = new CJ();
        cj.setA(df.format(al)+"%");
        cj.setB(df.format(bl) + "%");
        cj.setC(df.format(cl) + "%");
        cj.setF(df.format(fl) + "%");
        cj.setMax(max.toString());
        cj.setMin(min.toString());
        cj.setAvg(df.format(avg));
        System.out.println(cj);

    }
}
