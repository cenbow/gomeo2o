package cn.com.gome.trade.dto.common;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.ordercreation.ActivityDto;

@Data
public class LogisticsOrderItemDto implements Serializable {

	private static final long serialVersionUID = 5161060231591592519L;
	
	private Long id;
	private SkuDto sku;
	private Integer quantity;
	//活动信息：type = 1：团购类型   2：跨境商品  3：国美在线电器商品  4：海外购商品
	private List<ActivityDto> activities;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
