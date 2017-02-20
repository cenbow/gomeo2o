/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import java.io.Serializable;

import lombok.Data;
import cn.com.gome.trade.dto.itemdto.Item;
import cn.com.gome.trade.dto.itemdto.Sku;

/**
 * SKU和商品
 * Created by yangzefeng on 14-9-11
 */
@Data
public class SkuAndItem implements Serializable {

    private static final long serialVersionUID = -3452135336633861694L;

    /**
     * SKU
     */
    private Sku sku;

    /**
     * 商品
     */
    private Item item;
}
