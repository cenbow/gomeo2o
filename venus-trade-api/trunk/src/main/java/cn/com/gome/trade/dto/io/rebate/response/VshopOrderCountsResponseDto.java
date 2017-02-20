package cn.com.gome.trade.dto.io.rebate.response;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class VshopOrderCountsResponseDto implements Serializable {
	private static final long serialVersionUID = -1326286059175726604L;
	private Integer orderQuantity;
	private Integer itemQuantity;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
