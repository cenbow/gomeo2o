package io.terminus.ecp.marketing.model.condition;

import lombok.Data;

import java.io.Serializable;

/**
 * Desc: 时间范围的数据
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/17/15.
 */
@Data
public class TimeRangeCondition implements Serializable {

    private static final long serialVersionUID = 5726542147495978511L;

    private Long id;

    private Integer scope;      //作用域（1：订单，2：商品）

    private String beginTime; //时间范围开始时间 00:21 这种格式

    private String endTime; //时间范围结束时间  00:23 这种格式
}
