package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class Invoice implements Serializable {
	private static final long serialVersionUID = 3288819053262864092L;
	private Integer type;		// 发票类型
	private String typeDesc;	// 发票类型描述
	private Integer titleType;  // 发票抬头类型
	private String title;		//发票抬头类型描述（匹配返回值）
	private String content;		//发票内容

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}