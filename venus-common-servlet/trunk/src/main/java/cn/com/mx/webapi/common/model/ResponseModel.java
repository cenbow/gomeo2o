package cn.com.mx.webapi.common.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * @Description 返回实体 
 * @author wanggang-ds6
 * @date 2016年1月22日 下午3:15:54
 */
@Data
public class ResponseModel {
	
	public ResponseModel() {		
	}
	
	public ResponseModel(Map<String, Object> data) {
		if (null != data) {
			this.data = data;
		}		
	}
	
	public ResponseModel(String message) {
		if (null != message) {
			this.message = message;
		}
	}
	
	public void setMessage(String message) {
		if (null != message) {
			this.message = message;
		}
	}	
	
	public void setData(Map<String, Object> data) {
		if (null != data) {
			this.data = data;
		}		
	}
	
	// 消息
	private String message = "";
	// 返回对象
	private Map<String, Object> data = new HashMap<String, Object>();
	private String debug;
	private Integer status;
}
