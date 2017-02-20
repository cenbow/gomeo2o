/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.enums;

/**
 * Created by yangzefeng on 15/1/26
 */
public enum  AfterSaleStatus {

    WAIT_FOR_RETURNS(-101, "退货单待审核"),
    RETURNS_EXPIRE  (-111, "商家审核超时,自动审核通过"),
    SELLER_CONFIRM_RECEIVE(-115, "商家收到退货"),
    DONE            (-109, "退货款完成"),


    WAIT_FOR_EXCHANGES(-117, "换货等待审核"),
    EXCHANGES_SELLER_DELIVER(-123, "卖家已发货"),
    BUYER_CONFIRM_RECEIVE(-124, "买家收到换货"),

    /**
     * 退货换货共用状态
     */
    BUYER_DELIVERED (-107, "客户已发货，商家待收货"),
    AGREED  (-103, "审核通过"),
    REFUSED (-105, "审核不通过"),
    BUYER_REJECTED(-127, "买家拒收"),
    CANCEL_BY_BUYER_REJECT(-131, "买家拒收，运营或商家关闭退款单"),
    SELLER_REJECTED(-129, "卖家拒收"),
    APPLY_AGAIN     (-113, "再次申请退货"),
    //add by xf
    REFUND_RUNNING     (-10, "退款中"),
    APPLY_REFUDN_AGAIN     (-114, "再次申请退款");//向支付宝 微信 等再次发起退款请求

    public final Integer value;

    public final String display;

    private AfterSaleStatus(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public static AfterSaleStatus from(int value) {
        for(AfterSaleStatus ta: AfterSaleStatus.values()) {
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
