package cn.com.gome.trade.enums;

public enum CouponPlatEnum {

	NORMAL_COUPON(0,"普通点单券"),
	ONCE_PURCHASE_COUPON(1,"下单立减定单券"),
	GROUP_PURCHASE_COUPON(2,"团购点单券");
	private final int value;
	private final String description;
	private CouponPlatEnum(int value,String description){
		this.value = value;
		this.description = description;
	}
	
	public int value(){
		return this.value;
	}
	 @Override
    public String toString() {
        return description;
    }
}
