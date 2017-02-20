package cn.com.gome.trade.dto.push;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Data
public class PushShop implements Serializable {
	private static final long serialVersionUID = 2542682936951205880L;
	
	private Long id;
	private String name;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	

}
