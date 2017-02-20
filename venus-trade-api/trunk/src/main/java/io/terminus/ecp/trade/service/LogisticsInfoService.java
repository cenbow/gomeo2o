/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */
package io.terminus.ecp.trade.service;

import io.terminus.ecp.trade.dto.LogisticsDto;
import io.terminus.ecp.trade.model.LogisticsInfo;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cn.com.gome.trade.dto.o2m.O2MLogisticsInfo;
import cn.com.gome.trade.dto.openapi.orderdelivery.DeliveryMessage;

import java.util.List;


/**
 * 订单物流 服务类<BR>
 *
 * @author wanggen 2015-01-06 14:50:29
 */
public interface LogisticsInfoService {

    /**
     * 新增
     *
     * @param logisticsInfos add bean
     * @return 新增后的自增序列号
     */
    @Export(paramNames = {"logisticsInfos"})
    public Response<Integer> creates(@NotNull(message = "param.null.error") List<LogisticsInfo> logisticsInfos);


    /**
     * 根据ID查询单条记录
     *
     * @return 返回的 logisticsInfo
     */
    @Export(paramNames = {"id"})
    public Response<LogisticsInfo> findById(@NotNull(message = "param.null.error") Long id);


    /**
     * 根据 id 列表查询多个结果集
     *
     * @param ids 多个id
     * @return LogisticsInfo 列表
     */
    @Export(paramNames = {"ids"})
    public Response<List<LogisticsInfo>> findByIds(List<Long> ids);


    /**
     * 根据 orderId 查询 LogisticsInfo 列表
     *
     * @param orderId 平台订单号
     * @param type    订单类型(1:发货物流，2:退货物流)
     * @return 结果列
     */
    @Export(paramNames = {"orderId", "type"})
    Response<LogisticsDto> findByOrderId(Long orderId, Integer type);
    
    /******************************************
     * @method : 根据配送单id[orderdeliveryId]查询物流信息
     * @param  : orderdeliveryId 配送单id
     * @param  : type 订单类型(1:发货物流，2:退货物流)
     * @author : hushilong
     * @return
     *******************************************/
    @Export(paramNames = {"orderdeliveryId", "type"})
    Response<LogisticsDto> findByOrderDeliveryId(Long orderdeliveryId, Integer type);
    
    /********************************
     * @method : 通过 配送单[orderdeliveryId] 查找退货物流
     * @param  : 配送单id
     * @author : hushilong
     * @return : 物流数据
     *********************************/
    Response<LogisticsDto> findRefundByOrderDeliveryId(
            @Min(value = 1L, message = "order.refund.track.id.invalid")
            @NotNull(message = "order.refund.track.id.invalid") Long orderdeliveryId);

    /**
     * 通过 orderItemId 查找退货物流
     * @param orderItemId 子订单id
     * @return 物流数据
     * @deprecated orderItemId 不唯一，故废弃
     */
    @Deprecated
    Response<LogisticsDto> findRefundByOrderItemId(
            @Min(value = 1L, message = "order.item.id.invalid")
            @NotNull(message = "order.item.id.invalid") Long orderItemId);

    /**
     * 通过 refundTrackId 查找退货物流
     * @param refundTrackId 自订单退货id
     * @return 物流数据
     */
    Response<LogisticsDto> findRefundByRefundTrackId(
            @Min(value = 1L, message = "order.refund.track.id.invalid")
            @NotNull(message = "order.refund.track.id.invalid") Long refundTrackId);

    /**
     * 更新操作
     *
     * @param logisticsInfo 更新操作参数
     * @return 影响行数
     */
    @Export(paramNames = {"logisticsInfo"})
    public Response<Boolean> update(@NotNull(message = "param.null.error") LogisticsInfo logisticsInfo);
  

    /*******************************
     * @method: 根据orderId 更新配送单状态
     * @param : logisticsInfo 更新操作参数
     * @return 影响行数
     *******************************/
    @Export(paramNames = {"logisticsInfo"})
    public Response<Boolean> updateByOrderId(@NotNull(message = "param.null.error") LogisticsInfo logisticsInfo);
    /**
     * 根据序列 id 删除记录
     *
     * @param ids 序列 id 列表
     * @return 删除行数
     */
    public Response<Integer> deleteByIds(@NotNull(message = "param.null.error") List<Long> ids);

    /**
     * 增加O2M传递物流信息
     * @author wangjiatian
     * @param list
     * @return
     */
    public Response<Boolean> insertO2MLogisticsInfo(List<O2MLogisticsInfo> list);

    /**
     * 获取配送单物流信息
     */
	public List<DeliveryMessage> getDeliveryLogisticsInfo(Long orderDeliveryId);
}
