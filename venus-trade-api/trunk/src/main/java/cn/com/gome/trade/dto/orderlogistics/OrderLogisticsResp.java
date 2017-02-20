package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;

import cn.com.gome.trade.dto.common.LogisticsMessageDto;
import cn.com.gome.trade.dto.common.LogisticsOrderItemDto;
import cn.com.gome.trade.dto.common.LogisticsVendorDto;

@Data
public class OrderLogisticsResp implements Serializable {
	private static final long serialVersionUID = 406634781575073531L;

	private String no;
	private LogisticsVendorDto logisticsVendor;
	private Integer status;
	private String statusDesc;
	private Integer type;
	private List<LogisticsOrderItemDto> orderItems = Lists.newArrayList();
	private List<LogisticsMessageDto> messages = Lists.newArrayList();
	private List<LogisticsDeliveryDto> LogisticsDeliveries;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
