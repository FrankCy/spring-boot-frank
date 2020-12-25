package com.frank.boot.jdk5.varars;

/**
 *
 *
 * @author cy
 * @version VarArsTest.java, v 0.1 2020年12月04日 5:05 下午 cy Exp $
 */
public class VarArsTest {

    /**
     * Tips: 和以往main方式不一样，一般这样写 public static void main（String[] args）
     * @param args
     */
    public static void main(String... args) {
        varArgs(1);
        System.out.println("------------");
        varArgs(1,2);
        // ......
        System.out.println("------------");
        varArgs(1,2,3,4,5,6,7,8,9,0);
        System.out.println("------------");
    }

    /**
     * 可变参数的格式： 数据类型... 参数名
     * @param ints
     */
    public static void varArgs(int... ints) {
        for(int i:ints) {
            System.out.println(i);
        }
    }

}
