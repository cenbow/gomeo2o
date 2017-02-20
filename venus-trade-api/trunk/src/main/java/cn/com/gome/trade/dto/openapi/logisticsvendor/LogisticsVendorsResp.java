package cn.com.gome.trade.dto.openapi.logisticsvendor;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class LogisticsVendorsResp implements Serializable {
	private static final long serialVersionUID = 2221647899914188054L;
	
	List<LogisticsVendor> logisticsVendors = null;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
