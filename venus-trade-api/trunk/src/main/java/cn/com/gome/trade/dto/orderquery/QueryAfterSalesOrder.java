package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class QueryAfterSalesOrder implements Serializable {
	private static final long serialVersionUID = -3229920461419613354L;
	private Long id;        //售后单Id
	private Integer status; //售后单状态
	private String statusDesc; //售后单状态
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
