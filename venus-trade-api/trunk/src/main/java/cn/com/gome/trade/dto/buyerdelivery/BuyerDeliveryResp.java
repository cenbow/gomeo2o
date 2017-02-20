package cn.com.gome.trade.dto.buyerdelivery;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class BuyerDeliveryResp implements Serializable {
	private static final long serialVersionUID = -665062897132238922L;
	
	private Boolean result;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
