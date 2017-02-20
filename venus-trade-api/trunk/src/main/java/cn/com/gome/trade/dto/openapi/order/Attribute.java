package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1173124833021121000L;
	private String name; //销售属性名称
	private String value; //销售属性值 

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
