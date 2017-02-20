package cn.com.gome.marketing.model.way;

import lombok.Data;

import java.io.Serializable;

/**
 * Desc: 国美直降优惠方式
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-28.
 */
@Data
public class TimeDownWay implements Serializable{
    private static final long serialVersionUID = -1360352295325312685L;

    private Integer price;          //原价

    private Integer downPrice;      //直降价格

    private Integer scope;          //作用域（1：订单，2：商品）
}
