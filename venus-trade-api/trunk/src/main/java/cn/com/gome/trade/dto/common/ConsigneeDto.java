package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class ConsigneeDto implements Serializable {
	private static final long serialVersionUID = 8076732178379449564L;
	private String name;
	private String mobile;
	private String phone;
	private String postCode;
	private String address;
	private String idCard;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
