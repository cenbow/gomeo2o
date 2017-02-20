/*
 *
 *  * Copyright (c) 2015 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.dto.OrderDetailWithActions;
import io.terminus.ecp.trade.dto.RichOrderWithActions;
import io.terminus.ecp.trade.model.flow.OrderActionInstance;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 交易读服务
 * Author: haolin
 * On: 2/28/15
 */
public interface TradeReadService {

    /**
     * 查看订单列表
     * @param loginer 当前登录用户
     * @param context 参数上下文
     * @return map结果集
     */
    @Export(paramNames = {"loginer", "context"})
    Response<Paging<RichOrderWithActions>> viewOrders(
            LoginUser loginer,
            Map<String, Serializable> context
    );

    /**
     * 查看订单详情
     * @param orderId 订单ID
     * @param loginer 当前登录用户
     * @return map结果集
     */
    @Export(paramNames = {"loginer", "orderId"})
    Response<OrderDetailWithActions> viewOrder(
            LoginUser loginer,
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")
            Long orderId
    );

    /**
     * 查询订单可以执行的操作
     * @param loginUser 当前登录用户
     * @param orderId 订单id
     * @return 可执行操作列表
     */
    Response<List<OrderActionInstance>> getOrderNextActionInstance(
            @NotNull(message = "user.not.login") LoginUser loginUser,
            @Min(value = 1L, message = "order.id.invalid")Long orderId);
}
