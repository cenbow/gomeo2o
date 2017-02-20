/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderItem;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-09-10
 */
public interface OrderInterceptor {

    /**
     * 这个将在主订单和子订单持久化之前被处理, 通常这里可以插入营销逻辑, 比如修改订单价格等
     * @param order 主订单
     * @param orderItems 子订单列表
     * @param context 参数上下文
     * @return 如果需要继续交给后面chain中的interceptor处理, 则返回true, 否则认为已经处理完毕, 返回false
     * @throws Exception 如果出现错误, 抛出异常
     */
    boolean preHandle(Order order, List<OrderItem> orderItems, Map<String, Serializable> context)
            throws Exception;

    /**
     * 这个将在主订单和子订单持久化之后被处理, 通常这里做些营销活动需要的持久化等
     * @param order 主订单
     * @param orderItems 子订单列表
     * @param context 参数上下文
     * @throws Exception 如果出现错误, 抛出异常
     */
    void postHandle(
            Order order, List<OrderItem> orderItems, Map<String, Serializable> context)
            throws Exception;
}
