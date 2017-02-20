package io.terminus.ecp.marketing.dto;

import io.terminus.ecp.marketing.model.MarketingToolData;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Desc:规则数据结构体
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-11.
 */
@Data
public class RuleDataDto implements Serializable {
    private static final long serialVersionUID = 4651872490899440333L;

    private MarketingToolData marketingToolData;        //工具的数据定义信息

    private List<RuleConditionData> conditionDataList;  //条件对应的方式数据

    private List<RuleWayData> wayDataList;              //规则对应的方式数据
}
