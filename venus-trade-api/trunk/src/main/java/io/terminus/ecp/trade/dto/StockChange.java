/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 库存变量
 * Created by yangzefeng on 14-9-22
 */
@Data
public class StockChange implements Serializable {

    private static final long serialVersionUID = -2861345305442447558L;

    /**
     * SKU ID
     */
    private Long skuId;

    /**
     * 商品 ID
     */
    private Long itemId;

    /**
     * 购买数量
     */
    private Integer quantity;
}
