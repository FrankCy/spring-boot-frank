package com.frank.sb.guava.retrying.test;

/**
 *
 *
 * @author cy
 * @version $Id: Test.java, v 0.1 2020年05月19日 16:26 cy Exp $
 */
public class Test {
    public static void main(String[] args) {
        GuavaRetryingTest guavaRetryingTest = new GuavaRetryingTest();
        try {
            guavaRetryingTest.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
