package io.terminus.ecp.marketing.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Desc:规则的方式类型集合数据
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
public class RuleWayData extends BaseRuleType {
    private static final long serialVersionUID = -3514969823782049594L;

    @Setter
    @Getter
    private String value;   //保存数据(id|json数据对象)

    @Setter
    @Getter
    private Serializable wayData; //方式数据对象
}
