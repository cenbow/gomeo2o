package cn.com.mx.utils;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description  JSON工具类,提供对象转json,json转对象，json转list
 * @author wangchangye
 * @date 2016年1月28日 下午1:01:27
 */
public class JsonUtil {
	
	// 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
	
	static final String SUCCESSSTR = "{\"success\":true}";

	static final String FAILSTR = "{\"success\":false}";

	static final String NULLSTR = "{\"success\":false,data:\"\"}";
	
	
	/**
	 * 返回正常响应
	 */
	public static String buildJsonRtnSuc() {
		return SUCCESSSTR;
	}

	/**
	 * 返回空响应
	 */
	public static String nullJson() {
		return NULLSTR;
	}

	/**
	 * 返回对应格式的消息
	 * 
	 * @param eroStr
	 *            消息内容
	 * @return json格式数据
	 */
	public static String buildJsonRtnEro(String eroStr) {
		if (StringUtils.isBlank(eroStr)) {
			return FAILSTR;
		}
		StringBuffer rtn = new StringBuffer("{\"success\":false,\"msg\":\"");
		return rtn.append(eroStr).append("\"}").toString();
	}

	public static String buildJsonRtnSuc(String str) {
		StringBuffer rtn = new StringBuffer("{\"success\":true,\"msg\":\"");
		return rtn.append(str).append("\"}").toString();
	}

	public static String buildJsonRtnOne(Object obj) {
		StringBuffer rtn = new StringBuffer("{\"success\":true,\"data\":[");
		return rtn.append(objectToJson(obj)).append("]}").toString();
	}

    
    /**
     * 
     * @Description 将某一个对象转成json字符串
     * @author wangchangye
     * @date 2016年1月28日 下午12:58:53
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 
     * @Description 将json结果集转化为某一对象 
     * @author wangchangye
     * @date 2016年1月28日 下午12:59:32
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 
     * @Description 将json结果集转化为对象List集合 
     * @author wangchangye
     * @date 2016年1月28日 下午1:00:29
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	public static String buildPageData(int pn,int total, Object obj){
		return 	"{\"sEcho\":" + pn + ",\"iTotalRecords\":" + total + ",\"iTotalDisplayRecords\":" + total + ",\"aaData\":" + JSONArray.fromObject(obj).toString() + "}";
	}
    
    
    
}
