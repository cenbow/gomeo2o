package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;
import java.util.List;

import cn.com.gome.trade.dto.openapi.orderdelivery.DeliveryBill;
import lombok.Data;

@Data
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8384136163502061495L;
	private Long id; 						// 订单Id
	private Integer status; 				// 订单状态
	private String  statusDesc; 				// 订单状态描述
	private Integer orderAmount; 			// 订单金额（原始金额）
	private Integer paymentAmount; 			// 订单支付金额（实际金额）
	private Long orderTime;         		//下单时间
	private Long paymentTime;               // 支付时间
	private Long deliveryTime;              // 发货时间
	private Long confirmationTime;          // 确认收货时间
	private Integer shippingCost; 			// 运费
	private Integer quantity;				// 订单数量
	private Integer gomeMoney;              // 国美币
	private Integer shopDiscountMoney; 		// 店铺直降金额
	private Integer platformCouponMoney; 	// 平台优惠金额
	private Integer shopCouponMoney; 		// 店铺优惠金额
	private Integer onePurchaseMoney;        //商品券优惠金额，相当于一元购优惠金额
	private Consignee consignee;             // 收货人信息
	private Delivery delivery;               // 收货信息
	private Integer hasInvoice;              // 是否需要发票信息0否1是
	private Invoice invoice;                 // 发票信息
	private List<OrderItem> orderItems; // 订单商品行
	private List<DeliveryBill> logisticses; // 物流履历
}
