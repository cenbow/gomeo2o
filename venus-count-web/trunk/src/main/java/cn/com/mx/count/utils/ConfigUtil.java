package cn.com.mx.count.utils;

import java.io.InputStream;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 读取配置文件 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午2:00:02
 */
@Slf4j
public final class ConfigUtil {

	// 配置文件
	private static Properties properties;
		
	// 读取配置文件
	static {
		try {
			log.info("app.properties...");
			InputStream in = ConfigUtil.class.getClassLoader()
					.getResourceAsStream("app.properties");
			properties = new Properties();
			properties.load(in);
			in.close();
		} catch (Exception e) {
			log.error("加载app.properties出错！", e);
		}
	}

	
	/**
	 * @Description: 获取参数 
	 * @author: wanggang-ds6
	 * @date: 2015年8月20日 下午4:55:43
	 * @param field
	 * @return 字符串
	 */
	public static String get(String field) {
		return properties.getProperty(field);
	}

	/**
	 * @Description: 获取参数  
	 * @author: wanggang-ds6
	 * @date: 2015年8月20日 下午4:56:11
	 * @param field
	 * @return 整数
	 */
	public static int getInt(String field) {
		return Integer.parseInt(properties.getProperty(field));
	}
	
	/**
	 * @Description: 获取参数 
	 * @author: wanggang-ds6
	 * @date: 2015年8月20日 下午5:13:18
	 * @param field
	 * @return 长整型
	 */
	public static long getLong(String field) {
		return Long.parseLong(properties.getProperty(field));
	}
	
	/**
	 * @Description: 获取参数 
	 * @author: wanggang-ds6
	 * @date: 2015年8月20日 下午5:15:20
	 * @param field
	 * @return 布尔型
	 */
	public static boolean getBoolean(String field) {
		return Boolean.valueOf(properties.getProperty(field));
	}
}
