package com.frank.boot.jdk5.formatoutput;

import java.util.Formatter;

/**
 *
 *
 * @author cy
 * @version FomartOutputTest.java, v 0.1 2020年12月25日 4:22 下午 cy Exp $
 */
public class FormatOutputTest {

    public static void main(String[] args) {
        // JDK5推出了printf-style格式字符串的解释器 java.util.Formatter 工具类，和C语言的printf()有些类似。
        // 创建对象时指定将结果输出到控制台
        Formatter formatter = new Formatter(System.out);
        formatter.format("x = %d , y = %s\n",1 , "test");
        formatter.close();

        /**
         *
         * Formatter类可以将一些特定风格的字符转换为另一种格式进行输出，给出一下常用格式转换。
         *
         * d	整数型
         * s	String
         * f	浮点数
         * c	Unicode字符
         * b	布尔值
         * e	科学计数
         * x	整数（16进制）
         * h	散列码（16进制）
         *
         *
         * System.out.printf 和 System.out.foramt 方法的格式化输出就是调用了Formatter工具类。其中System.out.printf 的源码实际就是调用用了System.out.foramt方法。
         *
         * System.out.printf 源码如下：
         * ====================================================================================
         * public PrintStream printf(String format, Object ... args) {
         *       return format(format, args);
         * }
         *
         */

    }

}
