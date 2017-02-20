package io.terminus.ecp.marketing.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Desc:规则的条件类型集合数据
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
public class RuleConditionData extends BaseRuleType {
    private static final long serialVersionUID = -1701694495994059517L;

    @Setter
    @Getter
    private String value;                   //保存规则的地址数据(id)|(定义的Json数据)

    @Setter
    @Getter
    private Serializable conditionData;     //规则数据对象
}
