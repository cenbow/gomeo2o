/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: libin-ds9
 * @date: 2015年5月27日 下午2:25:46
 */
package cn.com.gome.trade.service;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;

import java.util.List;

import cn.com.gome.trade.dto.io.returnreq.response.FindReturnOrderStatusHistorieDto;
import cn.com.gome.trade.dto.io.state.response.FindOrderStatusHistorieDto;

/**
 * @Description: 订单、配送单履历调度处理
 * 
 * @author: libin-ds9
 * @date: 2015年5月27日 下午2:25:46
 */
public interface GomeOrderRecordsService {

	/**
	 * @Description: 正向订单履历处理
	 * @author: libin-ds9
	 * @date: 2015年6月4日 下午5:12:33
	 * @param statusList
	 * @param order
	 */
	public void order(List<FindOrderStatusHistorieDto> statusList, Order order);

	/**
	 * @Description: 逆向订单换货处理
	 * @author: libin-ds9
	 * @date: 2015年6月4日 下午5:12:51
	 * @param details
	 * @param orderItemRefundTrack
	 */
	public void reverseOrderByExchange(
			List<FindReturnOrderStatusHistorieDto> details,
			OrderItemRefundTrack orderItemRefundTrack);

	/**
	 * @Description: 逆向订单退货处理
	 * @author: libin-ds9
	 * @date: 2015年6月4日 下午5:13:08
	 * @param details
	 * @param orderItemRefundTrack
	 */
	public void reverseOrderByReturn(
			List<FindReturnOrderStatusHistorieDto> details,
			OrderItemRefundTrack orderItemRefundTrack);

}
