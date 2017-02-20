package cn.com.gome.trade.dto.io.cancel.request;

import java.io.Serializable;

import lombok.Data;

/**
 * @Description: 取消订单请求json dto
 * @author: liutaiming
 * @date: 2015年5月8日 下午7:41:16
 */
@Data
public class OrderCancelRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId; // 订单ID 可空N

	private String profileId; // 用户ID 可空N

	private String reasonCode = "occ1"; // 订单取消原因 可空Y occ1-occ10 默认occ1

}
