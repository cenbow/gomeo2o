package cn.com.gome.trade.dto.comment;
import java.io.Serializable;

import lombok.Data;

@Data
public class OrderItemCanCommented implements Serializable {
	private static final long serialVersionUID = 35162148516438198L;
	private Long orderItemId;		//订单商品行id
	private Boolean isCommented;	//是否可以评价
	
}