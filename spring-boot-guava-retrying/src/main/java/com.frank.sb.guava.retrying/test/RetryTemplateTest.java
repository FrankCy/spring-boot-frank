package com.frank.sb.guava.retrying.test;

/**
 *
 *
 * @author cy
 * @version $Id: RetryTemplateTest.java, v 0.1 2020年05月20日 10:19 cy Exp $
 */
public class RetryTemplateTest {

    public static void main(String[] args) {
        Object ans = null;
        try {
            ans = new RetryTemplate() {
                @Override
                protected Object doBiz() throws Exception {
                    int temp = (int) (Math.random() * 10);
                    System.out.println(temp);

                    if (temp > 3) {
                        throw new Exception("generate value bigger then 3! need retry");
                    }

                    return temp;
                }
            }.setRetryTime(10).setSleepTime(10).execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ans);
    }

}
