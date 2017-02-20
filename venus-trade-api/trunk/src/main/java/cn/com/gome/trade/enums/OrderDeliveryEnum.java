package cn.com.gome.trade.enums;

public enum OrderDeliveryEnum {

	THIRD(1, "第三方物流"),
	O2M(2, "O2M物流"),
	ONLINE(3, "在线物流"),
	PLATFORM(4, "自由物流");
	
	private final int code;
	private final String message;

	private OrderDeliveryEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int code() {
		return this.code;
	}

	@Override
	public String toString() {
		return message;
	}

}
