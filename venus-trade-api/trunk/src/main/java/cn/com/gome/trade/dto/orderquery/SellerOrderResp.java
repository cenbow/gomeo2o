package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.BuyerDto;
import cn.com.gome.trade.dto.common.ConsigneeDto;
import cn.com.gome.trade.dto.common.CouponDto;
import cn.com.gome.trade.dto.common.DeliveryDto;
import cn.com.gome.trade.dto.common.InvoiceDto;
import cn.com.gome.trade.dto.common.SellerDto;
import cn.com.gome.trade.dto.common.ShopDto;

@Data
public class SellerOrderResp implements Serializable {
	private static final long serialVersionUID = -1461894203322634898L;
	
	private Long id;  //订单Id
	private Long mergerId; //合单Id
	private Integer orderType; //订单类型  1:gome+平台订单；2:o2m平台订单
	private Integer status; //订单状态
	private String statusDesc; //订单状态描述
	private SellerDto seller;    //卖家
	private BuyerDto buyer;      //买家
	private Integer orderAmount; //订单金额
	private Integer paymentAmount; //支付金额
	private Integer mshopCommission  = 0; //美店佣金
	private ConsigneeDto consignee;     //收货人信息
	private DeliveryDto delivery;       //发货信息
	private InvoiceDto invoice;         //发票信息
	private List<QueryOrderItem> orderItems; //订单商品行
	private Integer platformCouponMoney;  //平台优惠金额
	private Integer shopCouponMoney;   //店铺优惠金额
	private Integer gomeMoney  = 0;         //国美币优惠金额
	private Integer shippingCost;      //运费
	private Integer shopDiscountMoney; //店铺直降金额
	private Integer onePurchaseMoney; //商品券优惠金额
	private Long orderTime;         //下单时间
	private Long paymentTime;       //付款时间
	private Long deliveryTime;      //发货时间
	private Long confirmationTime;  //确认时间
	private Integer payType;            //支付方式
	private QueryAfterSalesOrder afterSalesOrder; //售后单
	private Boolean hasLogistics;       //是否有物流
	private Boolean hasComment; //是否已评价
	private ShopDto shop;               //XPOP店铺
	private Integer allowDelayConfirm = 0;//是否让延迟默认收货
	private Integer quantity; //数量
	private Integer hasInvoice;//是否要发票 0否1是
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
