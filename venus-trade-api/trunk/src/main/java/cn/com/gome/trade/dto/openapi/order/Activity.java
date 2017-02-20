package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;

import lombok.Data;

@Data
public class Activity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6882892906419871343L;
	
	private Integer type;       //活动类型 1：团购类型
	private String id;                 //活动说明 活动id 团购中代表团购id

}
