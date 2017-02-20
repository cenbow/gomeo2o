package cn.com.gome.trade.dto.common;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class BuyerDto implements Serializable {
	private static final long serialVersionUID = -5102410950294787662L;
	private Long id;
	private String name;
	private String mobile;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}