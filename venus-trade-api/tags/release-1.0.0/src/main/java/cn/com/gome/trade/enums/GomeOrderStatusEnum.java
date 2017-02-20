/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: libin-ds9
 * @date: 2015年5月25日 下午5:51:34
 */
package cn.com.gome.trade.enums;

/**
 * @Description: TODO
 * @author: libin-ds9
 * @date: 2015年5月25日 下午5:51:34
 */
public enum GomeOrderStatusEnum {

	ORDER_TOBE_OUTWAREHOUSE("待出库", "PROCESSING", "PP", 1), ORDER_OUTWAREHOUSE(
			"已出库", "PROCESSING", "EX", 2), ORDER_REJECTION("拒收", "PROCESSING",
			"RV", 3), ORDER_COMPLETE("已完成", "NO_PENDING_ACTION", "DL", 4), ORDER_CANCEL(
			"已取消", "REMOVED", "CL", 5);

	public final String orderStatus;

	public final String deliveryStatus;

	public final String desc;

	public final Integer dDStatus;

	private GomeOrderStatusEnum(String desc, String orderStatus,
			String deliveryStatus, Integer dDStatus) {
		this.desc = desc;
		this.orderStatus = orderStatus;
		this.deliveryStatus = deliveryStatus;
		this.dDStatus = dDStatus;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @return the deliveryStatus
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the dDStatus
	 */
	public Integer getdDStatus() {
		return dDStatus;
	}

	public static Integer findDdStatusByOrderStatus(String orderStatus) {
		for (GomeOrderStatusEnum s : GomeOrderStatusEnum.values()) {
			if (orderStatus.equals(s.getOrderStatus())) {
				return s.getdDStatus();
			}
		}
		return null;
	}
}
