package cn.com.gome.marketing.model.condition;

import lombok.Data;

import java.io.Serializable;

/**
 * Desc:直降条件
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-29.
 */
@Data
public class TimeDownCondition implements Serializable {
    private static final long serialVersionUID = 8703621975571041222L;

    private Long id;

    private Long itemId;    //商品编号(用于一个条件对应一个直降商品)

    private String itemName;  //商品名称

    private Integer scope;  //作用域（1：订单，2：商品）
}
