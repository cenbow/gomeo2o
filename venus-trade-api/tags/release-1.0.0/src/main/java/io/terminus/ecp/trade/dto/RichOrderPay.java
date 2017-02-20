/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.pay.model.PayStage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单支付详细
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-06 3:20 PM  <br>
 * Author: xiao
 */
@Data
@AllArgsConstructor
public class RichOrderPay implements Serializable {

    private static final long serialVersionUID = -5627358818901347464L;

    /**
     * 阶段支付信息
     * @see io.terminus.ecp.pay.model.PayStage
     */
    private PayStage payStage;

    /**
     * 支付网关地址
     */
    private String gateway;
}
