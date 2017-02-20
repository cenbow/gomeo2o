package com.gomeo2o.common.entity;

import java.io.Serializable;

public class CommonResultEntity<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 	成功失败码：0为成功，其他：失败（六位数正整形）：默认0
	 */
	private int code = 0;
	
	/**
	 * 	成功失败信息：默认成功
	 */
	private String message = "成功";
	
	/**
	 * 	返回业务数据, 如果没有返回数据时，可定义为String类型，赋予""空值
	 */
	private T businessObj;

	public int getCode() {
		return code;
	}
	
	public CommonResultEntity(){
		
	}
	
	public CommonResultEntity(int code, String message, T businessObj){
		this.code = code;
		this.message = message;
		this.businessObj = businessObj;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBusinessObj() {
		return businessObj;
	}

	public void setBusinessObj(T businessObj) {
		this.businessObj = businessObj;
	}
}
