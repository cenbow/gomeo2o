package cn.com.gome.trade.enums;


/*****
 * 微店订单不同状态下销量 枚举类
 * @author zhanglinlin
 * @time 2016-02-24
 */
public enum VshopOrderEnum {
	
	PEND_PAYMENT(0, "待付款"),
	
	PEND_DELIVER(1,"已付款"),
	
	PEND_RECEIVE(2,"待发货"),
	
	PEND_COMMENT(3,"待评价");

    private final int value;

    private final String description;

    private VshopOrderEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return this.value;
    }
    @Override
    public String toString() {
        return description;
    }
}
