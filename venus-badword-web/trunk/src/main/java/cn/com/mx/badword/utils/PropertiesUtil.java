package cn.com.mx.badword.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @Description: 获取配置文件中的信息 
 * @author: lijiahuan
 * @date: 2015年5月15日 上午10:31:02
 */
public class PropertiesUtil {
	
	private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	
	/**
	 * @Description: 通过属性名称直接获取，service.properties文件中的属性值
	 * @author: lijiahuan
	 * @date: 2015年5月15日 上午10:51:08
	 * @param pName 属性名
	 * @param defultValue 默认属性值
	 * @return
	 */
	public static String getProProperties(String pName, String defultValue){	
		try{
		    Properties prop = new Properties();// 属性集合对象     
		    InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("badword.properties");// 属性文件输入流，默认service     
		    prop.load(fis);// 将属性文件流装载到Properties对象中     
		    fis.close();// 关闭流    
	    
	    return prop.getProperty(pName,defultValue);
		}catch(Exception e){
			logger.error(e.getMessage()+"文件名:"+pName);
			return defultValue;
		}
	}
	
	/**
	 * @Description: 通过属性名称获取，指定properties文件中的属性值
	 * @author: lijiahuan
	 * @date: 2015年5月15日 上午10:51:52
	 * @param fileName 指定文件名，不带.properties
	 * @param pName 属性名
	 * @param defultValue 默认属性值
	 * @return
	 */
	public  static String getProProperties(String fileName,String pName, String defultValue){	
		try{
		    Properties prop = new Properties();// 属性集合对象     
		    FileInputStream fis = new FileInputStream("src/main/resources/"+fileName+".properties");// 属性文件输入流，默认service     
		    prop.load(fis);// 将属性文件流装载到Properties对象中     
		    fis.close();// 关闭流    
	    
	    return prop.getProperty(defultValue,defultValue);
		}catch(Exception e){
			logger.error(e.getMessage()+"文件名:"+pName);
			return defultValue;
		}
	}

}
