/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.marketing.model.promo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc: 优惠码使用情况
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/17/15.
 */
@Data
public class PromoUsage implements Serializable {

    private static final long serialVersionUID = 5386913328568789820L;

    private Long id;                //自增主键

    private Long buyerId;           //使用优惠码的买家id

    private String buyerName;       //买家名称

    private Long promoCreator;      //优惠码创建人ID

    private Long shopId;            //店铺编号

    private String shopName;        //店铺名称（企业名称）

    private Integer discount;       //优惠金额

    private Long giftId;            //送礼商品Id

    private Integer discountPro;    //打折

    private Boolean shipFee;        //包邮

    private Long orderId;           //使用优惠码的订单id

    private Long promoDefId;        //对应优惠码定义id

    private Integer promoType;      //优惠码类型

    private String promoName;       //优惠码名称

    private String promoNum;        //优惠码（让买家使用）

    private Date createdAt;         //创建时间

    private Date updatedAt;         //更新时间

}
