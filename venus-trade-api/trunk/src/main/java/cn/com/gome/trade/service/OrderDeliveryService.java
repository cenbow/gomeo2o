package cn.com.gome.trade.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.terminus.ecp.trade.model.ExpressInfo;
import io.terminus.ecp.trade.model.Order;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;
import cn.com.gome.trade.dto.comment.OrderItemCanCommented;
import cn.com.gome.trade.dto.openapi.common.CommonBase;
import cn.com.gome.trade.dto.openapi.deliverylogistics.DeliveryLogisticsReq;
import cn.com.gome.trade.dto.openapi.deliverylogistics.DeliveryLogisticsResp;
import cn.com.gome.trade.dto.openapi.orderdelivery.DeliveryBill;
import cn.com.gome.trade.dto.openapi.orderdelivery.OrderDeliveryReq;
import cn.com.gome.trade.dto.openapi.orderdelivery.OrderDeliveryResp;
import cn.com.gome.trade.dto.orderdelivery.OrderDelivery;
import cn.com.gome.trade.dto.orderdelivery.OrderDeliveryDetail;

public interface OrderDeliveryService {
	
	Response<OrderDeliveryResp> createOrderDelivery(CommonBase base, OrderDeliveryReq orderDeliveryReq);
	
	Response<DeliveryLogisticsResp> createDeliveryLogistics(CommonBase base, DeliveryLogisticsReq deliveryLogisticsReq);

	List<DeliveryBill> getOrderDeliveryBills(Long orderId);
	
	/**
	 * 根据配送单id查询配送单信息
	 * @param id
	 * @return
	 */
	public Response<OrderDelivery> findOrderDeliveryById(Long id);

	/**
	 * 创建配送单信息
	 * @param order
	 * @param expressInfo
	 * @param waybillNo
	 */
	void createOrderDelivery(Order order, ExpressInfo expressInfo, String waybillNo);
	
	/*******************************
     * @method: 根据orderId 更新配送单状态
     * @param : orderDelivery 更新操作参数
     * @return 影响行数
     *******************************/
    @Export(paramNames = {"orderDelivery"})
    public Response<Boolean> updateByOrderId(@NotNull(message = "param.null.error") OrderDelivery orderDelivery);
    
    /**
	 * 根据订单id查询配送单列表
	 * @param id
	 * @return
	 */
	public Response<List<OrderDelivery>> findDeliveryByOrderId(Long orderId);
	
	/**
	 * 根据订单id查询配送单列表
	 * @param id
	 * @return
	 */
	public Response<List<OrderDeliveryDetail>> findDeliveryDetailByDeliveryId(Long orderDeliveryId);
	
	/**
	 * 获取订单商品行是否可以评价
	 * @param order
	 * @return
	 */
	public Response<List<OrderItemCanCommented>> getOrderItemsIsCommented(Order order);

}
