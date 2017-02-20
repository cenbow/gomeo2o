package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class OrderDeliveryLogisticsReq implements Serializable {
	private static final long serialVersionUID = 33428368888656164L;
	private Long orderId;
	private Integer type;
	private Long userId;
	private Long orderdeliveryId;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
