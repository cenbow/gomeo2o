package io.terminus.ecp.marketing.dto;

import io.terminus.ecp.marketing.model.MarketingActivity;
import io.terminus.ecp.plugin.model.ToolRulesData;
import io.terminus.ecp.plugin.model.ToolRulesModule;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Desc:活动详细数据信息
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-10.
 */
@Data
@NoArgsConstructor
public class MarketingActivityDto implements Serializable {
    private static final long serialVersionUID = -1099501090727592660L;

    private MarketingActivity marketingActivity;//优惠活动信息

    private MarketingToolDto marketingToolDto;  //活动绑定的工具的具体数据信息

    private ToolRulesModule toolRulesModule; //绑定的规则

    private ToolRulesData toolRulesData; //绑定的数据

    public MarketingActivityDto(MarketingActivity marketingActivity, MarketingToolDto marketingToolDto){
        this.marketingActivity = marketingActivity;
        this.marketingToolDto = marketingToolDto;
    }
}
