/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service;


import io.terminus.ecp.trade.model.OrderPay;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.NotNull;

/**
 * Desc: 订单支付信息查询Service
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-07 1:38 PM  <br>
 * Author: xiao
 */
public interface OrderPayReadService {


    /**
     * 根据支付流水获取支付信息
     * @param tradeNo   支付流水
     * @return  支付信息
     */
    Response<OrderPay> loadOrderPayByTradeNo(@NotNull(message = "trade.no.invalid") String tradeNo);


}
