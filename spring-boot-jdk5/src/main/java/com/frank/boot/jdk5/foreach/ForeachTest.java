package com.frank.boot.jdk5.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * foreach
 *
 * @author cy
 * @version ForeachTest.java, v 0.1 2020年12月11日 5:49 下午 cy Exp $
 */
public class ForeachTest {

    public static void beforeFor(List<String> testList) {
        for(int i=0; i<testList.size(); i++) {
            System.out.println(testList.get(i));
        }
    }

    public static void afterFor(List<String> testList) {
        for(String s : testList) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("1");
        testList.add("3");
        testList.add("asd");
        testList.add("fasf");
        testList.add("ggg");

        beforeFor(testList);

        System.out.println("------------------------");

        afterFor(testList);

    }

}
