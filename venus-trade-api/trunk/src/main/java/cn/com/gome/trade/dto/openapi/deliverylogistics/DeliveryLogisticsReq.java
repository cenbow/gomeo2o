package cn.com.gome.trade.dto.openapi.deliverylogistics;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class DeliveryLogisticsReq implements Serializable {

	private static final long serialVersionUID = 1238957061507144869L;
	
	private Long orderId;
	private Long deliveryBillId;
	private String logisticsNo;
	private LogisticsVendor logisticsVendor;
	private List<LogisticsMessage> logisticsMessages;	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
