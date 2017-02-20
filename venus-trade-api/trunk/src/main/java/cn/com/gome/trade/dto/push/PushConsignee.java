package cn.com.gome.trade.dto.push;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class PushConsignee implements Serializable {
	private static final long serialVersionUID = 2528936533997306045L;
	
	private String name;
	private String mobile;
	private String phone;
	private String postCode;
	private String address;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
