/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yangzefeng on 15/5/22
 */
@Data
public class RichOrdersWithContexts {
    private List<Order> order;

    private List<List<OrderItem>> orderItems;

    private List<Map<String, Serializable>> context;
}
