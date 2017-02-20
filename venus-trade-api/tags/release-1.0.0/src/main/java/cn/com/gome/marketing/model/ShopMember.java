package cn.com.gome.marketing.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:店铺的会员(国美优惠券发放对象)
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-18.
 */
@Data
public class ShopMember implements Serializable {
    private static final long serialVersionUID = 1815132115867739277L;

    private Long id;

    private Long userId;            //用户编号

    private String userName;        //用户名称

    private Long sellerId;          //卖家编号

    private String sellerName;      //卖家名称

    private Integer orderAccount;   //订单数量

    private Long priceAccount;      //订单总额

    private Long getCouAccount;     //获取的优惠券总额

    private Long useCouAccount;     //使用的优惠券总额

    private Date createdAt;         //创建时间

    private Date updatedAt;         //更新时间
}
