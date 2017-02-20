package cn.com.gome.trade.dto.push;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class OrderUpdateInfo implements Serializable {

	private static final long serialVersionUID = -8836224498407398102L;
	private Long id;
	private Integer status;
	private Long updateTime;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
