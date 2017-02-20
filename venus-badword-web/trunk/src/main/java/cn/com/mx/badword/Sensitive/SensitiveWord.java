package cn.com.mx.badword.Sensitive;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description 单例加载词语
 * @author yuanchangjun
 * @date 2016年2月24日 下午6:16:37
 */
@SuppressWarnings("all")
public class SensitiveWord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7040374110291751685L;
	
	static Map sensitiveWordMap = null;
	
	/**
	 * @Description 构造函数，初始化敏感词库 
	 * @author yuanchangjun
	 * @date 2016年2月24日 下午6:16:29
	 * @return
	 */
	public static SensitivewordFilter initMap(){
		 if(sensitiveWordMap == null){
			synchronized(SensitiveWord.class){
				if(sensitiveWordMap == null){
					sensitiveWordMap = new SensitiveWordInit().initKeyWord();
				}
			}
		}
		return new SensitivewordFilter();
	}
	
	/**
	 * @Description 二次加载敏感词 
	 * @author yuanchangjun
	 * @date 2016年2月24日 下午6:18:29
	 * @return
	 */
	public static boolean secondInitMap(){
		sensitiveWordMap = null;
		sensitiveWordMap = new SensitiveWordInit().initKeyWord();
		if(sensitiveWordMap!=null&&sensitiveWordMap.size()>0){
			return true;
		}else{
			return false;
		}
	}
}