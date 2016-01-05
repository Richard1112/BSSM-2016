package com.org.bssm.base.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.org.bssm.base.common.CommonConstants;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtil {

    public static final String YEARS = "years";
    public static final String MONTH = "month";
    public static final String WEEK = "week";
    public static final String DAY = "day";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public static final String SECOND = "second";
    static final DateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    static final DateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    static final String DEFAULT_TIME_FORMAT_DB = "yyyyMMddHHmmss";

    public static final DateFormat STANDARD_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @SuppressWarnings("deprecation")
    public static int DateDiff(Date date1, Date date2, String opt) {
        int res = -1;
        if (StringUtil.isNullOrEmpty(opt) || date1 == null || date2 == null) {
            return res;
        }
        if (DAY.equals(opt)) {
            res = (int) ((date1.getTime() - date2.getTime()) / (1000 * 24 * 60 * 60));
        } else if (WEEK.equals(opt)) {
            res = (int) ((date1.getTime() - date2.getTime()) / (1000 * 7 * 24 * 60 * 60));
        } else if (MONTH.equals(opt)) {
            res = (date1.getYear() - date2.getYear()) * 12 + date1.getMonth() - date2.getMonth();
        } else if (YEARS.equals(opt)) {
            res = date1.getYear() - date2.getYear();
        } else {
            return -1;
        }
        return res;
    }

    /**
     * 功能描述: <br>
     * 获取date对应的milliseconds值
     * 
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 功能描述: <br>
     * 获取date的YYYY-MM-DD
     * 
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static synchronized String formateDateStr(Date date) {
        return formateDate(date, YYYY_MM_DD);
    }

    /**
     * 功能描述: <br>
     * 获取date的YYYY-MM-DD
     * 
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static synchronized String formateDateTimeStr(Date date) {
        return formateDate(date, STANDARD_FORMAT);
    }

    /**
     * 功能描述: <br>
     * 获取date的YYYYMMDD
     * 
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static synchronized String getDateStr(Date date) {
        return formateDate(date, YYYYMMDD);
    }

    /**
     * 功能描述: <br>
     * 根据dateFormat类型，获取date的对应日期格式
     * 
     * @param date
     * @param dateFormat
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String formateDate(Date date, DateFormat dateFormat) {
        return dateFormat.format(date);
    }

    /**
     * 功能描述: <br>
     * 时间对日进行加
     * 
     * @param nowTime 原时间
     * @param day 天数
     * @return 原时间 + 天数
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date addDate(Date nowTime, int day) {

        Calendar c = Calendar.getInstance();
        c.setTime(nowTime);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    /**
     * 功能描述: <br>
     * 获取时间的年、月、日、时、分、秒
     * 
     * @param time
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, String> getSeparateTimes(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        Map<String, String> map = new HashMap<String, String>();
        map.put(YEARS, String.valueOf(cal.get(Calendar.YEAR)));
        map.put(MONTH, StringUtil.leftFillZero(String.valueOf(cal.get(Calendar.MONTH) + 1), CommonConstants.TWO));
        map.put(DAY, StringUtil.leftFillZero(String.valueOf(cal.get(Calendar.DATE)), CommonConstants.TWO));
        map.put(HOUR, StringUtil.leftFillZero(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)), CommonConstants.TWO));
        map.put(MINUTE, StringUtil.leftFillZero(String.valueOf(cal.get(Calendar.MINUTE)), CommonConstants.TWO));
        map.put(SECOND, StringUtil.leftFillZero(String.valueOf(cal.get(Calendar.SECOND)), CommonConstants.TWO));
        return map;
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param date 时间
     * @return YYY-MM-DD 00：00：00格式的时间
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date formateDate(Date date) {
        String time = formateDate(date, YYYY_MM_DD) + " 00:00:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(time, pos);
    }

    /**
     * 取得格式化的服务器时间
     * 
     * @param timeFormat 时间：yyyyMMddHHmmss；日期：yyyyMMdd
     * @return String
     */
    public static String getServerTime(String timeFormat) {
        String format = (timeFormat == null) ? DEFAULT_TIME_FORMAT_DB : timeFormat;

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(getServerTime());
    }

    /**
     * 取得格式化的服务器时间
     * 
     * @param timeFormat 时间：yyyyMMddHHmmss；日期：yyyyMMdd
     * @return String
     */
    public static Date getServerTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    private DateUtil() {
    }

    /**
     * 功能描述: <br>
     * 计算年龄
     * 
     * @param birthDate
     * @return
     */
    public static int ageDiff(Date birthDate) {
        int age = -1;
        try {
            age = (DateUtil.DateDiff(DateUtil.getServerTime(), birthDate, DateUtil.DAY) - DateUtil.DateDiff(
                    DateUtil.getServerTime(), birthDate, DateUtil.YEARS) / 4) / 365;
        } catch (Exception e) {
            return -1;
        }
        return age > 0 ? age : -1;

    }

    /**
     * 返回指定时间的自定义格式String
     * 
     * @param date java.util.Date
     * @param dateFormat 自定义支持的格式有： yyyy-MM-dd HH:mm:ss yyyy年MM月dd日 HH时mm分ss秒 yyyy年MM月dd日 HH时mm分 yyyy-MM-dd HH:mm
     *            yyyyMMddHH:mm:ss yyyy-MM-dd yyyyMMdd HHmmss yyyy年MM月dd日 HH:mm:ss" HH时mm分ss秒 ......(很多)
     * @return 自定义格式的日期
     */
    public static String getDefinableTime(Date date, String dateFormat) {
        if (null == date || null == dateFormat || "".equals(dateFormat.trim())) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取当前时间， 日期类型
     * 
     * @return java.util.Date
     */
    public static Date getCurrentDate() {
        return new Date();
    }
    /**
     * 获取当前时间，字符串类型，格式（yyyy-mm-dd）
     * 
     * @return String
     */
    public static String getCurrentDateString() {
        return getDateFormatStr("yyyy-MM-dd");
    }
    /**
     * 获取当前日期字符串
     * 
     * @param formart 日期格式
     * @return 当前日期字符串
     */
    public static String getDateFormatStr(String formart) {
        return new SimpleDateFormat(formart).format(new java.util.Date());
    }
    
    /**
     * 将指定日期转换成指定格式的字符串
     * 
     * @param date 日期
     * @param pattern 日期格式
     * @return 转换后的日期字符串
     */
    public static String dateToString(Date date, String pattern) {
        return getDateParser(pattern).format(date);
    }    

    /**
     * 提供日期格式化工具
     * 
     * @param pattern 日期格式
     * @return 格式化工具类
     */
    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }
}
