package io.terminus.ecp.marketing.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Desc: 计算结果
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
@Data
public class MarketingResultDto implements Serializable {
    private static final long serialVersionUID = 2596130419552299421L;

    private CalculationResultDto calculationResultDto;

    private MarketingActivityDto marketingActivityDto;
}
