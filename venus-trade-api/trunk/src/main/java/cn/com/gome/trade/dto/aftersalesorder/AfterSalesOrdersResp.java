package cn.com.gome.trade.dto.aftersalesorder;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class AfterSalesOrdersResp implements Serializable {
	private static final long serialVersionUID = 6965590042184636866L;
	
	private List<AfterSalesOrder> afterSalesOrders = Lists.newArrayList();
	private Long total;            //总订单数
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
