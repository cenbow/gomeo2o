package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class Buyer   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8364390075619793888L;
	private Integer vipId;//国美电器会员ID
	private String vipCode;//国美电器会员卡号
	private String name;//买家姓名
	private String mobile;//买家手机号
	private String mail;//买家邮箱

}
