package cn.com.gome.trade.dto.openapi.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class CommonAttribute implements Serializable {
	private static final long serialVersionUID = 6047156879536396094L;
	
	private String name;
	private String value;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
