package cn.com.gome.trade.service.openapi;

import cn.com.gome.trade.dto.common.PageParam;
import cn.com.gome.trade.dto.openapi.aftersalesorder.AfterSalesOrdersReq;
import cn.com.gome.trade.dto.openapi.aftersalesorder.AfterSalesOrdersResp;
import cn.com.gome.trade.dto.openapi.common.CommonBase;
import cn.com.gome.trade.dto.openapi.logisticsvendor.LogisticsVendorsReq;
import cn.com.gome.trade.dto.openapi.logisticsvendor.LogisticsVendorsResp;
import cn.com.gome.trade.dto.openapi.order.Order;
import cn.com.gome.trade.dto.openapi.order.OrdersQueryParam;
import cn.com.gome.trade.dto.openapi.order.OrdersResponse;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

public interface GomeOpenApiOrderReadService {
	
	/**
	 * 
	 * @Description 开放平台接口查询订单列表 
	 * @author wangjiatian
	 * @date 2016年10月18日 下午5:53:58
	 * @param ordersQueryParam
	 * @param baseUser
	 * @return
	 */
	public Response<OrdersResponse> getOrders(OrdersQueryParam ordersQueryParam,BaseUser baseUser);

	/**
	 * 
	 * @Description 开放平台接口查询订单详情 
	 * @author wangjiatian
	 * @date 2016年10月20日 下午1:54:56
	 * @param orderId
	 * @param baseUser
	 * @return
	 */
	public Response<Order> getOrderDetail(Long orderId,BaseUser baseUser);
	
	/**
	 * 开放平台接口查询售后单详情 
	 * @param afterSalesOrdersReq
	 * @author songrongbin
	 * @return
	 */
	Response<AfterSalesOrdersResp> getAfterSalesOrders(AfterSalesOrdersReq afterSalesOrdersReq);
	
	/**
	 * 开放平台接口查询物流列表
	 * @param base
	 * @param logisticsVendorsReq
	 * @param pageParam
	 * @author songrongbin
	 * @return
	 */
	Response<LogisticsVendorsResp> getLogisticsVendors(CommonBase base, LogisticsVendorsReq logisticsVendorsReq, PageParam pageParam);
}
