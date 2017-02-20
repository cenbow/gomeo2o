/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yangzefeng on 14-9-12
 */
@Data
public class PreOrder implements Serializable {

    private static final long serialVersionUID = -6316559599731879476L;

    /**
     * 商家名称
     */
    private String sellerName;

    /**
     * 店铺编号
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 商家id
     */
    private Long sellerId;

    /**
     * 是否支持货到付款
     */
    private Boolean supportCOD;

    /**
     * 是否支持增值税发票
     */
    private Boolean supportVAT;

    /**
     * 是否支持电子发票
     */
    private Boolean supportEinvoice;

    /**
     * 总订单运费
     */
    private Integer deliverFee;

    /**
     * @see io.terminus.ecp.trade.dto.PreOrderItem
     */
    private Iterable<? extends PreOrderItem> preOrderItems;
}
