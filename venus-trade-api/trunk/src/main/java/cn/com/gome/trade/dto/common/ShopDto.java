package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import lombok.Data;
@Data
public class ShopDto implements Serializable {

	private static final long serialVersionUID = 1495394212214667416L;
	private Long id;
	private String name;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
