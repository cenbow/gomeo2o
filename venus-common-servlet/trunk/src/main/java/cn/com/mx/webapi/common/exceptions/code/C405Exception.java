package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 405异常 ，Forbidden：服务器已经理解请求，但是拒绝执行它
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C405Exception extends BaseCodeException {

	private static final long serialVersionUID = -7307130683302788933L;

	public C405Exception() {
		super();
	}
	
	public C405Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C405Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C405Exception(Throwable cause) {
        super(cause);
    }

}
