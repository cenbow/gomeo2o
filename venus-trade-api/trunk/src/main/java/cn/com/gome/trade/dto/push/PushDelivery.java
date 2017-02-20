package cn.com.gome.trade.dto.push;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class PushDelivery implements Serializable {
	private static final long serialVersionUID = 2528936533997306045L;
	
	private Integer timeType; 			// 送货时间类型 1 2 3
	private String timeTypeDesc; 		// 1 只工作日送货 2 只双休、假日送货 3工作日、双休日与假日均可送货
	private Boolean needConfirmation; 	// 送货前是否确认
	private String memo; 				// 送货备注
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
