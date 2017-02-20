package cn.com.gome.trade.dto.openapi.deliverylogistics;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class LogisticsVendor implements Serializable {
	private static final long serialVersionUID = -2485219656593105157L;
	
	private String id;
	private String name;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
