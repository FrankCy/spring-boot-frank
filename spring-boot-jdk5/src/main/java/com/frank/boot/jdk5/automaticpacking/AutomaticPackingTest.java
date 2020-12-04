package com.frank.boot.jdk5.automaticpacking;

/**
 *
 *
 * @author cy
 * @version AutomaticpackingTest.java, v 0.1 2020年12月04日 5:10 下午 cy Exp $
 */
public class AutomaticPackingTest {

    /**
     * jdk5之前的拆装箱
     */
    public static void before() {
        // int 转换 Integer
        int i=10;
        Integer integer = new Integer(i);

        // Integer 转换 int
        Integer integer1 = new Integer(10);
        int i1 = integer1.intValue();
    }

    /**
     * jdk5新特性：自动拆装箱
     */
    public static void after() {
        // int 转换 Integer
        Integer integer = 10;

        // Integer 转换 int（可直接将Integer赋值给int）
        int i = integer;
    }

    /**
     * jdk5是如何做的呢？
     *
     * --------------------------------------------
     * 将class反编译可以看出自动拆装箱的代码如下：
     * Integer integer = Integer.valueOf(10);
     * int i = integer.intValue();
     *
     *
     *
     */

    public static void main(String... args) {

    }

}
