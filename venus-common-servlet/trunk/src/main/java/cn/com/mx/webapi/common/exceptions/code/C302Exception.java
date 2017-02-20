package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 302异常 ，Move temporarily：请求的资源临时从不同的 URI响应请求
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C302Exception extends BaseCodeException {

	private static final long serialVersionUID = 9065219434120712877L;
	
	private String redirectPath;

	public C302Exception(String redirectPath) {
		super();
		this.redirectPath = redirectPath;
	}
	
	public C302Exception(String redirectPath, BaseExceptionMessage message) {
		super(message);
		this.redirectPath = redirectPath;
	}
	
	public String getRedirectPath() {
		return redirectPath;
	}
}
