package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class DeliveryDto implements Serializable {
	private static final long serialVersionUID = -6406406512058141082L;
	private Integer timeType;
	private String timeTypeDesc;//发货类型描述
	private Boolean needConfirmation;
	private String memo;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}