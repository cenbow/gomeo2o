package io.terminus.ecp.marketing.model.coupon;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import cn.com.gome.trade.dto.shopdto.Shop;

/**
 * Desc:店铺的优惠券信息
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-27.
 */
@Data
public class ShopCoupon implements Serializable {
    private static final long serialVersionUID = 4213055401914882207L;

    private Shop shop;                                  //店铺信息

    private List<CouponDefinition> couponDefinitions;   //店铺优惠券信息
}
