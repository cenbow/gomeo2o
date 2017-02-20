package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 500异常 ，Internal Server Error：服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C500Exception extends BaseCodeException {

	private static final long serialVersionUID = -6156678979261269857L;

	public C500Exception() {
		super();
	}
	
	public C500Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C500Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C500Exception(Throwable cause) {
        super(cause);
    }

}
