/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息
 * Created by yangzefeng on 14-9-4
 * Modified by xiao on 2014-11-7
 * Modified by haolin on 2014-12-08
 * @see io.terminus.ecp.trade.enums.Status
 * @see io.terminus.ecp.trade.enums.PaidType
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -157253452712276812L;

    /**
     * ID
     */
    private Long id;

    /**
     * 流程实例ID
     */
    private Long fid;

    /**
     * 节点实例ID
     */
    private Long nid;

    /**
     * 主订单id，对一些服务商品会用到，如果本身是主订单，字段为null
     */
    private Long pid;
    /**
     * 买家ID
     */
    private Long buyerId;
    /**
     * 买家用户名
     */
    private String buyerName;
    /**
     * 买家联系电话
     */
    private String buyerMobile;
    /**
     * 卖家ID
     */
    private Long sellerId;
    /**
     * 卖家用户名
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
     * 店铺行业ID
     */
    private Long businessId;

    /**
     * 店铺行业名称
     */
    private String businessName;
    /**
     * 订单状态
     * @see io.terminus.ecp.trade.enums.Status
     */
    private Integer status;
    /**
     * 订单类型
     * @see io.terminus.ecp.trade.enums.OrderType
     */
    private Integer type;
    /**
     * 订单运费
     */
    private Integer shipFee;
    /**
     * 订单总费用: originFee(订单原价, 即商品总价) + shipFee(运费) - discount(优惠)
     */
    private Integer fee;
    /**
     * 订单原价, 即商品总价
     */
    private Integer originFee;
    /**
     * 优惠(折扣)
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
     * 支付类型
     * @see io.terminus.ecp.trade.enums.PaidType
     */
    private Integer payType;
    /**
     * 是否已支付
     */
    private Boolean hasPaid;
    /**
     * 是否已评价
     */
    private Boolean hasComment;

    /**
     * 是否已结算
     */
    private Boolean hasSettle;

    /**
     * 订单渠道
     */
    private Integer channel;

    /**
     * 订单来源
     */
    private String reference;

    /**
     * 来源id
     */
    private String referenceId;

    /**
     * 订单额外信息
     */
    private String  extra;

    /**
     * 外部订单号
     */
    private String outOrderId;

    /**
     * 外部配送单号
     */
    private String outDeliverNo;

    /**
     * 分布id，线下分布区域
     */
    private String orgId;

    private Date createdAt;

    private Date updatedAt;
    
    /**
     * 红包价
     */
    private Integer couponPrice;
    //使用店铺券金额
    private Integer shopCouponPrice;
    //使用平台券金额
    private Integer platCouponPrice;
    
    /***
     * 合单ID
     */
    private Long mergerId;
    
    /**
     * 是否需要发票
     */
    private Boolean hasInvoice;
    
    /**
     * 关联外部订单id
     */
    private String externalSiteOrderId;
    
    private Integer taxFee;//税费
    
    public Boolean hasPaid() {return hasPaid;}
    public Boolean hasComment() {return hasComment;}

    public enum CHANNEL {
        PC(0, "网页端"),         // 网页端
        MOBILE(1, "移动端"),     // 移动端，H5
        WECHAT(2, "微信端");     // 微信端

        public final int value;
        public final String desc;

        private CHANNEL(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }
    }
}
