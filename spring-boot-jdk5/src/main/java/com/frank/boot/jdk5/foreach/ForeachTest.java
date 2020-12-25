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

    /***
     * 具体编译成什么类型还的根据循环数据实际的数据类型，例如：
     *
     * //int数组 foreach
     * int[] ints = new int[]{1, 2, 3, 4, 5};
     * for(int i : ints){
     *     System.out.println("i: " + i);
     * }
     *
     * //class反编译结果
     * int[] ints = new int[]{1, 2, 3, 4, 5};
     * int[] var9 = ints;
     * int var4 = ints.length;
     *
     * for(int var5 = 0; var5 < var4; ++var5) {
     *     int i = var9[var5];
     *     System.out.println("i: " + i);
     * }
     */

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
