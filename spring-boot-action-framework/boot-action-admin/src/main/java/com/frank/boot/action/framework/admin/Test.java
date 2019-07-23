package com.frank.boot.action.framework.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.boot.action.framework.admin、
 * @email: cy880708@163.com
 * @date: 2019/7/18 下午1:50
 * @mofified By:
 */
public class Test {

    public static void main(String[] args) {
        String dateString = "2019-07-18 11:57:00";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = fmt.parse(dateString);
            System.out.println(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
