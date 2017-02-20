/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;
import lombok.Data;

import java.io.Serializable;

/**
 * 退款货信息
 * Created by yangzefeng on 14-9-18
 */
@Data
public class RichRefundInfo implements Serializable {

    private static final long serialVersionUID = -4038047693076386341L;
    /**
     * 子订单退货跟踪信息
     */
    private OrderItemRefundTrack orderItemRefundTrack;

    /**
     * 子订单信息
     */
    private OrderItem orderItem;

    /**
     * 总订单
     */
    private Order order;

    /**
     * 订单编号，如果是售中退款单，填orderId；如果是售后退款单，填orderItemId
     */
    private Long id;

    /**
     * 实付款金额，如果是售中退款单，填订单实付款；如果是售后退款单，填子订单实付款
     */
    private Integer fee;
    
    /**
     * 退款运费最大值-订单运费-已退运费
     */
    private Integer maxRefundShipFee;
}
