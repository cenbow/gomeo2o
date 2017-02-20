/**
 * @类名: GomeOrderException.java
 * @作者： libin-ds9
 * @创建时间 2015年5月8日 下午8:05:26
 */
package cn.com.gome.trade.exception;

import com.gomeo2o.common.exceptions.BizException;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月8日 下午8:05:26
 */
public class GomeOrderException extends BizException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4611045073905020158L;

	public static final GomeOrderException ORDER_PAY_CHECK_FAILE = new GomeOrderException(
			170001, "支付类型数据检测异常");
	
	public static final GomeOrderException ORDER_TO_REBATE_FAILE = new GomeOrderException(
			170002, "订单推返利数据失败");

	public GomeOrderException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}

	public GomeOrderException(int code, Throwable cause, String msgFormat,
			Object... args) {
		super(cause);
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public GomeOrderException newInstance(String msgFormat, Object... args) {
		return new GomeOrderException(this.code, this.msg + ":" + msgFormat,
				args);
	}

	public GomeOrderException newInstance(Throwable cause, String msgFormat,
			Object... args) {
		return new GomeOrderException(code, cause, msgFormat, args);
	}

}
