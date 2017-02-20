package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import cn.com.gome.trade.dto.common.LogisticsMessageDto;
import cn.com.gome.trade.dto.common.LogisticsVendorDto;

@Data
public class LogisticsDeliveryDto implements Serializable {
	private static final long serialVersionUID = 6914224639332910512L;
	
	private Long id;
	private String no;
	private String status;
	private String statusDesc;
	private Integer type;
	private LogisticsVendorDto logisticsVendor;
	private List<LogisticsMessageDto> messages;
	private List<OrderDeliveryDetailDto> orderItems;

}
