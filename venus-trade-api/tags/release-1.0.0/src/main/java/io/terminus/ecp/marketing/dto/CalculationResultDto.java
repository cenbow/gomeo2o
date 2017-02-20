package io.terminus.ecp.marketing.dto;

import lombok.Data;

/**
 * Desc: 活动计算结果
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
@Data
public class CalculationResultDto {

    private Integer originalPrice;              //原始价格

    private Integer calculatedPrice;            //计算之后的价格

}
