package io.terminus.ecp.marketing.dto;

import io.terminus.ecp.marketing.model.MarketingActivity;
import io.terminus.ecp.marketing.model.MarketingActivityLog;
import lombok.Data;

import java.io.Serializable;

/**
 * Desc: 具体的优惠记录信息
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-13.
 */
@Data
public class ActivityLogDto implements Serializable {
    private static final long serialVersionUID = 7508611773307546292L;

    private MarketingActivity marketingActivity;            // 优惠活动信息

    private MarketingActivityLog marketingActivityLog;      // 优惠活动使用日式记录
}
