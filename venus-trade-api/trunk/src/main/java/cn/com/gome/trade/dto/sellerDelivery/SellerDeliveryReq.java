package cn.com.gome.trade.dto.sellerDelivery;

import java.io.Serializable;

import lombok.Data;

@Data
public class SellerDeliveryReq implements Serializable {

	private static final long serialVersionUID = 4727000416735038420L;
	
	private Long orderId;           // 订单id
    private Long logisticVenderId;  // 供应商id
    private String logisticNo;      // 物流号

}
