package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class AttributeDto implements Serializable {
	private static final long serialVersionUID = 1173124833021121000L;
	private String name; 		// 销售属性名称
	private String value; 		// 销售属性值
}
