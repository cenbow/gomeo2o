/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.item.model.Sku;
import io.terminus.ecp.trade.model.OrderItem;
import lombok.Data;

import java.io.Serializable;

/**
 * 子订单详细
 * Created by yangzefeng on 14-9-18
 */
@Data
public class RichOrderItem implements Serializable {

    private static final long serialVersionUID = 2186027317791755095L;

    /**
     * 子订单
     */
    private OrderItem orderItem;

    /**
     * SKU
     */
    private Sku sku;

    /**
     * 售后状态
     */
    private Integer afterSaleStatus;
}
