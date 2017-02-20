package io.terminus.ecp.marketing.dto;

import io.terminus.ecp.marketing.model.MarketingTool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Desc:工具&工具的数据JSON
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-11.
 */
@NoArgsConstructor
@AllArgsConstructor
public class MarketingToolDto extends MarketingTool {
    private static final long serialVersionUID = 6658504380811325674L;

    @Setter
    @Getter
    private String ruleDataJson;    //规则数据模型(规则数据｜规则模版)

    public MarketingToolDto(MarketingTool marketingTool, String ruleDataJson){
        this.setId(marketingTool.getId());
        this.setName(marketingTool.getName());
        this.setCategory(marketingTool.getCategory());
        this.setScope(marketingTool.getScope());
        this.setPriority(marketingTool.getPriority());
        this.setIsExclusive(marketingTool.getIsExclusive());
        this.setStatus(marketingTool.getStatus());
        this.setDesc(marketingTool.getDesc());
        this.setCreateBy(marketingTool.getCreateBy());
        this.setUpdateBy(marketingTool.getUpdateBy());
        this.setCreateAt(marketingTool.getCreateAt());
        this.setUpdateAt(marketingTool.getUpdateAt());

        this.ruleDataJson = ruleDataJson;
    }
}
