/**
 * @类名: GomeOrderInfoEnum.java
 * @作者： libin-ds9
 * @创建时间 2015年5月8日 下午5:21:57
 */
package cn.com.gome.trade.enums;

import cn.com.gome.trade.dto.io.pay.request.OrderThirdPartyPayRequestDto;
import cn.com.gome.trade.dto.io.pay.request.OrderUnionPayRequestDto;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月8日 下午5:21:57
 */
public enum GomeOrderInfoEnum {

	/**
	 * 银联支付类型
	 */
	ORDER_PAY_TYPE_UNIONPAY("银联", "CHINAPAY", OrderUnionPayRequestDto.class),

	/**
	 * 第三方支付类型
	 */
	ORDER_PAY_TYPE_D2PAY("第三方", "D2Pay", OrderThirdPartyPayRequestDto.class);

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 枚举值
	 */
	private String value;

	/**
	 * 枚举类型
	 */
	private Class c;

	private <T> GomeOrderInfoEnum(String desc, String value, Class<T> t) {
		this.desc = desc;
		this.value = value;
		this.c = t;
	}

	private GomeOrderInfoEnum(String desc, String value) {
		this.desc = desc;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Class getC() {
		return c;
	}

	public void setC(Class c) {
		this.c = c;
	}

}
