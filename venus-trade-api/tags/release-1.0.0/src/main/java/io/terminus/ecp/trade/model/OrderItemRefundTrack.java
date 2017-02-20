/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 子订单售前退款退货信息
 * Modified by haolin on 2014-12-08
 * Created by yangzefeng on 14-9-5
 */
@Data
public class OrderItemRefundTrack implements Serializable {

    private static final long serialVersionUID = 3119590109897438296L;

    /**
     * ID
     */
    private Long id;
    /**
     * 总订单ID
     */
    private Long orderId;
    /**
     * 子订单ID: 一个子订单对应一条OrderItemRefundTrack记录
     */
    private Long orderItemId;
    /**
     * 买家ID
     */
    private Long buyerId;
    /**
     * 买家名称
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerMobile;
    /**
     * 卖家ID
     */
    private Long sellerId;
    /**
     * 卖家名称
     */
    private String sellerName;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 子订单类型
     */
    private Integer type;
    /**
     * 跟踪信息类型 1->售中 2->售后
     */
    private Integer trackType;
    /**
     * 如果是售中表示子订单状态,如果是售后表示售后状态
     */
    private Integer status;
    /**
     * 子订单支付类型
     */
    private Integer payType;
    /**
     * 退货款理由
     */
    private String reason;
    /**
     * 售后拒绝退货款理由
     */
    private String afterSaleRefuseReason;
    /**
     * 退货款金额
     */
    private Integer refundAmount;
    /**
     * 订单运单号
     */
    private  String waybillNo;
    /**
     * 物流类型
     *
     * <p>0. 无需物流, 1. 第三方物流, 2. 海尔物流
     *
     * @see io.terminus.ecp.trade.enums.LogisticsType
     */
    private Integer logisticsType;
    /**
     * 物流公司代号
     */
    private String logisticsCode;
    /**
     * 物流公司名称
     */
    private String logisticsCompany;
    /**
     * 备注信息,json格式，该信息一致保存，只会更新或覆盖，不会删除
     */
    private String remark;

    /**
     * 退款单额外信息
     */
    private String extra;

    /**
     * 外部退款单号
     */
    private String outRefundTrackId;
    private String reference;
    private String referenceId;
    /**
     * 申请时间
     */
    private Date applyAt;
    /**
     * 审核时间
     */
    private Date checkAt;
    /**
     * 买家发货时间
     */
    private Date buyerDeliverAt;
    /**
     * 卖家发货时间
     */
    private Date sellerDeliverAt;
    /**
     * 退款时间
     */
    private Date refundAt;

    /**
     * 同意退款时间
     */
    private Date agreeRefundAt;

    private Date createdAt;

    private Date updatedAt;

    /**
     * 判断是否售中退款单
     */
    public boolean isOnSale() {
        if(Objects.equals(this.getTrackType(), TrackType.ON_REFUND.value())
                ||Objects.equals(this.getTrackType(), TrackType.ON_RETURNS.value())) {
            return true;
        }
        return false;
    }


    public static enum TrackType {
        ON_REFUND(4, "售中退款", 1, "售中"),
        ON_RETURNS(5, "售中退货", 1, "售中"),
        AFTER_RETURNS(2,"售后退货", 2, "售后"),
        AFTER_EXCHANGES(3, "售后换货", 2, "售后");

        private final int value;

        private final String description;

        private final int supperValue;

        private final String supperDescription;

        private TrackType(int value, String description, int supperValue, String supperDescription) {
            this.value = value;
            this.description = description;
            this.supperValue = supperValue;
            this.supperDescription = supperDescription;
        }

        public static TrackType from(int value) {
            for(TrackType ty : TrackType.values()) {
                if(Objects.equals(ty.value, value)) {
                    return ty;
                }
            }
            return null;
        }

        public int value() {
            return this.value;
        }

        public String description() {
            return description;
        }

        public int getSupperValue(){
            return this.supperValue;
        }


        @Override
        public String toString() {
            return description;
        }
    }
}
