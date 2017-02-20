/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 预支付DTO
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-06 5:42 PM  <br>
 * Author: xiao
 */
@Data
public class PrePay implements Serializable{

    private static final long serialVersionUID = 8507370437325225475L;

    /**
     * 待支付订单列表
     */
    private List<OrderAndActionInstanceId> orderAndActionInstanceIds;
    /**
     * 是否合并支付，默认为FALSE
     */
    private Boolean multi = Boolean.FALSE;
    /**
     * 是否仅包含货到付款订单
     */
    private Boolean onlyCod;
    /**
     * 订单总额，只统计在线支付订单实付款
     */
    private Integer fee;
    /**
     * Action实例ID
     */
    private Long aid;
}
