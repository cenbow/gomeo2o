package cn.com.gome.trade.dto.openapi.aftersalesorder;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.openapi.common.PageParamReq;

@Data
@EqualsAndHashCode(callSuper=false)
public class AfterSalesOrdersReq extends PageParamReq implements Serializable {
	private static final long serialVersionUID = -471025256923667121L;
	
	private Long userId;
	private Long start;
	private Long end;
	private Integer type;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
