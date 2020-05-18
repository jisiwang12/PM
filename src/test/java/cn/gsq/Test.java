package cn.gsq;

import java.util.HashSet;

public class Test {
    @org.junit.Test
    public void findBySno() {
        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("2");
        for (String set : strings) {
            System.out.println(set);
        }
    }
}
