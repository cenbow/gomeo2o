/*
 *
 *  * Copyright (c) 2015 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.service;

import io.terminus.ecp.trade.dto.OrderFlowDetail;
import io.terminus.ecp.trade.model.flow.OrderActionInstance;
import io.terminus.ecp.trade.model.flow.OrderFlow;
import io.terminus.ecp.trade.model.flow.OrderNodeInstance;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

/**
 * 流程服务(仅ADMIN调用)
 * Author: haolin
 * On: 3/3/15
 */
public interface OrderFlowService {

    /**
     * 创建订单流程
     * @param flow 订单流程
     * @return 订单流程ID
     */
    Response<Long> createOrderFlow(OrderFlow flow);

    /**
     * 更新订单流程
     * @param flow 订单流程
     * @return 更新成功返回true，反之false
     */
    Response<Boolean> updateOrderFlow(OrderFlow flow);

    /**
     * 创建节点实例
     * @param orderNodeInstance 节点实例
     * @return 节点实例ID
     */
    Response<Long> createNodeInstance(OrderNodeInstance orderNodeInstance);

    /**
     * 更新节点实例
     * @param orderNodeInstance 节点实例
     * @return 更新成功返回true，反之false
     */
    Response<Boolean> updateNodeInstance(OrderNodeInstance orderNodeInstance);

    /**
     * 创建动作实例
     * @param orderActionInstance 动作实例
     * @return 动作实例ID
     */
    Response<Long> createActionInstance(OrderActionInstance orderActionInstance);

    /**
     * 更新动作实例
     * @param orderActionInstance 动作实例
     * @return 更新成功返回true，反之false
     */
    Response<Boolean> updateActionInstance(OrderActionInstance orderActionInstance);

    /**
     * 查询订单流程详情
     * @param fid 流程ID
     * @return 订单流程DTO
     */
    @Export(paramNames = {"fid"})
    Response<OrderFlowDetail> findOrderFlowById(Long fid);
}
