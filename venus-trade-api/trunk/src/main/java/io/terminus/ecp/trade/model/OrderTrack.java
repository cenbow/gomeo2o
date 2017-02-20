/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单跟踪信息
 * Created by yangzefeng on 14-9-5
 * OrderTrack和Order是一一对应的关系
 */
@Data
public class OrderTrack implements Serializable {

    private static final long serialVersionUID = 2385348803419814892L;

    /**
     * ID
     */
    private Long id;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 卖家ID
     */
    private Long sellerId;
    /**
     * 支付ID
     */
    private Long paidId;
    /**
     * 支付流水号
     */
    private String tradeNo;
    /**
     * 支付平台（或网银）交易流水号
     */
    private String payCode;
    /**
     * 支付渠道
     */
    private String channel;
    /**
     * 微信支付openid冗余
     */
    private String openid;
    /**
     * 订单类型,从Order表冗余
     */
    private Integer type;
    /**
     * 支付类型,从Order表冗余
     */
    private Integer payType;
    /**
     * 订单状态,从Order表冗余
     */
    private Integer status;
    /**
     * 是否需要结算
     */
    private Boolean needSettle;
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
     * 冗余ecp_pays表中的 系统内部流水号
     */
    private String systemNo;
    /**
     * 是否已扣除余额
     */
    private Boolean balanceDeduction;
    /**
     * 支付时间,支付网关通知时间
     */
    private Date paidAt;
    /**
     * 买家关闭订单时间
     */
    private Date buyerCancelAt;
    /**
     * 卖家关闭订单时间
     */
    private Date sellerCancelAt;
    /**
     * 发货时间
     */
    private Date deliverAt;
    
    private Date predicateConfirmAt;//预确认收货时间
    /**
     * 完成时间
     */
    private Date doneAt;
    /**
     * 完成或关闭时间(给结算用)
     */
    private Date finishAt;
    /**
     * 删除时间
     */
    private Date deleteAt;

    private Date createdAt;

    private Date updatedAt;
    
    private String payExtra;
}
