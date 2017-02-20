package io.terminus.ecp.marketing.dto;

import io.terminus.ecp.marketing.model.MarketingTool;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Desc:具体数据的集合信息(具体的优惠条件&方式数据)
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-11.
 */
@Data
public class ToolDataDto implements Serializable {
    private static final long serialVersionUID = -4370213843039724980L;

    public MarketingTool marketingTool;

    public List<Serializable> ruleDataList;
}
