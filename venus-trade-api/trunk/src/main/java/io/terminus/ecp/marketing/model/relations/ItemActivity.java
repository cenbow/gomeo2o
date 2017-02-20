package io.terminus.ecp.marketing.model.relations;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:商品与活动的关联关系(商品反向关联活动)
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-29.
 */
@Data
public class ItemActivity implements Serializable {
    private static final long serialVersionUID = -312146477721125662L;

    private Long id;            //主键

    private Long itemId;        //商品编号

    private String itemName;    //商品名称

    private String mainImage;   //商品主图

    private Integer price;      //售价

    private Integer discount;   //优惠金额

    private Long sellerId;      //商家ID

    private Long shopId;        //店铺ID

    private String shopName;    //店铺名称

    private Long brandId;       //品牌ID

    private String brandName;   //品牌名称

    private Long activityId;    //活动编号

    private String activityName;//优惠活动名称

    private Integer status;     //活动状态（as MarketingActivity.Status）

    private Date createdAt;     //创建时间

    private Date updatedAt;     //结束时间
}
