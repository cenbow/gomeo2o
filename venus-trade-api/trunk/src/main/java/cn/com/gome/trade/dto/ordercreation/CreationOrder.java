package cn.com.gome.trade.dto.ordercreation;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

import com.google.common.collect.Lists;

@Data
public class CreationOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2005891288133030881L;
	private Seller seller; //卖家信息
	private TradeShop shop;  //店铺信息
	private Integer shippingCost;  //运费
	private List<CreationOrderItem> orderItems = Lists.newArrayList();  //订单商品行
	private Integer couponPrice;//优惠券价格
	private Integer gomeMoneyPrice;//国美币价格
	private Integer type;//订单类型
	private Integer fee; //总支付金额
	private Integer originFee; //订单原价
	private Integer discount; //直降优惠总额
	private Long orderId; //订单id
	private CouponUsage couponUsage;//优惠券使用对象
	private Integer shopCouponPrice;//店铺优惠券
	private Integer platCouponPrice;//平台优惠券
	private Integer hasInvoice; //是否要开发票
	private String subInx;//o2m子单序号，1-999，在一个订单内不能重复
	private String shippingMethod;//配送方式
	private String invoiceNo;//发票号
}
