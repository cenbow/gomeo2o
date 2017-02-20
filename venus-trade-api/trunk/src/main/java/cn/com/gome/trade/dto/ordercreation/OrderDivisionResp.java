package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class OrderDivisionResp implements Serializable{

	private static final long serialVersionUID = -4836823105474730925L;
	//private Long addressId;    //地址id
	private List<OrderPreview> orderPreviews = new ArrayList<OrderPreview>();  //订单预览行
	private List<CreationCoupon> coupons;//用户选择的优惠券列表
	private Integer totalCouponMoney;//使用优惠券总金额
	private Integer totalShippingCost;//运费总金额
	private Integer gomeMoney;  //使用的国美币
	private Integer totalOrderMoney;//订单原价总金额
	private Integer totalPaymentMoney;//订单需支付总金额
    private Integer totalDiscountMoney;//订单直降总额
    private Integer totalTax;//总税费
}
