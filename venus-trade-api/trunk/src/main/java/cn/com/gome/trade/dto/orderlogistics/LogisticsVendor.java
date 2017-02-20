package cn.com.gome.trade.dto.orderlogistics;
import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class LogisticsVendor implements Serializable {
	private static final long serialVersionUID = 4639114491922128426L;
	private Long id;
	private String name;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}