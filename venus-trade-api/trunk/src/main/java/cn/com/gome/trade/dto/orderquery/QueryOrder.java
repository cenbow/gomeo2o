package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class QueryOrder implements Serializable {
	private static final long serialVersionUID = -6250960240942329877L;
	private Long id; 						// 订单Id
	private Long mergerId; 					// 合单Id
	private Integer orderType; 				// 订单类型 1:gome+平台订单；5:o2m平台订单
	private Integer status; 				// 订单状态
	private String statusDesc; 				// 订单状态描述
	private Integer mshopCommission = 0; 	// 美店佣金
	private Integer allowDelayConfirm = 0; 	// 是否可以延迟收货
	private Long sellerId; 					// 卖家用户ID
	private Long buyerId; 					// 买家用户ID
	private String consigneeName;           // 收货人姓名
	private Boolean hasLogistics; 			// 是否有物流
	private Integer shippingCost; 			// 运费
	private Integer orderAmount; 			// 订单金额（原始金额）
	private Integer paymentAmount; 			// 订单支付金额（实际金额）
	private Long orderTime;         		//下单时间
	private List<Long> orderIds; 			// 待支付合单中订单ids
	private List<QueryOrderItem> orderItems; // 订单商品行
	// 优惠抵扣
	private Integer platformCouponMoney; 	// 平台优惠金额
	private Integer shopCouponMoney; 		// 店铺优惠金额
	private Integer shopDiscountMoney; 		// 店铺直降金额
	private Integer onePurchaseMoney; 		// 商品券优惠金额 一元购优惠金额
	private Long afterSalesOrderId; 		// 售后单ID
	private Integer quantity;				// 订单数量
	private Boolean hasComment = false;     //是否评价，订单行如果有一个未评价，则未评价
	private Long systemTime;//系统时间
	private Long paymentTime;//订单支付时间
	private Long deliveryTime;//订单发货时间
	private Long confirmationTime;//订单确认收货时间
	
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
