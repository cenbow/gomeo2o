/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade;

import io.terminus.ecp.pay.model.PayChannel;
import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderPay;

import java.io.Serializable;
import java.util.Map;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-27 3:23 PM  <br>
 * Author: xiao
 */
public interface PaidInterceptor {


    /**
     * 此方法将在订单状态更新为支付成功后被调用, 比如支付完成后赠送积分、优惠券等
     * @param order 主订单
     * @param payChannel 订单的支付渠道信息(可能会根据渠道来决定商户的营销)
     * @param context 参数上下文
     * @throws Exception 如果出现错误, 抛出异常
     */
    void postHandle(Order order,  PayChannel payChannel, Map<String, Serializable> context)
            throws Exception;
}
