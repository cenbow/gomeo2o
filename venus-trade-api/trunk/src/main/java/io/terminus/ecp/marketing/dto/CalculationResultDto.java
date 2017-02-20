package io.terminus.ecp.marketing.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Desc: 活动计算结果
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
@Data
public class CalculationResultDto   implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6461956894836740786L;

	private Integer originalPrice;              //原始价格

    private Integer calculatedPrice;            //计算之后的价格

}
