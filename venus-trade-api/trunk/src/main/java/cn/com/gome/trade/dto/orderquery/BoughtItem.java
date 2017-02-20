package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;
import java.util.List;

import cn.com.gome.trade.dto.common.ShopDto;
import cn.com.gome.trade.dto.ordercreation.Buyer;
import cn.com.gome.trade.dto.ordercreation.Seller;
import cn.com.gome.trade.dto.ordercreation.Sku;
import lombok.Data;
@Data
public class BoughtItem implements Serializable{


	private static final long serialVersionUID = 5582281879656796615L;

	private Long orderId;
	private Long orderItemId;
	private Boolean hasComment;
	private String commentContent;
	private List<String> commentImages;
	//private Buyer buyer;
	//private Long buyerId;
	//private Long sellerId;
	//private Seller seller;
	//private ShopDto shop;
	private Long shopId;
	private Sku sku;
	private Integer quantity;
	
	
}
