package cn.com.gome.trade.dto.push;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.SkuDto;
import cn.com.gome.trade.dto.ordercreation.Mshop;

@Data
public class PushAfterSalesOrderItem implements Serializable {
	private static final long serialVersionUID = -4081657772042732983L;
	
	private Long id;				//售后单商品行id
	private Mshop mshop;			//美店信息
	private PushSku sku;				//sku信息
	private Integer couponMoney;	//优惠券价格
	private Integer gomeMoney;		//国美币价格
	private Integer shippingCost; 	//总运费
	private Integer paymentAmount; 	//总支付金额
	private Integer orderAmount; 	//订单原价
	private Integer discount; 		//直降优惠总额
	private String resource;		//来源
	private Integer quantity;   	//数量
	private String sourceCode;   	//商品来源
	private Integer status;   		//状态
	private String statusDesc;   	//状态描述
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
