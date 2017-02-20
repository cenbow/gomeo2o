package cn.com.gome.trade.service.online;

public interface OnlineOrderScheduleService {
	/**
	 * 
	 * 同步在线发货订单
	 */
	void synOnlineShippedOrder();
	
	/**
	 * 
	 * 同步在线支付后取消订单
	 */
	void synOnlineCannceledOrder();
	
	/**
	 * 
	 * 同步在线订单配送单
	 */
	void synOnlineOrderDelivery();
	
	/**
	 * 
	 * 同步在线订单订单履历
	 */
	void synOnlineOrderLogistics();
	/**
	 * 
	 * 在线配送单退款
	 */
	void refundOnlineRejectionDelivery();

}