package com.frank.boot.jdk5.varars;

/**
 *
 *
 * @author cy
 * @version VarArsTest.java, v 0.1 2020年12月04日 5:05 下午 cy Exp $
 */
public class VarArsTest {

    public static void varArs(int... ints) {
        for(int i:ints) {
            System.out.println(i);
        }
    }

    public static void main(String... args) {
        varArs(1);
        System.out.println("------------");
        varArs(1,2);
        System.out.println("------------");
        varArs(1,2,3,4,5,6,7,8,9,0);
        System.out.println("------------");
    }
}
