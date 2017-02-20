package cn.com.mx.webapi.common.utils;

import java.util.HashMap;
import java.util.Map;

import cn.com.mx.webapi.common.model.ResponseModel;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 打印入参和出参
 * @author wanggang-ds6
 * @date 2016年1月25日 下午5:10:53
 */
public class ParametersPrinter {

	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
	
	/**
	 * @Description 设置开始时间 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:17:26
	 * @param date 开始时间
	 */
	public static void setStartTime(long timeMillis) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", timeMillis);
		threadLocal.set(paramMap);
	}
	
	/**
	 * @Description 设置结束时间 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:21:19
	 * @param date 结束时间
	 */
	public static void setEndTime(long timeMillis) {
		long costTime = timeMillis - (long) threadLocal.get().get("startTime");
		threadLocal.get().put("costTime", costTime);
		threadLocal.get().put("endTime", timeMillis);
	}
	
	/**
	 * @Description 设置请求参数 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:28:52
	 * @param servletParam 请求参数
	 */
	public static void setRequestParam(ResourceParameters servletParam) {
		threadLocal.get().put("requestParam", servletParam);
	}
	
	/**
	 * @Description 设置请求地址 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午6:09:10
	 * @param path 请求地址
	 */
	public static void setRequestUrl(String path) {
		threadLocal.get().put("requestUrl", path);
	}
	
	/**
	 * @Description 设置请求实体 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:30:33
	 * @param body 请求实体
	 */
	public static void setRequestBody(JSONObject body) {
		threadLocal.get().put("requestBody", body);
	}
	
	/**
	 * @Description 设置应答实体 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:31:34
	 * @param responseModel 应答实体 
	 */
	public static void setResponseModel(ResponseModel responseModel) {
		threadLocal.get().put("responseModel", responseModel);
	}
	
	/**
	 * @Description 设置重定向地址
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:55:47
	 * @param path 重定向地址
	 */
	public static void setResponseRedirect(String path) {
		threadLocal.get().put("responseRedirect", path);
	}
	
	/**
	 * @Description 设置应答码 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:57:32
	 * @param responseCode 应答码 
	 */
	public static void setResponseCode(int responseCode) {
		threadLocal.get().put("responseCode", responseCode);
	}
	
	/**
	 * @Description 转换字符串输出 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午5:48:04
	 * @param isDelete 是否删除，如果之后不再使用，请删除
	 * @return 字符串结果
	 */
	public static String toString(boolean isDelete) {
		String rtnValue =  JSONObject.toJSONString(threadLocal.get());
		if (isDelete) {
			threadLocal.remove();
		}
		return rtnValue;
	}
}
