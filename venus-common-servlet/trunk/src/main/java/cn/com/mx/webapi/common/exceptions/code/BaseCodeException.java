package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 异常基类 
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:49:20
 */
public abstract class BaseCodeException extends RuntimeException {

	private static final long serialVersionUID = 9205819405627627565L;
	
	public BaseCodeException() {
		super();
	}
	
	public BaseCodeException(BaseExceptionMessage message) {
		super(message.toString());
	}
	
	public BaseCodeException(BaseExceptionMessage message, Throwable cause) {
        super(message.toString(), cause);
    }
	
	public BaseCodeException(Throwable cause) {
        super(cause);
    }
	
	/**
	 * @Description 获取状态码 
	 * @author wanggang-ds6
	 * @date 2016年1月21日 下午1:51:53
	 * @return 状态码 
	 */
	public int getCode() {
		return Integer.parseInt(this.getClass().getSimpleName().substring(1, 4));
	}
	
}
