package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 401异常 ，Unauthorized：当前请求需要用户验证
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C401Exception extends BaseCodeException {

	private static final long serialVersionUID = 7249808434799610256L;

	public C401Exception() {
		super();
	}
	
	public C401Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C401Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C401Exception(Throwable cause) {
        super(cause);
    }

}
