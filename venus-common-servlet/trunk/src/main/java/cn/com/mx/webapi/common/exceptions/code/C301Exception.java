package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 301异常 ，Moved Permanently：被请求的资源已永久移动到新位置
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C301Exception extends BaseCodeException {
		
	private static final long serialVersionUID = 2859775942753483009L;
	
	private String redirectPath;

	public C301Exception(String redirectPath) {
		super();
		this.redirectPath = redirectPath;
	}
	
	public C301Exception(String redirectPath, BaseExceptionMessage message) {
		super(message);
		this.redirectPath = redirectPath;
	}
	
	public String getRedirectPath() {
		return redirectPath;
	}
}
