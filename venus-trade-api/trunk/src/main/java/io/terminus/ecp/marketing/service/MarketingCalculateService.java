package io.terminus.ecp.marketing.service;

import io.terminus.ecp.marketing.enums.EventType;
import io.terminus.ecp.plugin.model.BestOrderDiscount;
import io.terminus.ecp.plugin.model.DiscountData;
import io.terminus.ecp.plugin.model.FatTradeDataDto;
import io.terminus.ecp.plugin.model.MarketingOrderItem;
import io.terminus.ecp.plugin.model.OrdersDiscount;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Desc: 营销平台外部系统接口
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
public interface MarketingCalculateService {

    /**
     * 计算所有匹配的活动信息
     * @param fatTradeDataDto   订单信息
     * @return  OrdersDiscount
     * 返回总&子订单优惠
     */
    public Response<OrdersDiscount> calculate(FatTradeDataDto fatTradeDataDto);

    /**
     * 计算商品所有匹配的活动信息
     * @param orderItem   商品信息
     * @return  OrdersDiscount
     * 返回商品优惠
     */
    public Response<OrdersDiscount> calculate(MarketingOrderItem orderItem);

    /**
     * 依据子订单的优惠选择计算总订单的优惠结果
     * @param fatTradeDataDto   订单信息
     * @return  List
     * 返回总订单的全部优惠
     */
    public Response<List<DiscountData>> calculateOrderBySelect(FatTradeDataDto fatTradeDataDto);

    /**
     * 获取最优的优惠信息数据
     * @param fatTradeDataDto   相关数据
     * @return  BestOrderDiscount
     * 返回优惠数据结果
     */
    public Response<BestOrderDiscount> calculateBest(FatTradeDataDto fatTradeDataDto);

    /**
     * 执行活动
     * @param fatTradeDataDto   相关数据
     * @return  Boolean
     * 返回执行的优惠活动的结果
     */
    public Response<Boolean> invokeActivity(FatTradeDataDto fatTradeDataDto);

    /**
     * 执行优惠活动
     * @param bestOrderDiscount 最优的优惠数据信息
     * @return  Boolean
     * 返回执行优惠活动的结果
     */
    public Response<Boolean> invokeActivity(BestOrderDiscount bestOrderDiscount);

    /**
     * 执行系统事件对应的活动
     * @param userId    用户编号
     * @param eventType 执行优惠事件
     * @return  Boolean
     * 返回执行结果
     */
    public Response<Boolean> invokeEventActivity(Long userId, EventType eventType);
}
