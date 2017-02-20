package io.terminus.ecp.trade.dto;

import java.io.Serializable;

import lombok.Data;
import io.terminus.ecp.trade.model.OrderComment;
import io.terminus.ecp.trade.model.OrderItem;

@Data
public class OrderItemWithCommentDto implements Serializable{

	private OrderItem orderItem;
	private Boolean hasNormalComment;
	private OrderComment orderComment;
}
