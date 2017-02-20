package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 400异常 ，Bad Request：语义有误，当前请求无法被服务器理解;请求参数有误
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C400Exception extends BaseCodeException {

	private static final long serialVersionUID = 6763439507616251988L;

	public C400Exception() {
		super();
	}
	
	public C400Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C400Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C400Exception(Throwable cause) {
        super(cause);
    }

}
