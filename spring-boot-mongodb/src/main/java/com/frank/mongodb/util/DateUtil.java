package com.frank.mongodb.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 *
 * @author cy
 * @version DateUtil.java, v 0.1 2021年07月14日 5:25 下午 cy Exp $
 */
public class DateUtil {

    /**
     * 获取格式化年、月、日
     * @return
     */
    public static String formatDate(String type, Date date) {
        if(StringUtils.isBlank(type)) {
            type = "DAY";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 当前日期
        Date newDate = date == null ? new Date() : date;
        if("DAY".equals(type)) {
            // 设置日期格式
            df = new SimpleDateFormat("yyyy-MM-dd");
        } else
        if("MONTH".equals(type)) {
            df = new SimpleDateFormat("yyyy-MM");
        } else
        if("YEAR".equals(type)) {
            df = new SimpleDateFormat("yyyy");
        }
        // new Date()为获取当前系统时间
        return df.format(newDate);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentTime() {
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        // new Date()为获取当前系统时间
        return df.format(new Date());
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentTimeYyyyMmDdHhMmSs(Date date) {
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        return df.format(date);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date getDate() {
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        try {
            return df.parse(getCurrentTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * 获取多少天前的数据
     * @param day
     * @return
     */
    public static Long getAfterDayTimestamp(int day) {
        BigDecimal bigDecimal = new BigDecimal(day);
        long longValue = bigDecimal.multiply(new BigDecimal(86400000)).longValue();
        return System.currentTimeMillis() - longValue;
    }

    /**
     * 获取多少天前的日期
     * @param day
     * @return
     */
    public static String getAfterDayDate(int day) {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        calendar1.add(Calendar.DATE, -day);
        String three_days_ago = sdf1.format(calendar1.getTime());
        return three_days_ago;
    }

    public static Date stringToDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date strToDateLong(String strDate) {
        Date strtodate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strtodate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strtodate;
    }

    /**
     * 生成随机时间
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    public static void main(String[] args) {
    }
}
