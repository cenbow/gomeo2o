/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.item.model.Sku;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 子订单
 * Created by yangzefeng on 14-9-12
 */
@Data
public class PreOrderItem implements Serializable {

    private static final long serialVersionUID = 2186027317791755095L;

    /**
     * SKU
     */
    private Sku sku;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品图片
     */
    private String itemImage;

    /**
     * 商品额外信息
     */
    private Map<String, Object> itemExtras;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 子订单实付金额
     */
    private Integer fee;

    /**
     * 子订单运费
     */
    private Integer shipFee;
}
