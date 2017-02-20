package cn.com.gome.trade.dto;

import io.terminus.ecp.item.model.Item;
import io.terminus.ecp.item.model.Sku;
import io.terminus.ecp.trade.model.OrderItem;
import lombok.Data;

import java.io.Serializable;

/**
 * Mail: F@terminus.io
 * Data: 15/5/30
 * Author: yangzefeng
 */
@Data
public class OrderItemDto implements Serializable {
    private static final long serialVersionUID = -3517888354391441268L;

    private Sku sku;

    private Item item;

    private OrderItem orderItem;
}
