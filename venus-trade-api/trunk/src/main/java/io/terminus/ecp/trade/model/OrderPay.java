/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import com.google.common.collect.Lists;
import io.terminus.common.utils.Splitters;
import io.terminus.ecp.trade.enums.PaidStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static io.terminus.common.utils.Arguments.equalWith;
import static io.terminus.common.utils.Arguments.notEmpty;
import static io.terminus.common.utils.Arguments.notNull;

/**
 * 订单支付,买家下单后,商户会为该买家此次交易创建一条交易记录，并记录其购买商品
 * 支付状态<br>
 *
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-05 3:41 PM  <br>
 * Author: xiao
 * @see io.terminus.ecp.trade.enums.PaidStatus
 * @see io.terminus.ecp.trade.enums.OrderType
 */
@Data
public class OrderPay implements Serializable {

    private static final long serialVersionUID = 8876835608484173814L;

    /** ID */
    private Long id;
    /** 交易流水号 */
    private String tradeNo;
    /** 总订单ID */
    private Long orderId;
    /** 子订单ID串, 以逗号分隔，最多10个 */
    private String orderIds;
    /**
     * 子订单类型:
     * @see io.terminus.ecp.trade.model.OrderItem.Type
     */
    private Integer orderType;
    /** 商品标题 */
    private String subject;
    /** 商品内容 */
    private String content;
    /** 支付金额 */
    private Integer fee;
    /** 交易渠道 */
    private String channel;
    /** 支付平台交易流水号  */
    private String paymentCode;
    /** 支付方式,在线|货到付款 */
    private Integer paidType;
    /** 支付状态 0:未支付 1:已支付 -1:支付超时 */
    private Integer paidStatus;
    /** 是否合并支付 */
    private Boolean multi;
    /** 交易超时时间 */
    private Date expiredAt;
    /** 支付时间 */
    private Date paidAt;

    private Date createdAt;

    private Date updatedAt;


    public Boolean hasPaid() {
        return equalWith(paidStatus, PaidStatus.PAID.value());
    }

    public List<Long> getPaidOrderIds() {
        List<Long> ids;
        if (notNull(this.getOrderId())) {
            ids = Lists.newArrayList(this.getOrderId());
        } else if (notEmpty(this.getOrderIds())) {
            ids = Splitters.splitToLong(this.orderIds, Splitters.COMMA);
        } else {
            ids = Collections.emptyList();
        }

        return ids;
    }
}
