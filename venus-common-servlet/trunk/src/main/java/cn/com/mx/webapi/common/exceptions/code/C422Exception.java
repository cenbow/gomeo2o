package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 422异常 ，Unprocessable Entity：请求格式正确，但是由于含有语义错误，无法响应
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C422Exception extends BaseCodeException {

	private static final long serialVersionUID = -7092978320608763979L;

	public C422Exception() {
		super();
	}
	
	public C422Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C422Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C422Exception(Throwable cause) {
        super(cause);
    }

}
