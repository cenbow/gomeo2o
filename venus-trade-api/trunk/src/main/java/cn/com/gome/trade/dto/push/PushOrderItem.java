package cn.com.gome.trade.dto.push;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.MshopDto;

@Data
public class PushOrderItem implements Serializable {
	private static final long serialVersionUID = -4081657772042732983L;
	private Long id;						 // 订单商品行
	private PushSku sku;					 // sku
	private Integer quantity;				 // 订单商品数量
	private Integer orderAmount;			 // 订单商品行金额（原始金额）
	private Integer paymentAmount;			 // 订单商品行支付金额（实际金额）
	private MshopDto mshop;					 // 美店信息
	private String sourceCode;				 // 订单商品来源
	private Boolean hasComment;				 // 是否评价
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
