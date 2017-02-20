package cn.com.gome.trade.dto.deliveryorder;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.MshopDto;
import cn.com.gome.trade.dto.common.SkuDto;
import cn.com.gome.trade.dto.ordercreation.ActivityDto;

@Data
public class DeliveryOrderItem implements Serializable {
	private static final long serialVersionUID = -4081657772042732983L;
	private Long id;   									// 订单商品行
	private SkuDto sku;   								// sku
	private Integer quantity; 							// 订单商品数量
	private Integer orderAmount;    					// 订单商品行金额（原始金额）
	private Integer paymentAmount;    					// 订单商品行支付金额（实际金额）
	private Boolean hasComment = false; 				// 是否评价
	private MshopDto mshop;								// 美店信息
	private Boolean returnGoodsForSevenDays;			// 7天换货
	private Boolean changeGoodsForFifteenDays;			// 15天换货
	private String sourceCode; 							// 订单商品来源
	private Integer afterSalesFlag;             		// 申请售后标志 0不可申请售后 1可以申请售后
	private List<ActivityDto> activities;          	// 活动信息
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
