package com.cnic.datachain.common.util;


import com.cnic.datachain.common.exception.CommonsException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期时间工具类
 */
public abstract class DateTimeUtil {

	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";

	public static final String CUSTOM_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";

	public static final String DATETIME_FORMAT_CN = "yyyy年MM月dd日 HH时mm分ss秒";

    public static long getDayRemain(Date currentDate, Date openDate){
        long interval = openDate.getTime() - currentDate.getTime();
        long day = interval/(24*3600*1000);
        return day;
    }

    public static long getHourRemain(Date currentDate, Date openDate){
        long interval = openDate.getTime() - currentDate.getTime();
        interval = interval%(24*3600*1000);
        long hour = interval/(3600*1000);
        return hour;
    }

    public static long getMinuteRemain(Date currentDate, Date openDate){
        long interval = openDate.getTime() - currentDate.getTime();
        interval = interval%(24*3600*1000)%(3600*1000);
        long minute = interval/(60*1000);
        return minute;
    }

    /**
     * 获取N天之后的日期
     * @param interval
     * @return
     */
    public static Date getNDaysAfterDate(Integer interval) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, interval);
        return now.getTime();
    }

    /**
     * 获取给定日期N天之后的日期
     * @param interval
     * @param fromDate
     * @return
     */
    public static Date getNDaysAfterDay(Integer interval, Date fromDate) {
        Calendar now = Calendar.getInstance();
        now.setTime(fromDate);
        now.add(Calendar.DATE, interval);
        return now.getTime();
    }

    /**
     * 获取30天之前的日期
     * @return
     */
    public static Date get30DaysAgoDate() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, -29);
        return now.getTime();
    }

	/**
	 * 将一个 Date 格式化为日期/时间字符串
	 * 
	 * @param date 日期
	 * @param pattern 描述日期和时间格式的模式
	 * @return String 日期/时间字符串
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将一个 Calendar 格式化为日期/时间字符串
	 * 
	 * @param calendar 日期
	 * @param pattern 描述日期和时间格式的模式
	 * @return String 日期/时间字符串
	 */
	public static String dateToString(Calendar calendar, String pattern) {
		return dateToString(calendarToDate(calendar), pattern);
	}

	/**
	 * 将一个 Date 格式化为日期字符串,格式yyyy-MM-dd
	 * 
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String getDateString(Date date) {
		if (date == null) {
			date = new Date();
		}
		return dateToString(date, ISO_DATE_FORMAT);
	}

	/**
	 * 将一个 Calendar 格式化为日期字符串,格式yyyy-MM-dd
	 * 
	 * @param calendar 日期
	 * @return 日期字符串
	 */
	public static String getDateString(Calendar calendar) {
		if (calendar == null) {
			calendar = Calendar.getInstance();
		}
		return dateToString(calendar, ISO_DATE_FORMAT);
	}

	/**
	 * 将一个 Date 格式化为日期+时间字符串,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date 日期
	 * @return 日期+时间字符串
	 */
	public static String getDateTimeString(Date date) {
		if (date == null) {
			throw new CommonsException("日期参数为空,请检查.");
		}
		return dateToString(date, CUSTOM_DATETIME_FORMAT);
	}

	/**
	 * 将一个 Calendar 格式化为日期+时间字符串,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param calendar 日期
	 * @return 日期+时间字符串
	 */
	public static String getDateTimeString(Calendar calendar) {
		return getDateTimeString(calendar.getTime());
	}

	/**
	 * 获得当前日期字符串,格式yyyy-MM-dd
	 * 
	 * @return 当前日期字符串
	 */
	public static String getCurrentDateString() {
		return getDateString(new Date());
	}

	/**
	 * 获得当前日期+时间字符串,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return 当前日期+时间字符串
	 */
	public static String getCurrentDateTimeString() {
		return getDateTimeString(new Date());
	}

	/**
	 * 从给定字符串的开始解析文本,以生成一个 Date。该方法不使用给定字符串的整个文本
	 * 
	 * @param date 一个 String,应从其开始处进行解析
	 * @param pattern 描述日期和时间格式的模式
	 * @return 解析字符串得到的 Date
	 * @throws ParseException 解析异常,如果无法解析指定字符串的开始处
	 */
	public static Date stringToDate(String date, String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(date);
	}

	/**
	 * 从给定字符串的开始解析文本,以生成一个 Calendar。该方法不使用给定字符串的整个文本
	 *
	 * @param date 一个 String,应从其开始处进行解析
	 * @param pattern 描述日期和时间格式的模式
	 * @return 解析字符串得到的 Calendar
	 * @throws ParseException 解析异常,如果无法解析指定字符串的开始处
	 */
	public static Calendar stringToCalendar(String date, String pattern) throws ParseException {
		return dateToCalendar(stringToDate(date, pattern));
	}

	/**
	 * 获取当前时间的 Timestamp
	 * 
	 * @return Timestamp
	 */
	public static Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 将一个 Timestamp 格式化为日期/时间字符串
	 * 
	 * @param timestamp 时间戳
	 * @param pattern 描述日期和时间格式的模式
	 * @return 日期/时间字符串
	 */
	public static String timestampToString(Timestamp timestamp, String pattern) {
		return dateToString(timestamp, pattern);
	}

	/**
	 * 根据 Calendar 计算该日期是星期几
	 * 
	 * @param calendar
	 * @return 星期
	 */
	public static String getWeek(Calendar calendar) {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayNames[dayOfWeek - 1];
	}

	/**
	 * 根据 Date 计算该日期是星期几
	 * 
	 * @param date
	 * @return 星期
	 */
	public static String getWeek(Date date) {
		return getWeek(dateToCalendar(date));
	}

	/**
	 * Date 类型转换为 Calendar 类型
	 * 
	 * @param date
	 * @return Calendar
	 */
	public static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * Calendar 类型转换为 Date 类型
	 * 
	 * @param calendar
	 * @return Date
	 */
	public static Date calendarToDate(Calendar calendar) {
		return calendar.getTime();
	}

	/**
	 * 根据 Calendar 获取该日期为当年第几天
	 * 
	 * @param calendar
	 * @return int
	 */
	public static int getDayOfYear(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 根据 Date 获取该日期为当年第几天
	 * 
	 * @param date
	 * @return int
	 */
	public static int getDayOfYear(Date date) {
		Calendar calendar = dateToCalendar(date);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取年份
	 * 
	 * @param calendar
	 * @return int
	 */
	public static int getYear(Calendar calendar) {
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取今年年份
	 * 
	 * @return 今年
	 */
	public static int getCurrentYear() {
		return getYear(Calendar.getInstance());
	}

	/**
	 * 获取明年年份
	 * 
	 * @return 明年
	 */
	public static int getNextYear() {
		return getCurrentYear() + 1;
	}

	/**
	 * 获取去年年份
	 * 
	 * @return 去年
	 */
	public static int getLastYear() {
		return getCurrentYear() - 1;
	}

	/**
	 * 判断是否为闰年
	 * 
	 * @return boolean true:闰年;false:非闰年
	 */
	public static boolean isLeapYear(Calendar calendar) {
		int year = getYear(calendar);
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
