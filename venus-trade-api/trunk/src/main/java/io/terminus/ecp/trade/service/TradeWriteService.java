/*
 *
 *  * Copyright (c) 2014 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.service;

import io.terminus.pampas.common.Response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.com.gome.trade.dto.userdto.EcpLoginUser;
import cn.com.gome.trade.dto.userdto.LoginUser;

/**
 * 交易写服务
 * Author: haolin
 * On: 2/3/15
 */
public interface TradeWriteService {

    /**
     * 创建订单(支持批量)
     * @param loginer 当前登录用户
     * @param fids 流程实例ID
     * @param context 参数上下文
     * @return map结果集
     */
    Response<Map<String, Serializable>> createOrder(EcpLoginUser loginer, List<Long> fids, Map<String, Serializable> context);

    /**
     * 所有订单更新操作入口
     * @param loginer 当前登录用户
     * @param aid 动作实例ID
     * @param context 参数上下文
     * @return map结果集
     */
//    Response<Map<String, Serializable>> updateOrder(LoginUser loginer, Long orderId, Long aid, Map<String, Serializable> context);

    /**
     * 所有订单批量更新操作入口
     * @param loginer 当前登录用户
     * @param aid 动作实例ID
     * @param context 参数上下文
     * @return map结果集
     */
    Response<Map<String, Serializable>> updateOrder(EcpLoginUser loginer, List<Long> orderId, Long aid, Map<String, Serializable> context);

    /**
     * 配送单确认收货
     * @param userId
     * @param deliveryId
     * @return
     */
    public Response<Map<String, Serializable>> orderDelievryConfirmation(Long userId,Long orderId, Long deliveryId);
    /**
     * 执行订单定时任务
     * @return 是否成功
     */
    Response<Boolean> executeOrderJobDataSchedule();
}
