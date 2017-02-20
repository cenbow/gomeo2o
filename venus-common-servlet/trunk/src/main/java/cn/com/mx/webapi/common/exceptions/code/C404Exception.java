package cn.com.mx.webapi.common.exceptions.code;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

/**
 * @Description 404异常 ，Not Found：请求失败，请求所希望得到的资源未被在服务器上发现
 * @author wanggang-ds6
 * @date 2016年1月21日 下午1:51:17
 */
public class C404Exception extends BaseCodeException {

	private static final long serialVersionUID = 2751205722411589544L;

	public C404Exception() {
		super();
	}
	
	public C404Exception(BaseExceptionMessage message) {
		super(message);
	}
	
	public C404Exception(BaseExceptionMessage message, Throwable cause) {
        super(message, cause);
    }
	
	public C404Exception(Throwable cause) {
        super(cause);
    }

}
