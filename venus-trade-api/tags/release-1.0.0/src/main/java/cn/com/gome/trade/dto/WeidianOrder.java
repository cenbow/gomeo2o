package cn.com.gome.trade.dto;

import io.terminus.ecp.item.model.Sku;
import io.terminus.ecp.trade.model.OrderItem;
import lombok.Data;

import java.io.Serializable;

/**
 * Desc:
 * Mail: F@terminus.io
 * Data: 15/8/18
 * Author: yangzefeng
 */
@Data
public class WeidianOrder implements Serializable {
    private static final long serialVersionUID = -235429333126781764L;

    private OrderItem orderItem;

    private Sku sku;
}
