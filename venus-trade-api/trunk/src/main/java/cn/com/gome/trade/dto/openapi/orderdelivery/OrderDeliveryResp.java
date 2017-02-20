package cn.com.gome.trade.dto.openapi.orderdelivery;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class OrderDeliveryResp implements Serializable {
	private static final long serialVersionUID = -566269841866186735L;
	
	private Long orderId;
	
	private List<DeliveryBill> deliveryBills;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
