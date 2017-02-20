/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.enums;

/**
 * 订单状态枚举
 * Created by yangzefeng on 14-9-10
 */
public enum Status {

    /** 普通订单 在线支付和货到付款共用状态 **/
    PAID                    (1, "付款", "已付款"),
    TOBECONFIRMED           (11, "待系统确认", "待系统确认"),
    DELIVERD                (2, "发货", "已发货"),
    DONE                    (3, "买家确认收到货物", "交易完成"),
    LOCKED                  (4, "订单锁定", "订单已锁定，不能修改"),
    Refunding               (5, "正在退款", "正在退款"),

    CANCEL_BY_BUYER         (-6, "买家取消订单", "买家取消订单"),
    CANCEL_BY_SELLER        (-7, "卖家取消订单", "卖家取消订单"),
    DELETE_BY_BUYER         (-11, "买家删除订单", "买家删除订单"),
    BUYER_REJECT            (-12, "买家拒收", "买家已拒收"),

    BUYER_WAIT_FOR_RETURNS  (-3, "买家申请退货", "买家申请退货中"),
    SELLER_WAIT_FOR_RETURNS (-4, "卖家同意退货", "卖家等待买家退货"),
    BUYER_RETURNS_REFUSED   (-9, "买家申请退货被拒绝", "退货申请被拒绝,可重新申请退货,平台可介入"),
    CANCEL_BY_RETURNS       (-5, "卖家确认收到退货,同时退款", "退货成功并已退款,订单关闭"),


    /** 普通订单 在线支付状态列表 **/
    OL_WAIT_FOR_PAID        (0,  "普通订单在线支付下单成功", "等待买家付款"),
    OL_BUYER_WAIT_FOR_REFUND(-1, "买家申请退款", "买家申请退款中"),
    OL_REFUND_AGREED        (-10,"卖家同意买家的退款申请", "卖家正在受理买家的退款申请"),
    OL_BUYER_REFUND_REFUSED (-8, "买家申请退款被拒绝", "退款申请被拒绝,可重新申请退款,平台可介入"),
    OL_CANCEL_BY_REFUND     (-2, "卖家退款", "退款成功,订单关闭"),


    /**
     * 预售订单 在线支付状态列表
     */
    PRE_SALE_BARGAIN_WAIT_FOR_PAY  (100, "预售订单下单成功", "预售定金等待付款"),
    PRE_SALE_BARGAIN_PAID   (101, "预售支付定金", "预售定金已支付"),
    PRE_SALE_BALANCE_WAIT_FOR_PAY  (102, "预售结束", "预售尾款等待付款"),
    PRE_SALE_BALANCE_PAID   (103, "预售支付尾款", "等待卖家发货"),
    PRE_SALE_DELIVER        (104, "预售发货", "卖家已发货"),
    PRE_SALE_DONE           (105, "确认收货", "买家确认收货");

    public final int value;
    public final String action;
    @SuppressWarnings("unused")
    public final String description;

    private Status(int value, String action, String description) {
        this.value = value;
        this.action = action;
        this.description = description;
    }

    public static Status from(int value) {
        for(Status ta: Status.values()) {
            if(ta.value==value) {
                return ta;
            }
        }

        return null;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
