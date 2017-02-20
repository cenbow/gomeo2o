/*
 *
 *  * Copyright (c) 2015 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.dto.MergerOrderDto;
import io.terminus.ecp.trade.dto.OrderDetailWithActions;
import io.terminus.ecp.trade.dto.RichMergerOrderDto;
import io.terminus.ecp.trade.dto.RichOrderWithActions;
import io.terminus.ecp.trade.model.MergerOrder;
import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.flow.OrderActionInstance;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cn.com.gome.trade.dto.TradeUser;
import cn.com.gome.trade.dto.userdto.EcpLoginUser;
import cn.com.gome.trade.dto.userdto.LoginUser;

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
    		BaseUser loginer,
            Map<String, Serializable> context
    );
    /**
     * 查看订单列表
     * @param context 参数上下文
     * @return map结果集
     */
    @Export(paramNames = { "context"})
    Response<Paging<RichOrderWithActions>> viewOrdersWithoutUser(
           BaseUser loginUser, Map<String, Serializable> context
    );
    /**
     * 查看订单列表  包含总单
     * @param loginer 当前登录用户
     * @param context 参数上下文
     * @return map结果集
     * 
     * tangfeng 20160303
     */
    @Export(paramNames = {"loginer", "context"})
    Response<Paging<RichMergerOrderDto>> viewUnionOrdersList(EcpLoginUser loginer,Map<String, Serializable> context);
    
    
    

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
    
    /**
     * 买家待付款列表（待付款订单20160118）
     * @param loginer 当前登录用户
     * @param context 参数上下文
     * @return map结果集
     */
    Response<List<MergerOrderDto>> viewMergerOrders(EcpLoginUser loginer,
            Map<String, Serializable> context);
    
    /**
     * 获取合单(20160120)
     * @param mergerId 合单ID
     * @return
     */
    Response<MergerOrder> findMergerOrderById(Long mergerId);
    /**
     * 根据mergerId获取 订单集合(20160120)
     * @param mergerId
     * @return
     */
    Response<List<Order>> findOrdersByMergerId(Long mergerId);
}
