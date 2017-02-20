/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by yangzefeng on 15/5/6
 */
@Data
public class OrderDiscountDetail implements Serializable {
    private static final long serialVersionUID = 3741262860796350359L;

    private Long id;

    /**
     * 子订单id
     */
    private Long orderItemId;

    /**
     * 优惠明细类型
     */
    private Integer type;

    /**
     * 优惠金额
     */
    private Integer price;

    /**
     * 优惠券或者活动id
     */
    private Long couponOrActivityId;

    /**
     * 优惠券或者活动名称
     */
    private String couponOrActivityName;

    /**
     * 预算号
     */
    private String budgetCode;

    private Date createdAt;

    private Date updatedAt;


    public static enum Type {
        SELLER_COUPON(1, "商家券"),
        SELLER_ACTIVITY(2, "商家活动"),
        PLATFORM_COUPON(3, "平台券"),
        PLATFORM_ACTIVITY(4, "平台活动"),
        ONCEPURCHASE_COUPON(5, "下单立减劵");

        private final int value;

        private final String display;

        private Type(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        @Override
        public String toString() {
            return this.display;
        }

        public Integer value() {
            return this.value;
        }

        public Type fromValue(int value) {
            for(Type t : Type.values()) {
                if(Objects.equals(t.value, value)) {
                    return t;
                }
            }
            return null;
        }
    }
}
