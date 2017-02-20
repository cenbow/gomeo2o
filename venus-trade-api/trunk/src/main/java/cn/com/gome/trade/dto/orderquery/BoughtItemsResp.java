package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
@Data
public class BoughtItemsResp implements Serializable{


	private static final long serialVersionUID = 3691886400041634858L;

	private List<BoughtItem> shareOrderItems;  //订单列表
	private Long total;            //总订单数
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
