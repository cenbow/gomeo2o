package cn.com.gome.trade.dto.io.rebate.request;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class VshopOrderCountsRequestDto implements Serializable {
	private static final long serialVersionUID = -1326286059175726604L;
	private Long vshopId;        	// 美店id
	private Long startAt;			// 起始时间
	private Long endAt;				// 结束时间
	private Integer lowPrice;		// 低价
	private Integer highPrice;		// 高价
	private Integer status;			// 状态
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
