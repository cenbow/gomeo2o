package cn.com.gome.trade.dto.openapi.deliverylogistics;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class LogisticsMessage implements Serializable {
	
	private static final long serialVersionUID = 8896437113586532553L;
	
	private String message;
	private String time;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
