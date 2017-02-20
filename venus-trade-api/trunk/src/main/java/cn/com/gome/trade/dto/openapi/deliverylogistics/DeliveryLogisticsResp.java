package cn.com.gome.trade.dto.openapi.deliverylogistics;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class DeliveryLogisticsResp implements Serializable {

	private static final long serialVersionUID = -6926482044033308119L;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
