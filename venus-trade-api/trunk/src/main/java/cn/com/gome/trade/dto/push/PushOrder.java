package cn.com.gome.trade.dto.push;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class PushOrder implements Serializable {
	private static final long serialVersionUID = -6250960240942329877L;
	private Long id; 						// 订单Id
	private Long mergerId; 					// 合单Id
	private Integer orderType; 				// 订单类型 1:gome+平台订单；5:o2m平台订单
	private Integer payType;				// 支付类型
	private Integer status; 				// 订单状态
	private String statusDesc; 				// 订单状态描述
	private PushShop shop;					// 店铺信息
	private PushSeller seller;				// 卖家信息
	private PushBuyer buyer;				// 买家信息
	private PushConsignee consignee;		// 收货人信息
	private PushDelivery delivery;			// 发货信息
	private Integer hasInvoice;				// 是否要发票 0否1是
	private PushInvoice invoice;			// 发票信息
	private Integer shippingCost; 			// 运费
	private Integer orderAmount; 			// 订单金额（原始金额）
	private Integer paymentAmount; 			// 订单支付金额（实际金额）
	private Integer gomeMoney; 				// 使用的国美币
	private Long orderTime;         		// 下单时间
	private List<Long> orderIds; 			// 待支付合单中订单ids
	private List<PushOrderItem> orderItems; // 订单商品行
	// 优惠抵扣
	private Integer platformCouponMoney; 	// 平台优惠金额
	private Integer shopCouponMoney; 		// 店铺优惠金额
	private Integer shopDiscountMoney; 		// 店铺直降金额
	private Integer onePurchaseMoney; 		// 商品券优惠金额 一元购优惠金额
	private Integer quantity;				// 订单商品数量

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
