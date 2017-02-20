package cn.com.mx.count.bean;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * @Description 返回实体 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午4:15:50
 */
@Data
public class ReturnBean {

	public ReturnBean() {
	}
	public ReturnBean(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public ReturnBean(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public ReturnBean(Object data) {
		this.data = data;
	}
	private int code = 0;
	private String msg = "成功";
	private Object data = null;
	
	/**
	 * @Description 输出json字符串 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:29:07
	 * @return json字符串 
	 */
	public String toJSONString() {
		return JSONObject.toJSONString(this);
	}

}
