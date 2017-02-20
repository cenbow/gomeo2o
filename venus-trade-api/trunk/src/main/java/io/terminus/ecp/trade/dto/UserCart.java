/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户购物车
 * Created by yangzefeng on 14-9-19
 */
@Data
public class UserCart implements Serializable {

    private static final long serialVersionUID = -1162570374269310683L;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 卖家ID
     */
    private Long sellerId;

    /**
     * 店铺主图
     */
    private String shopImage;

    /**
     * 该店铺下购买的商品列表
     * @see io.terminus.ecp.trade.dto.CartItem
     */
    private Iterable<? extends CartItem> cartItems;
}
