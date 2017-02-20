package cn.com.gome.trade.dto.openapi.logisticsvendor;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class LogisticsVendorsReq implements Serializable {
	private static final long serialVersionUID = 2333641894030814392L;
	
	private String name;
	private Integer status;
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
