/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午1:44:02
 */
package cn.com.mx.base.exception;

import com.gomeo2o.common.exceptions.BizException;

/**
 * @Description 客服系统异常处理类
 * @author guowenbo
 * @date 2016年3月18日 下午1:44:02
 */
public class CshException extends BizException{

	private static final long serialVersionUID = -2366833811550610072L;

	//参数不正确
	public static final CshException PARAM_IS_ERROR =  new CshException(230001, "参数不正确");
	
	//LDAP异常
	public static final CshException LDAP_FILE =  new CshException(230002, "LDAP服务执行失败");
	
	public CshException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}
	
	public CshException(int code, Throwable cause, String msgFormat, Object... args) {
		super(cause);
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}
	
	public CshException newInstance(String msgFormat, Object... args) {
		return new CshException(this.code, this.msg + ":" + msgFormat, args);
	}
	
	public CshException newInstance(Throwable cause, String msgFormat, Object... args) {
		return new CshException(code, cause, msgFormat, args);
	}
}
