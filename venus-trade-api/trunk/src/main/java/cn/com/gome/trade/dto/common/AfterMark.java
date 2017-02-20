/**
 * Copyright (c) 2016 美信网络技术有限公司
 * @author andybin
 * @date 2016年10月21日
 */
package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class AfterMark implements Serializable {
	private static final long serialVersionUID = -7109980216765065189L;
	
	private Integer afterSalesFlag;					//app 售后标志
	private Boolean returnGoodsForSevenDays;		//PC 7天退货
	private Boolean changeGoodsForFifteenDays;    	//PC 15天换货
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
