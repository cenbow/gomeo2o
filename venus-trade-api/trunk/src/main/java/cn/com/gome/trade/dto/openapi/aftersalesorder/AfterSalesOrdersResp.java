package cn.com.gome.trade.dto.openapi.aftersalesorder;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class AfterSalesOrdersResp implements Serializable {
	private static final long serialVersionUID = 4673135402666822725L;
	
	private List<AfterSalesOrder> afterSalesOrders;
	private Long total;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
