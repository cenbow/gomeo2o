package cn.com.gome.trade.enums;

/**
 * 
 * @Description 为异步通知建立的枚举类，目的是通过枚举类中int的值来区别调用的是什么通知 
 * @author wangjiatian
 * @date 2016年8月22日 下午2:14:14
 */
public enum GomeNotifyEnum {

	REFUNDGOMEMONEY(0,"退国美币"),
	RESETCOUPONINFO(1,"退账户优惠券"),
	RESETGOMECOUPON(2,"退返利优惠券");
	private final int value;
	private final String description;
	private GomeNotifyEnum(int value,String description){
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
