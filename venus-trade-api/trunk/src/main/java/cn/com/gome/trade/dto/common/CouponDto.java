package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class CouponDto implements Serializable {
	private static final long serialVersionUID = -1575322657868913511L;
	private Long id;  //主键id
	private Long shopId;  //店铺金额
	private Long startTime; //有效开始时间
	private Long endTime;
	private Integer type;
	private Integer money;
	private Integer quantity;
	private Integer baseMoney; 
	private Long planId;
	private String planName;
	private String budgetCode;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
