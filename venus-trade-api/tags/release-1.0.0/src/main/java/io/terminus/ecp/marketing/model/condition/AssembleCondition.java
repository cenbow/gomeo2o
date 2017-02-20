package io.terminus.ecp.marketing.model.condition;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:组合套餐的条件
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
@ToString
public class AssembleCondition implements Serializable {
    private static final long serialVersionUID = 8703621975571041222L;

    //todo 这个也是之后在考虑（保存字符串对于套餐的判断太麻烦！设计考虑应该将组合套餐看成一个特定的spu）
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String itemIds; //符合组合套餐全部商品

    @Setter
    @Getter
    private Date createdAt; //创建时间

    @Setter
    @Getter
    private Date updatedAt; //结束时间
}
