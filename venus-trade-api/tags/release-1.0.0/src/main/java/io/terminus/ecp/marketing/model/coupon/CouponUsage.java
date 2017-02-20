/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.marketing.model.coupon;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:Guo Chaopeng
 * Created on 12/4/14.
 */
@Data
public class CouponUsage implements Serializable {

    private static final long serialVersionUID = 5386913328568789820L;

    //todo 现在只涉及平台&店铺的优惠券使用

    private Long id;                          //自增主键

    private Long buyerId;                       //使用券的买家id

    private String buyerName;                   //买家名称

    private Long sellerId;                      //券所属商家id

    private String shopName;                    //店铺名称（企业名称）

    private Integer discount;                   //优惠金额

    private Integer usedQuantity;              //券使用数量

    private Long orderId;                       //使用券的订单id

    private Long couponDefId;                  //对应券定义id

    private Integer couponType;                  //对应券类型

    private String couponName;                 //券名称

    private Date createdAt;                     //创建时间

    private Date updatedAt;                     //更新时间

}
