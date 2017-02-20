/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 总订单信息: 总订单 + 子订单列表
 * Created by yangzefeng on 14-9-12
 */
@Data
public class OrderAndOrderItems implements Serializable {

    private static final long serialVersionUID = -2423492797811902361L;

    /**
     * 总订单
     */
    private Order order;

    /**
     * 子订单列表
     */
    private List<OrderItem> orderItems;
}
