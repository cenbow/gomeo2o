package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrdersQueryParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2573192082536040216L;

	private Integer status; // 订单状态（待付款:1，待出库:2，已出库:3，已完成:4，已关闭:5）
	private Long start; // 开始时间（当前查询状态的状态变更时间为准）
	private Long end; // 结束时间（当前查询状态的状态变更时间为准）
	private Integer pageNum; // 分页页数
	private Integer pageSize;// 分页大小
}
