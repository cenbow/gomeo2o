/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import java.io.Serializable;

import lombok.Data;
import cn.com.gome.trade.dto.itemdto.Sku;

/**
 * 购物车商品
 * Created by yangzefeng on 14-9-19
 */
@Data
public class CartItem implements Serializable {

    private static final long serialVersionUID = -4861387669788687152L;

    /**
     * SKU
     * @see io.terminus.ecp.item.model.Sku
     */
    private Sku sku;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品状态
     */
    private Integer itemStatus;

    /**
     * 商品类型
     */
    private Integer itemType;

    /**
     * 商品主图
     */
    private String itemImage;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 购买数量
     */
    private Integer count;
}
