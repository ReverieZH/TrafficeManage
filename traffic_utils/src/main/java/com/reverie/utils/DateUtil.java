package com.reverie.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    /**
     * 获取系统当前时间字符串
     *
     * @return 系统当前时间 格式"yyyy-MM-dd HH:mm:ss"
     */
    public static String getCurrentTimeStr() {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        return ft.format(dNow);
    }

    /**
     * 获取系统当前日期字符串
     *
     * @return 系统当前时间 格式"yyyyMMdd"
     */
    public static String getCurrentDateStr() {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
        return ft.format(dNow);
    }


    /**
     * 获取系统当前时间
     *
     * @return 系统当前时间
     */
    public static String getCurrentTime() {
        Date date = new Date();
        String stringDate = String.format("%tF %<tT", date);
        return stringDate;
    }

    /**
     * @param formatString 格式，如"yyyy-MM-dd"
     * @param stringDate   日期字符串，如"2000-03-19"
     * @return 日期
     * @throws ParseException 解析异常
     */
    public static Date getDateByFormatString(String formatString, String stringDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(formatString);
        Date date = dateFormat.parse(stringDate);
        return date;
    }

    /**
     * 格式化date
     *
     * @param formatString 格式，如"yyyy-MM-dd"
     * @param stringDate   日期字符串，如"2000-03-19"
     * @return SQL日期
     * @throws ParseException 解析异常
     */
    public static java.sql.Date getSqlDateByFormatString(String formatString, String stringDate) throws ParseException {
        long longtime = DateUtil.getDateByFormatString("yyyy-MM-dd hh:mm:ss", stringDate).getTime();
        return new java.sql.Date(longtime);
    }

    /**
     * 两个日期相差天数
     *
     * @param preDate   第一个时间日期
     * @param afterDate 第二个时间十七
     * @return 相差的天数
     */
    public static int getDifferentDays(Date preDate, Date afterDate) {

        int preYear = getYear(preDate);
        int afterYear = getYear(afterDate);
        int preDayOfYear = getDayOfYear(preDate);
        int afterDayOfYear = getDayOfYear(afterDate);

        if (afterYear - preYear == 0) {
            return afterDayOfYear - preDayOfYear;
        } else {
            int diffDay = 0;
            while (preYear < afterYear) {
                if (diffDay == 0 && isLeapYear(preYear)) {
                    diffDay = 366 - preDayOfYear;
                } else if (diffDay == 0 && !isLeapYear(preYear)) {
                    diffDay = 365 - preDayOfYear;
                } else if (isLeapYear(preYear)) {
                    diffDay += 366;
                } else {
                    diffDay += 365;
                }
                preYear++;
            }

            diffDay += afterDayOfYear;
            return diffDay;

        }


    }

    /**
     * 一年中的第几天
     *
     * @param date 日期
     * @return 第几天
     */
    public static int getDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_YEAR);
        return day;
    }

    /**
     * 获取年份
     * jdk推荐写法，date.getYear()已被废弃
     *
     * @param date 日期
     * @return 年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 判断是否是闰年
     *
     * @param year 年，如2010
     * @return 是否闰年
     */
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0)
                || year % 400 == 0) {
            return true;
        }
        return false;
    }

    /**
    * @Description: 数据库操作时间
    * @Param:
    * @return:
    * @Date:
    */
    public static java.sql.Date getSqlDate() throws ParseException {
        return DateUtil.getSqlDateByFormatString("yyyy-MM-dd HH:mm:ss SSS", DateUtil.getCurrentTime());
    }


    /**
    * @Description:  得到N年后的日期
    * @Date:
    * @Author:
    */
    public static String getBeforeAfterDate(String datestr, int year) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date olddate = null;
        String time=df.format(new Date().getTime());
        try {
            df.setLenient(false);
            olddate = new java.util.Date(df.parse(datestr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误");
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(olddate);

        int Year = cal.get(Calendar.YEAR);
        int Month = cal.get(Calendar.MONTH);
        int Day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        int NewYear = Year + year;

        cal.set(Calendar.YEAR, NewYear);
        cal.set(Calendar.MONTH, Month);
        cal.set(Calendar.DAY_OF_MONTH, Day);
        cal.set(Calendar.HOUR, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);

//        return new java.util.Date(cal.getTimeInMillis()).toString();
        return df.format(cal.getTimeInMillis());
    }

}
