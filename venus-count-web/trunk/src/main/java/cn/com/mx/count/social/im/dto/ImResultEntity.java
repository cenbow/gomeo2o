package cn.com.mx.count.social.im.dto;

import java.io.Serializable;
/**
 * 
 * @Description: im请求返回实体类 
 * @author: xuguoqi
 * @date: 2016年1月18日 下午3:54:44
 */
public class ImResultEntity implements Serializable {

	private static final long serialVersionUID = -54191080317305517L;

	private int resultCode;//返回值

	private String message;//返回信息

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ImResultEntity [resultCode=" + resultCode + ", message=" + message + "]";
	}

	
}
