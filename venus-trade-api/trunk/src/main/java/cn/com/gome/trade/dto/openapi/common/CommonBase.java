package cn.com.gome.trade.dto.openapi.common;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class CommonBase implements Serializable {
	private static final long serialVersionUID = -3829154691187196482L;
	
	private Long userId;
	private Integer userType;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
