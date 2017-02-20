package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.ConsigneeDto;
import cn.com.gome.trade.dto.common.DeliveryDto;
import cn.com.gome.trade.dto.common.InvoiceDto;

@Data
public class MergerOrderResp implements Serializable {
	private static final long serialVersionUID = -1461894203322634898L;
	
	private Long id;  					//订单编号
	private List<Long> orderIds;
	private Integer status; 			//订单状态
	private String statusDesc; 			//订单状态描述
	private List<WaitPayOrder> orders;	//订单列表  
	private ConsigneeDto consignee;		//收货人信息
	private DeliveryDto delivery;		//发货信息
	private InvoiceDto invoice;			//发票信息
	private Long orderTime;         	//下单时间
	private Long systemTime;  			//服务器系统时间
	private Integer platformCouponMoney;//平台优惠金额
	private Integer shopCouponMoney;	//店铺优惠金额
	private Integer shopDiscountMoney;	//店铺直降金额
	private Integer gomeMoney;			//国美币优惠金额
	private Integer orderAmount;		//订单金额(含运费)
	private Integer paymentAmount;		//实付款（含运费）
	private Integer shippingCost;		//运费
	private Integer onePurchaseMoney; 	//商品券优惠金额-一元购优惠金额
	private Integer hasInvoice;   		//是否开发票
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
