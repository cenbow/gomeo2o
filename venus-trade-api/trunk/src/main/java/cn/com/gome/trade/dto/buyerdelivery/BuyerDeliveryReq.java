package cn.com.gome.trade.dto.buyerdelivery;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class BuyerDeliveryReq implements Serializable {
	private static final long serialVersionUID = -8997709948417179710L;
	
	private Long afterSaleId;  //售后单Id
	private Long logisticsId;  //物流公司ID
	private Long logisticsNo;  //物流单号
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
