package cn.com.gome.trade.dto.openapi.common;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class CommonItem implements Serializable {
	private static final long serialVersionUID = -4520522755143011090L;
	
	private Long id;
	private String name;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
