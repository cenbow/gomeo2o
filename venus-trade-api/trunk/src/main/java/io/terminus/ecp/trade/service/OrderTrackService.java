package io.terminus.ecp.trade.service;

import io.terminus.ecp.trade.dto.OrderTrackDto;
import io.terminus.ecp.trade.model.OrderPay;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 功能描述: 订单跟踪信息Service
 * <br>
 *
 * @author wanggen on 14/11/23.
 */
public interface OrderTrackService {


    /**
     * 根据已支付订单的时间范围查询已经支付订单跟踪信息
     *
     * @param sellerId  卖家ID
     * @param paidStart 已支付最小时间
     * @param paidEnd   已支付最大时间
     * @return 订单跟踪信息列表
     */
    Response<List<OrderTrackDto>> listByPaidAtPeriod(Long sellerId, Date paidStart, Date paidEnd, Integer pageNo, Integer pageSize);

    Response<List<OrderTrackDto>> listByXxxAtPeriod(
            @Min(value = 1L, message = "order.seller.id.invalid")
            @NotNull(message = "seller.id.empty") Long sellerId,
            Integer status,
            Date xxxStart, Date xxxEnd,
            Integer pageNo,
            Integer pageSize);


    /**
     * 存放微信支付的openid
     *
     * @param orderPay 商户平台交易记录
     * @param openid  微信支付的用户标识
     * @return 更新是否成功
     */
    Response<Boolean> updateByOrderId(OrderPay orderPay, String openid);

}
