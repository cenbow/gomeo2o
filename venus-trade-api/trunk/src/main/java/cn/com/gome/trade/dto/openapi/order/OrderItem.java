package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Data
public class OrderItem implements Serializable {
	private static final long serialVersionUID = -4081657772042732983L;
	private Long id;   									// 订单商品行
	private Sku sku;   								// sku
	private Integer quantity; 							// 订单商品数量
	private Integer paymentAmount;                     // 支付价格
    private Integer orderAmount;                       // 原价
    private List<Activity> activities;                        //活动信息列表
         
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
