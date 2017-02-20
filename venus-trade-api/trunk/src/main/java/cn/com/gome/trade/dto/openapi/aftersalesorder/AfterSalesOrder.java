package cn.com.gome.trade.dto.openapi.aftersalesorder;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.openapi.common.CommonSku;

@Data
public class AfterSalesOrder implements Serializable {
	private static final long serialVersionUID = 760709223465249272L;
	
	private Long id;						//售后单id
	private Integer type;					//售后单类型
	private String typeDesc;				//售后单类型描述
	private Integer status;					//售后单状态
	private String statusDesc;				//售后单状态描述
	
	private Integer refundAmount;        	//退款金额
	private Integer paymentAmount;          //支付金额
	private Integer shippingCost;			//运费
	private Integer quantity;				//售后商品总数量
	private String reason;					//原因
	private String memo;					//说明
    private Long orderId;					//订单id
    private Integer refundShippingCost;		//返还运费
    private Long orderItemId;				//订单商品id
    
    private CommonSku sku;					//商品sku

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
