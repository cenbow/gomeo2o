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
public class Coupon implements Serializable {

    private static final long serialVersionUID = -8228170790674353733L;

    private Long id;                          //自增主键

    private Long userId;                       //券所属用户id

    private String userName;                   //用户名称（领券人）

    private Integer remainQuantity;            //券剩余数量

    private Integer usedQuantity;              //券使用数量

    private Integer type;                      //优惠券类型(1:商家优惠券， 2:平台优惠券)

    private Long creatorId;                    //优惠券创建人

    private Long itemId;                       //适用商品id，只有当对应券定义为商品砍价券时才有值

    private String picture;                    //优惠券图片

    private Long shopId;                        //店铺id

    private String shopName;                   //店铺名称

    private Long couponDefId;                  //对应券定义id

    private String couponName;                 //券名称

    private Integer discount;                  //优惠券面值

    private Integer baseMoney;                 //起用价格（订单满多少元可用）

    private Integer baseQuantity;              //起用数量（订单满多少件可用）

    private Integer mostUseQuantity;           //每个订单最多使用数量

    private Integer perMoney;                  //每满多少金额可以使用

    private Date startAt;                      //券生效时间

    private Date endAt;                        //券失效时间

    private Date createdAt;                     //创建时间

    private Date updatedAt;                     //更新时间

}
