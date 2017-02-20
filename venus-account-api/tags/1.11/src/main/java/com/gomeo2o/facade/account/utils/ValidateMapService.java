package com.gomeo2o.facade.account.utils;

import java.util.List;
import java.util.Map;

import com.gomeo2o.facade.account.exception.AccountException;
/**
 * 
 * @Description: 校验map Map<String,Object>
 * @author: fengxin
 * @date: 2015年5月15日 下午4:08:14
 */
public class ValidateMapService {
	/**
	 * 
	 * @Description:校验map中是否有参数为空 或者""
     * @author: fengxin
     * @date: 2015年5月15日 下午4:13:32
     * @param map
     * @return void    
	 */
    public static void validate(Map<String,Object> map){
    	if(map!=null && !"".equals(map) && map.size()>0){
			for (String key : map.keySet()) {
				if(map.get(key)==null||"".equals(map.get(key))){
					throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数"+key+"为空");
				}
			}
    	}else{
    		throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数Map为空");
    	}
    }
    
    /**
	 * 
	 * @Description:校验map中是否有参数为空 或者""，并移除不用判定
	 * 			            为空的信息
     * @author: fengxin
     * @date: 2015年5月15日 下午4:13:32
     * @param map,unVerifymap(不需校验的key)
     * @return void    
	 */
    public static void validate(Map<String,Object> map,Map<String,Object> unVerifyMap){
    	
    	if(map!=null && !"".equals(map)  && map.size()>0){
			for (String key : map.keySet()) {
				if(unVerifyMap.get(key) != null){//非必传参数
					continue;
				}else {
					if(map.get(key)==null||"".equals(map.get(key))){
						throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数"+key+"为空");
					}
				}
			}
    	}else{
    		throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数Map为空");
    	}
    }
    /**
   	 * 
   	 * @Description:校验map中是否有参数为空 或者""，以及必须判定的方法must
        * @author: fengxin
        * @date: 2015年5月15日 下午4:13:32
        * @param map,mustList（必须校验的列表）
        * @return void    
   	 */
       public static void validate(Map<String,Object> map,
    		   List<String> mustList){
       
       	if(map!=null && !"".equals(map) && map.size()>0){
       		//必传参数
       		for (String mustKey : mustList) {
       			if(map.get(mustKey)==null||"".equals(map.get(mustKey))){
						throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数"+mustKey+"为空");
				}
			}
   			for (String key : map.keySet()) {
   				
				if(map.get(key)==null||"".equals(map.get(key))){
					throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数"+key+"为空");
				}
   			}
       	}else{
       		throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数Map为空");
       	}
     }
    /**
   	 * 
   	 * @Description:校验map中是否有参数为空 或者""，并移除不用判定
   	 * 			            为空的信息,以及必须判定的方法must
        * @author: fengxin
        * @date: 2015年5月15日 下午4:13:32
        * @param map,unVerifymap(不需校验的key),mustList（必须校验的列表）
        * @return void    
   	 */
       public static void validate(Map<String,Object> map,Map<String,Object> unVerifyMap,
    		   List<String> mustList){
       
       	if(map!=null && !"".equals(map) && map.size()>0){
       		//必传参数
       		for (String mustKey : mustList) {
       			if(map.get(mustKey)==null||"".equals(map.get(mustKey))){
						throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数"+mustKey+"为空");
				}
			}
   			for (String key : map.keySet()) {
   				if(unVerifyMap.get(key) != null){//非必传参数
   					continue;
   				}else {
   					if(map.get(key)==null||"".equals(map.get(key))){
   						throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数"+key+"为空");
   					}
   				}
   			}
       	}else{
       		throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数Map为空");
       	}
     }
}
