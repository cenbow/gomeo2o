package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.model.OrderItem;

import java.io.Serializable;

import lombok.Data;
import cn.com.gome.trade.dto.itemdto.Sku;

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
