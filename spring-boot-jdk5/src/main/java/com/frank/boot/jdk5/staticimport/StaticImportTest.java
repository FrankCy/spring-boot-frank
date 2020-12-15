package com.frank.boot.jdk5.staticimport;

import static java.lang.System.out;
import static java.lang.Math.*;

/**
 *
 * 静态导入可以将静态方法和静态变量通过 import static 和导包一样的方式直接导入，使用的时候无需使用类名即可直接访问
 *
 * @author cy
 * @version StaticImportTest.java, v 0.1 2020年12月11日 5:53 下午 cy Exp $
 */
public class StaticImportTest {

    public static void main(String[] args) {
        out.println("max(3,5) :" + max(3,5));
        out.println("random :" + random());
    }

}
