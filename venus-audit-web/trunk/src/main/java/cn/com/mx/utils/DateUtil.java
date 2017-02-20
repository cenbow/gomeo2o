package cn.com.mx.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @Description: 时间工具类 
 * @author: xuguoqi
 * @date: 2015年11月11日 下午4:05:22
 */
public class DateUtil {
	
	private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 
	 * @Description: 获取当前时间戳
     * @author: xuguoqi
     * @date: 2015年11月11日 下午4:06:17
     * @return long
	 */
	public static Timestamp getNowTimestamp(){
		return new Timestamp(new Date().getTime());
	}	
	
	/**
	 * @Description 获取当前时间
	 * @author yuanchangjun
	 * @date 2015年11月13日 下午12:00:04
	 * @return
	 * @throws ParseException
	 */
	public static Date getNowDate() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(sdf.format(new Date()));
	}
	
	/**
	 * 
	 * @Description: 日期格式化 
     * @author: xuguoqi
     * @date: 2015年11月13日 下午3:56:55
     * @param date
     * @return String
	 */
	public static String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 *@Description: 将字符串日期时间转换成java.util.Date类型
	 *              日期时间格式yyyy-MM-dd HH:mm:ss
	 * @author 柴志磊
	 * @date: 2015年11月19日 下午3:56:55
	 * @param datetime 2015-12-20 00:00:00
	 * @return
	 */
	public static Date parseDatetime(String datetime) throws ParseException {
		return datetimeFormat.parse(datetime);
	}
	
}
