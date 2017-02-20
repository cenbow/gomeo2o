/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 子订单信息
 * Modified by haolin on 2014-12-08
 * Created by yangzefeng on 14-9-5
 */
@Data
public class OrderItem implements Serializable {

    private static final long serialVersionUID = -5015101716325458209L;

    /**
     * ID
     */
    private Long id;
    /**
     * 总订单ID
     */
    private Long orderId;
    /**
     * 买家ID
     */
    private Long buyerId;
    /**
     * 卖家ID
     */
    private Long sellerId;
    /**
     * 品牌ID
     */
    private Long brandId;
    /**
     * 卖家店铺行业ID
     */
    private Long businessId;
    /**
     * 运费
     */
    private Integer shipFee;
    /**
     * 子订单总费用: originFee(商品总价) + shipFee(运费) - discount(优惠/折扣)
     */
    private Integer fee;
    /**
     * 最低价
     */
    private Integer lowestFee;
    /**
     * 子订单商品总价
     */
    private Integer originFee;
    /**
     * 优惠折扣
     */
    private Integer discount;
    /**
     * 订单使用的账户余额
     */
    private Integer balance;
    /**
     * 订单使用的退款余额
     */
    private Integer refundBalance;
    /**
     * SKU ID
     */
    private Long skuId;

    /** 外部库存属性 **/
    private String outerSkuId;

    /**
     * 购买数量
     */
    private Integer quantity;
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 商品名称
     */
    private String itemName;
    /**
     * 商品主图
     */
    private String itemImage;
    /**
     * 子订单类型
     */
    private Integer type;
    /**
     * 子订单状态, 来自总订单状态
     */
    private Integer status;
    /**
     * 子订单支付类型
     * @see io.terminus.ecp.trade.enums.PaidType
     */
    private Integer payType;
    /**
     * 是否可申请退款
     */
    private Boolean canRefund;
    /**
     * 是否正在走退货款流程
     */
    private Boolean isRefunding;
    /**
     * 是否评价
     */
    private Boolean hasComment;
    /**
     * 一些额外信息,以json格式存放
     */
    private String otherInfo;

    /**
     * 订单来源
     */
    private String reference;

    /**
     * 来源ID
     */
    private String referenceId;

    /**
     * 返利id
     */
    private String kid;

    private Date createdAt;

    private Date updatedAt;
    
    /**
     *  订单商品行红包价格
     */
    private Integer couponPrice;
    
    /**
     * 子订单类型枚举
     */
    public static enum Type {
        PLAIN(1, "普通交易"),
        PRESELL_DEPOSIT(2,"预售定金"),
        PRESELL_REST(3,"预售尾款");

        private final int value;

        private final String description;

        private Type(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int value() {
            return this.value;
        }

        public String description() {
            return description;
        }


        @Override
        public String toString() {
            return description;
        }
    }

    public static enum Reference {
        SELLER(1, "商家"),
        SUPER_MEM(2, "达人");

        private final int value;

        private final String description;

        private Reference(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int value() {
            return this.value;
        }

        public String description() {
            return description;
        }


        @Override
        public String toString() {
            return description;
        }

        public static Reference from(int value) {
            for(Reference r : Reference.values()) {
                if(Objects.equals(r.value, value)) {
                    return r;
                }
            }
            return null;
        }
    }
}
