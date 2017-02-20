package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class LogisticsVendorDto implements Serializable {
	private static final long serialVersionUID = -2244622751513588858L;
	
	private String id;
	private String name;
	private String code;
	private String logo;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
