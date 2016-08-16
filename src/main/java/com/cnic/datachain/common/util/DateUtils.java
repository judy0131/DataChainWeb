package com.cnic.datachain.common.util;

import com.cnic.datachain.common.exception.CommonsException;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期时间工具类
 * 
 * <p>
 * 使用效率更高,线程安全的 Apache Commons-Lang FastDateFormat 实现.
 * 
 * @see org.apache.commons.lang3.time.FastDateFormat
 * @author gzb
 * @version 1.0.0 , 2010-05-17
 */
public abstract class DateUtils {

	public static final String[] DATE_PARSE_PATTERNS = { DateTimeUtil.ISO_DATE_FORMAT,
			DateTimeUtil.CUSTOM_DATETIME_FORMAT };

	/**
	 * 将一个 Date 格式化为日期/时间字符串
	 * 
	 * @param date 日期
	 * @param pattern 描述日期和时间格式的模式
	 * @return String 日期/时间字符串
	 */
	public static String dateToString(Date date, String pattern) {
		FastDateFormat format = FastDateFormat.getInstance(pattern);
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
		FastDateFormat format = FastDateFormat.getInstance(pattern);
		return format.format(calendar);
	}

	/**
	 * 将一个 Date 格式化为日期字符串,格式yyyy-MM-dd
	 * 
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String getDateString(Date date) {
		return dateToString(date, DateTimeUtil.ISO_DATE_FORMAT);
	}

	/**
	 * 将一个 Calendar 格式化为日期字符串,格式yyyy-MM-dd
	 * 
	 * @param calendar 日期
	 * @return 日期字符串
	 */
	public static String getDateString(Calendar calendar) {
		return dateToString(calendar, DateTimeUtil.ISO_DATE_FORMAT);
	}

	/**
	 * 将一个 Date 格式化为日期+时间字符串,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date 日期
	 * @return 日期+时间字符串
	 */
	public static String getDateTimeString(Date date) {
		return dateToString(date, DateTimeUtil.CUSTOM_DATETIME_FORMAT);
	}

	/**
	 * 将一个 Calendar 格式化为日期+时间字符串,格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param calendar 日期
	 * @return 日期+时间字符串
	 */
	public static String getDateTimeString(Calendar calendar) {
		return dateToString(calendar, DateTimeUtil.CUSTOM_DATETIME_FORMAT);
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
	 * 自定义日期格式解析器,从给定的日期字符串解析,以生成一个 Date.
	 * 
	 * @param date
	 * @param parsePatterns 日期格式解析器
	 * @return Date
	 */
	public static Date stringToDate(String date, String[] parsePatterns) {
		try {
			return org.apache.commons.lang3.time.DateUtils.parseDate(date, parsePatterns);
		} catch (ParseException e) {
			throw new CommonsException("日期格式解析异常", e);
		}
	}

	/**
	 * 默认日期格式解析器,从给定的日期字符串解析,以生成一个 Date.
	 * 
	 * <p>
	 * 默认解析器支持的日期格式为：<br>
	 * 1:yyyy-MM-dd<br>
	 * 2:yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date stringToDate(String date) {
		return stringToDate(date, DATE_PARSE_PATTERNS);
	}

	/**
	 * 比较两个日期是否为同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean true:相等;false:不相等
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		return org.apache.commons.lang3.time.DateUtils.isSameDay(date1, date2);
	}
}
