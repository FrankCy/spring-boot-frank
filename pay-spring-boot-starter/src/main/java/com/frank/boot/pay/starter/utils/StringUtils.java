package com.frank.boot.pay.starter.utils;

/**
 *
 *
 * @author cy
 * @version StringUtils.java, v 0.1 2020年09月07日 22:34 cy Exp $
 */
public class StringUtils {

    public StringUtils() {

    }

    /**
     * 判断两个值是否相等
     * @param key
     * @param equalsVal
     * @return
     */
    public static boolean equals(String key, String equalsVal) {
        if(equalsVal == null || equalsVal == "" || equalsVal.trim() == "") {
            return false;
        }

        if(!key.equals(equalsVal.trim())) {
            return false;
        }
        return true;
    }
}
