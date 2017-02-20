package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class Item implements Serializable {
	private static final long serialVersionUID = 2487295797735724622L;
	private Long id; //商品Id
	private String name; //商品名称
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
