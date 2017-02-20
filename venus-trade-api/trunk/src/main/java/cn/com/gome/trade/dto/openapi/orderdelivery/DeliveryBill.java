package cn.com.gome.trade.dto.openapi.orderdelivery;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class DeliveryBill implements Serializable {
	private static final long serialVersionUID = -1047333054065274125L;
	
	private Long id;
	private String logisticsNo;
	private LogisticsVendor logisticsVendor;
	private List<DeliveryItem> orderItems;
	private List<DeliveryMessage> messages;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
