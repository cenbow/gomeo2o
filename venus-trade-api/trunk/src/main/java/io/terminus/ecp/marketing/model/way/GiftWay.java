package io.terminus.ecp.marketing.model.way;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:赠品优惠方式
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
@Data
public class GiftWay implements Serializable {
    private static final long serialVersionUID = -3420804264200812352L;

    //todo 其它必要场景字段之后在添加
    private Long id;

    private Long itemId;        //赠品编号(赠品必须包邮)

    private Integer scope;      //作用域（1：订单，2：商品）

    private String itemName;    //赠品名称

    private Long sellerId;      //赠品创建人

    private Integer number;     //赠送几件

    private Date createdAt;     //创建时间

    private Date updatedAt;     //结束时间
}
