package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class OrderDeliveryLogisticsResp implements Serializable {
	private static final long serialVersionUID = 33428368888656164L;
	private List<LogisticsDeliveryDto> orderDeliveries;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
