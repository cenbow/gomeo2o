package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 403异常 ，Not Acceptable：请求的资源的内容特性无法满足请求头中的条件，因而无法生成响应实体。
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C403Exception extends BaseCodeException {

	private static final long serialVersionUID = -1674922965203577452L;

	public C403Exception() {
		super();
	}
	
	public C403Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C403Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C403Exception(Throwable cause) {
        super(cause);
    }

}
