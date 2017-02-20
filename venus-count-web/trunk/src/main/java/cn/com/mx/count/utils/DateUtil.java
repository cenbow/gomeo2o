package cn.com.mx.count.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description 时间工具 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午4:03:47
 */
public class DateUtil {
	
	/**
	 * @Description 日期转字符串 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:04:00
	 * @param date 日期
	 * @param format 格式（当为空时用yyyy-MM-dd）
	 * @return 字符串日期
	 */
	public static String dateToString(Date date, String format) {
		if (date == null) {
			return null;
		}
		if (format == null) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);	
	}
	
	/**
	 * @Description 字符串转日期 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:05:13
	 * @param date 字符串
	 * @param format 格式（当为空时用yyyy-MM-dd）
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date stringTODate(String date, String format) throws ParseException {
		if (date == null) {
			return null;
		}
		if (format == null) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}
	
	/**
	 * @Description 增加天数 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:05:48
	 * @param date 日期
	 * @param day 天数
	 * @return 增加后天数
	 */
	public static Date addDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	
	/**
	 * @Description 时间转字符串 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:06:31
	 * @param date 时间
	 * @param format 格式（当为空时用yyyy-MM-dd HH:mm:ss）
	 * @return 字符串时间
	 */
	public static String timeToString(Date date, String format) {
		if (date == null) {
			return null;
		}
		if (format == null) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);	
	}
	
	/**
	 * @Description 时间转字符串 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:07:18
	 * @param date 时间
	 * @return 字符串时间
	 */
	public static String timeToString(Date date) {
		return timeToString(date, null);	
	}
	
	/**
	 * @Description 字符串转时间 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:07:48
	 * @param date 字符串
	 * @param format 格式（当为空时用yyyy-MM-dd HH:mm:ss）
	 * @return 时间
	 * @throws ParseException
	 */
	public static Date stringToTime(String date, String format) throws ParseException {
		if (date == null) {
			return null;
		}
		if (format == null) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}
	
	/**
	 * @Description 字符串转时间  
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:08:17
	 * @param date 字符串
	 * @return 时间
	 * @throws ParseException
	 */
	public static Date stringToTime(String date) throws ParseException {
		return stringToTime(date, null);
	}
	
	/**
	 * @Description 增加分钟 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:08:39
	 * @param date 时间
	 * @param minutes 分钟数
	 * @return 增加后分钟
	 */
	public static Date addMinute(Date date, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}
	
	/**
	 * @Description 获取一天的开始时间 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:09:13
	 * @param date 指定时间
	 * @return 开始时间
	 */
	public static Date getDateBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cal.getTime();
	}
	
	/**
	 * @Description 获取一天的结束时间 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:10:08
	 * @param date 指定时间
	 * @return 结束日期
	 */
	public static Date getDateEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		return cal.getTime();
	}

}
