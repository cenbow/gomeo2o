package cn.com.gome.trade.dto.openapi.orderdelivery;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class DeliveryItem implements Serializable {
	private static final long serialVersionUID = 6053694742158829960L;
	
	private Long id;
	private Integer quantity;
	private Long skuId;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
