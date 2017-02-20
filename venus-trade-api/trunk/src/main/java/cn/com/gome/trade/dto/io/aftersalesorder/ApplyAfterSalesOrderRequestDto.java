package cn.com.gome.trade.dto.io.aftersalesorder;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class ApplyAfterSalesOrderRequestDto implements Serializable {
	private static final long serialVersionUID = -2660157740054379201L;
	
	private Long orderItemId;         	//订单商品行id
	private Long userId;				//当前用户id
	private String reason;				//退货款理由
	private String memo;				//备注
	private Integer type;				//2表示申请退货，3表示申请换货
	private Integer quantity;			//退换货数量
	private String deliverMethod;		//发货方式
	private String mailAddress;		//送货地址
	private String collectingMethod;		//送货方式
	private String shippingGroupId;		//配送单id
	private Integer refundAmount;		//退款金额
	private String outAfterSaleIds;		//外部售后单ids
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
