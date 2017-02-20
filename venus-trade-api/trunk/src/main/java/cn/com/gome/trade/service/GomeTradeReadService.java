package cn.com.gome.trade.service;

import io.terminus.ecp.trade.service.TradeReadService;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cn.com.gome.trade.dto.GomeOrderDetailWithActions;
import cn.com.gome.trade.dto.TradeUser;
import cn.com.gome.trade.dto.common.PageParam;
import cn.com.gome.trade.dto.deliveryorder.OrderDetailReq;
import cn.com.gome.trade.dto.deliveryorder.OrderDetailResp;
import cn.com.gome.trade.dto.deliveryorder.OrdersReq;
import cn.com.gome.trade.dto.deliveryorder.OrdersResp;
import cn.com.gome.trade.dto.o2m.SplitO2MOrder;
import cn.com.gome.trade.dto.openapi.common.CommonBase;
import cn.com.gome.trade.dto.ordercreation.OrderPreview;
import cn.com.gome.trade.dto.orderlogistics.LogisticsDeliveryDto;
import cn.com.gome.trade.dto.orderlogistics.OrderDeliveryLogisticsReq;
import cn.com.gome.trade.dto.orderlogistics.OrderDeliveryLogisticsResp;
import cn.com.gome.trade.dto.userdto.EcpLoginUser;

/**
 * Desc:
 * Mail: F@terminus.io
 * Data: 15/6/15
 * Author: yangzefeng
 */
public interface GomeTradeReadService extends TradeReadService {

    /**
     * 订单详情页
     * @param loginer 登录用户
     * @param orderId 订单id
     * @return 订单详情
     */
    @Export(paramNames = {"loginer", "orderId"})
    Response<GomeOrderDetailWithActions> gomeViewOrder(EcpLoginUser loginer,
                                            @Min(value = 1L, message = "order.id.invalid")
                                            @NotNull(message = "order.id.invalid")
                                            Long orderId);
    
    @Export(paramNames = {"loginer", "orderId"})
    Response<GomeOrderDetailWithActions> gomeViewOrderWithoutUser(TradeUser tradeUser,
                                            Long orderId);
    
    Response<SplitO2MOrder> getO2MSplitOrder(Long userId, List<Long> skuIds);
    
    Response<List<OrderPreview>> getO2MSplitOrder2MeixinOrder( Long userId, List<Long>skuIds);
    
    Response<OrdersResp> queryOrdersList(CommonBase base, PageParam pageParam, OrdersReq ordersReq);
    
    Response<OrderDetailResp> getOrderDetail(CommonBase base, OrderDetailReq orderDetailReq);
    
    Response<OrderDeliveryLogisticsResp> getOrderDeliveryLogistics(OrderDeliveryLogisticsReq orderDeliveryLogisticsReq);
}
