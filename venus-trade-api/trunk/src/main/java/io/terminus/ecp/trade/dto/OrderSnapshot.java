/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易快照
 *
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-11 4:32 PM  <br>
 * Author: xiao
 */
@Data
public class OrderSnapshot implements Serializable{

    private static final long serialVersionUID = 202772555845990901L;

    /**
     * ID
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 子订单id
     */
    private Long orderItemId;
    /**
     * 卖家id
     */
    private Long sellerId;
    /**
     * 卖家名称
     */
    private String sellerName;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 商品名称
     */
    private String itemName;
    /**
     * 商品主图
     */
    private String mainImage;
    /**
     * 商品售价
     */
    private Integer price;
    /**
     * 商品运费
     */
    private Integer shipFee;
    /**
     * 销售属性，存放格式为json
     */
    private String skuAttributes;
    /**
     * 普通属性
     */
    private String attributes;
    /**
     * 商品详情
     */
    private String detail;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;

    private Date createdAt;

    private Date updatedAt;
}
