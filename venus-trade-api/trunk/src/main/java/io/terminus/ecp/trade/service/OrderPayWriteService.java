/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service;

import io.terminus.ecp.trade.dto.RichOrderPay;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-06 11:49 AM  <br>
 * Author: xiao
 */
public interface OrderPayWriteService {

    /**
     * 创建支付信息(普通订单 非合并付款)
     *
     * @param orderId 需要支付的订单id
     * @param stageInfo 是否返回支付阶段信息 0否 1是
     * @param host    前端请求host
     * @return 订单支付下信息
     */
    Response<RichOrderPay> createNormalOrderPay(@NotNull(message = "order.id.invalid")
                                            @Min(value = 1L, message = "order.id.invalid")
                                            Long orderId,
                                            Integer stageInfo,
                                            @Valid
                                            @NotEmpty(message = "pay.channel.invalid")
                                            String channel,
                                            @NotNull(message = "user.not.login") BaseUser user,
                                            String host);



    /**
     * 创建支付信息(普通订单 合并付款)
     * @param stageInfo 是否返回支付阶段信息 0否 1是
     * @param orderIds 需要支付的订单id字符串 以“,”分隔
     * @return 订单支付下信息
     */
    Response<RichOrderPay> createMultiNormalOrderPay(@NotNull(message = "order.id.invalid")
                                                String orderIds,
                                                 Integer stageInfo,
                                                @Valid
                                                @NotEmpty(message = "pay.channel.invalid")
                                                String channel,
                                                @NotNull(message = "user.not.login") BaseUser user,
                                                String host);







}
