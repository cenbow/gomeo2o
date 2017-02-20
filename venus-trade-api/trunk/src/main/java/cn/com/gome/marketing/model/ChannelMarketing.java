package cn.com.gome.marketing.model;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ChannelMarketing implements Serializable{
	private static final long serialVersionUID = 3679407764109812872L;
	
	Long id;
	Long couponChannel;             //优惠券渠道号
	String couponChannelName;         //优惠券渠道名称
	Long creatorId;                 //渠道创建人id
	Integer isUseable;              //渠道是否可用 1，可用；0，不可用
	Date createdAt;                 //创建时间
	Date updatedAt;                 //更新时间

}
