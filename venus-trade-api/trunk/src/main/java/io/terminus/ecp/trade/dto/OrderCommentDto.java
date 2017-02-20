package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.OrderComment;
import io.terminus.ecp.trade.model.OrderItem;
import lombok.Data;

import java.io.Serializable;

/**
 * Mail: F@terminus.io
 * Data: 15/5/26
 * Author: yangzefeng
 */
@Data
public class OrderCommentDto implements Serializable {
    private static final long serialVersionUID = 339869749681171093L;

    private OrderItem orderItem;

    private OrderComment orderComment;

    private Integer itemPrice;
}
