/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderTrack;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 订单详情
 * Created by yangzefeng on 14-9-20
 */
@Data
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 3388178886724471844L;

    /**
     * 订单
     */
    private Order order;

    /**
     * 订单状态
     */
    private OrderTrack orderTrack;

    /**
     * 子订单
     */
    private List<OrderItem> orderItems;

    /**
     * 订单附加信息
     */
    private OrderExtra tradeInfo;
}
