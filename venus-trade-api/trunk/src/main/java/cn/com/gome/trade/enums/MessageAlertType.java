package cn.com.gome.trade.enums;

public enum MessageAlertType {
	
	OrderDeliveryNotifyToBuyer(12,"卖家已发货提醒--发给买家"),
	
	
	
	
	OrderCreateNotifyToMShop(11,"下单提醒(买家未支付)--发给美店店主"),
	OrderCreateNotifyToSeller(1,"下单提醒(买家已支付)--发给XPOP卖家"),
	OrderRefundNotifyToSeller(2,"退款申请--发给卖家"),
	OrderReturnNotifyToSeller(3,"退货申请--发给卖家"),
	OrderExchangeNotifyToSeller(4,"换货申请--发给卖家"),
	OrderRefundFailNotifyToSeller(5,"退款失败--发给卖家"),
	
	CreateGroupSuccessNotify(6,"组团成功提醒"),
	CreateGroupFailNotify(7,"组团失败提醒"),
	AcceptGroupSuccessNotify(8,"参团成功提醒"),
	AcceptGroupFailNotify(9,"参团失败提醒"),
	TimeoutNotify(10,"服务超时提醒");
	
	private final int value;

    private final String description;
    
    private MessageAlertType(int value, String description) {
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
