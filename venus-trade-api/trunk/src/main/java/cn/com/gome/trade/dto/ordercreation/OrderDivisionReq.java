package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class OrderDivisionReq implements Serializable{

	private static final long serialVersionUID = 3377517201531449766L;
	private Long addressId;    //地址id
	private Long userId;       //userId
	private List<OrderPreview> orderPreviews = new ArrayList<OrderPreview>();  //订单预览行
	private List<CreationCoupon> coupons;//用户选择的优惠券列表
	private Integer gomeMoney;  //使用的国美币
	private String outerUserId; //外部用户id
	private String streetId;    //所在街道ID:四级地址
	private String regionId;    //区编码:三级地址

}
