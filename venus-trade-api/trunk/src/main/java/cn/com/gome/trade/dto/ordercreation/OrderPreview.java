package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import com.google.common.collect.Lists;
@Data
public class OrderPreview implements Serializable{

	private static final long serialVersionUID = 1859740642146601722L;
	//private Seller seller; //卖家信息
	private TradeShop shop;  //店铺信息
	private Integer shippingCost;  //运费
	private Integer orderMoney;//自订单原价总金额
	private Integer quantity;//子订单购买商品总数量
	private Integer paymentMoney;//自订单需支付总金额
	private List<CreationOrderItem> orderItems;  //订单商品行
	//private List<CreationCoupon> coupons;  //使用优惠券情况

}
