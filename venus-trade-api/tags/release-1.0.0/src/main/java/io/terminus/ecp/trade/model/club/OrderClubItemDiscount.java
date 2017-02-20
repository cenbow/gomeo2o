package io.terminus.ecp.trade.model.club;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yangzefeng on 15/1/10
 */
@Data
public class OrderClubItemDiscount implements Serializable {
    private static final long serialVersionUID = 5528079025494485601L;

    /**
     * 自增组件
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
     * sku id
     */
    private Long skuId;

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 商品原价
     */
    private Integer skuPrice;

    /**
     * 商品专享价
     */
    private Integer clubSkuPrice;

    /**
     * 优惠金额
     */
    private Integer discount;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}
