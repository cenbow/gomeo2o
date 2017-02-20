package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 406异常 ，Forbidden：服务器已经理解请求，但是拒绝执行它
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C406Exception extends BaseCodeException {

	private static final long serialVersionUID = -5893058147963724662L;

	public C406Exception() {
		super();
	}
	
	public C406Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C406Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C406Exception(Throwable cause) {
        super(cause);
    }

}
