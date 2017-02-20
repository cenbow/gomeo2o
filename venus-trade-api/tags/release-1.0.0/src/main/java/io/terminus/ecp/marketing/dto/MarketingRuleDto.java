package io.terminus.ecp.marketing.dto;

import io.terminus.ecp.marketing.model.MarketingRule;
import lombok.Getter;
import lombok.Setter;

/**
 * Desc:优惠的规则数据结构
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-10.
 */
public class MarketingRuleDto extends MarketingRule {
    private static final long serialVersionUID = 9043849644470189801L;

    @Getter
    @Setter
    private RuleConditionData ruleConditionData;    //条件数据

    @Getter
    @Setter
    private RuleWayData ruleWayData;                //方式数据
}
