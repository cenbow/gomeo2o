package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class LogisticsMessageDto implements Serializable {
	
	private static final long serialVersionUID = -1680167012266452658L;
	
	private String message;
	private Long time;
	private Integer status;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
