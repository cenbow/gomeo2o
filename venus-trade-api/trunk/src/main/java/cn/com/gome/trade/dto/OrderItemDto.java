package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.model.OrderItem;

import java.io.Serializable;

import lombok.Data;
import cn.com.gome.trade.dto.itemdto.Item;
import cn.com.gome.trade.dto.itemdto.Sku;

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
