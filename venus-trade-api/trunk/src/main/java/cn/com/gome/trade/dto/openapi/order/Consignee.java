package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;

import lombok.Data;

@Data
public class Consignee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3670848119228203498L;

	private String name; // 姓名
	private String mobile; // 手机号
	private String phone; // 固话
	private String address; // 详细地址
}
