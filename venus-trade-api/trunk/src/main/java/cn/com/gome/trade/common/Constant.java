package cn.com.gome.trade.common;

public interface Constant {
	public static final int SHOP_COUPON_TYPE = 1;      					// 店铺优惠券类型
	public static final int PLATFORM_COUPON_TYPE = 2;      				// 平台优惠券类型
	
	public static final int ONEPRUCHASE_COUPON_TYPE = 1;      			// 下单立减券类型
	public static final int ENOUGHDISCOUNT_COUPON_TYPE = 2;      		// 满减券
	
	public static final int BUSINESS_SUCCESS = 0;                       // 业务成功标志
	public static final int BUSINESS_FAIL = -1;							// 业务失败标志
	public static final int DEFAULT_GOMEMONEY = 0;						// 默认国美币为0
	public static final int DEFAULT_MONEY = 0;                          // 默认金额
	public static final Integer INVOICE_TITLE_TYPE = 1;      			//默认发票抬头类型
	public static final String INVOICE_TYPE_DESC = "普通发票";      		//默认发票类型描述
	
	public static final Integer CANNOT_AFTERSALES_FLAG = 0;				//不可以申请售后标志
	public static final Integer CAN_AFTERSALES_FLAG = 1;				//可以申请售后标志
	
	public static final Boolean CANNOT_RETURN_FOR_SEVENDAYS = false;		//不可以7天退货
	public static final Boolean CAN_RETURN_FOR_SEVENDAYS = true;			//可以7天退货
	
	public static final Boolean CANNOT_CHANGE_FOR_FIFTEENDAYS = false;		//不可以15天换货
	public static final Boolean CAN_CHANGE_FOR_FIFTEENDAYS = true;			//可以15天换货
	
	public static final Integer NORMAL_USER_STATUS = 1;      		//正常用户
	
	public static final Integer DEFAULT_BUYER_TYPE = 1;      		//买家用户类型
	public static final Integer DEFAULT_SELLER_TYPE = 2;      		//卖家用户类型

}
