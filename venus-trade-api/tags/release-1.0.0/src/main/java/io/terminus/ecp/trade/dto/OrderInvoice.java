/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderTrack;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Effet
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderInvoice extends Order {
    private static final long serialVersionUID = 8432671039210438355L;

    /**
     * 订单额外信息 (发票信息)
     */
    private OrderExtra orderExtra;

    /**
     * 订单跟踪信息 (支付时间)
     */
    private OrderTrack orderTrack;

    /**
     * 开票人姓名
     */
    private String invoicingName;
}
