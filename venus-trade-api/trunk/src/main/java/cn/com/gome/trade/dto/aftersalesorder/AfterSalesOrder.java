package cn.com.gome.trade.dto.aftersalesorder;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.ordercreation.Buyer;

import com.google.common.collect.Lists;

@Data
public class AfterSalesOrder implements Serializable {
	private static final long serialVersionUID = 2771780584893211035L;
	
	private Long id;						//售后单id
	private Integer type;					//售后单类型
	private String typeDesc;				//售后单类型描述
	private Integer status;					//售后单状态
	private String statusDesc;				//售后单状态描述
	private Integer orderType;				//订单类型
	
	private Integer refundAmount;        	//退款金额
	private Integer paymentAmount;          //支付金额
	private Integer orderAmount;			//订单金额-原始金额
	private Integer shippingCost;			//运费
	private Integer quantity;				//售后商品总数量
	private String reason;					//原因
	private String memo;					//说明
    private Long orderId;					//订单id
    private Boolean hasLogistics;			//是否有物流
    private Buyer buyer;					//买家信息
    private Integer mshopCommission;		//美店佣金
    private Integer maxRefundShippingCost;	//最大返还运费
    
    //优惠组合信息
  	private Integer platformCouponMoney; 	//通用红包优惠抵扣
  	private Integer shopCouponMoney; 		//店铺红包优惠抵扣
  	private Integer onePurchaseMoney; 		//下单立减金额
  	private Integer gomeMoney; 				//国美币优惠抵扣
  	private Integer shopDiscountMoney;  	//店铺直降价格
  	
    private List<AfterSalesOrderItem> orderItems = Lists.newArrayList();
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
