package cn.com.gome.trade.dto.aftersalesorder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.BuyerDto;
import cn.com.gome.trade.dto.common.ConsigneeDto;
import cn.com.gome.trade.dto.common.DeliveryDto;
import cn.com.gome.trade.dto.common.InvoiceDto;
import cn.com.gome.trade.dto.common.SellerDto;
import cn.com.gome.trade.dto.common.ShopDto;

@Data
public class AfterSalesOrderResp implements Serializable {
	private static final long serialVersionUID = 6965590042184636866L;
	
	private Long orderId;  		//订单号
	private Long orderItemId;  	//子订单号
	private Integer orderType; 	//订单类型  1 普通订单  5 O2M订单
	private Integer quantity; 	// 售后单商品总量
			
	//退款订单Top展示
	private Long id;			//售后单号
	private Integer type;		//售后方式
	private String typeDesc;    //售后方式  中文翻译
	private Integer status;		//售后单状态
	private String statusDesc;  //售后单状态  中文翻译
			
	private String reason;	    //退货原因
	private String memo;	    //退货说明
	//订单商品信息
	private List<AfterSalesOrderItem> orderItems = new ArrayList<AfterSalesOrderItem>();
	//退款信息
	private Integer payType;				//支付方式
	private String payTypeDesc;             //支付方式  中文翻译
	private String refundReturnType;	    //退款返回方式
	
	private Integer refundType;     		//退款类型
	private String refundTypeDesc;     		//退款类型
			
	private BuyerDto buyer;					//买家
	private SellerDto seller;				//卖家
	private ConsigneeDto consignee;			//收货人信息
	private ShopDto shop;					//店铺信息
	private Integer hasInvoice;             //是否开发票
	private InvoiceDto invoice;				//发票信息
	private DeliveryDto delivery;           //送货信息-配送信息

	private Boolean hasLogistics;           //是否有物流
	
	private Integer refundAmount;			//退款金额
	private Integer returnGomeMoney;		//退还国美币金额
	//付款金额信息
	private Integer shippingCost;				//运费 
	private Integer maxRefundShippingCost;		//最大退还运费 
	private Integer platformCouponMoney; 		//通用红包优惠抵扣
	private Integer shopCouponMoney; 			//店铺红包优惠抵扣
	private Integer onePurchaseMoney; 			//下单立减金额
	private Integer gomeMoney; 					//国美币优惠抵扣
	private Integer paymentAmount;				//实付款（含运费）
	private Integer orderAmount;   				//订单原价
	private Integer shopDiscountMoney;  		//店铺直降价格
			
	//订单时间
	private Long orderTime;					//下单时间
	private Long payTime;					//付款时间 
	private Long applyTime;					//申请时间
	private Long acceptanceTime;		    //售后受理时间
	private Long acceptRefundApplyTime; 	//接受退款时间
	private Long agreeRefundTime;			//卖家操作换货拒收入库时间
	private Long confirmationTime;			//售后单完成时间
	//private Long sendGoodsApplyTime;    	//发货受理时间
	private Long buyerDeliveryTime;      	//买家发货时间
	private Long sellerDeliveryTime;      	//卖家发货时间
	
	private Integer mshopCommission;			//美店佣金

	private String collectingMethod;    //货物回库方式
	private String mailAddress;			//回寄地址
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
