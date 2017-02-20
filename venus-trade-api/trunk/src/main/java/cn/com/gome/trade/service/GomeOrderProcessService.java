/**
 * @类名: OrderProcessFacade.java
 * @描述: 
 * @作者 libin-ds9
 * @创建时间 2015年5月7日 下午5:22:38
 */
package cn.com.gome.trade.service;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.com.gome.trade.dto.io.cancel.request.OrderCancelRequestDto;
import cn.com.gome.trade.dto.io.cancel.response.OrderCancelResponse;
import cn.com.gome.trade.dto.io.pay.response.OrderPayResponseDto;
import cn.com.gome.trade.dto.io.product.request.AreaProductAvailableRequestDto;
import cn.com.gome.trade.dto.io.product.response.AreaProductAvailableResponseDto;
import cn.com.gome.trade.dto.io.returnreq.request.SubmitReturnOrderRequestDto;
import cn.com.gome.trade.dto.io.returnreq.response.FindReturnHistoriesResponseDto;
import cn.com.gome.trade.dto.io.returnreq.response.ReturnRequestFacetResponseDto;
import cn.com.gome.trade.dto.io.returnreq.response.SubmitReturnOrderResponseDto;
import cn.com.gome.trade.dto.io.save.request.OrderSaveRequestDto;
import cn.com.gome.trade.dto.io.save.response.OrderSaveResponseDto;
import cn.com.gome.trade.dto.io.shipping.request.CancelOrderShippingGroupRequestDto;
import cn.com.gome.trade.dto.io.shipping.request.OrderShippingHistoriesRequestDto;
import cn.com.gome.trade.dto.io.shipping.response.CancelOrderShippingGroupResponseDto;
import cn.com.gome.trade.dto.io.shipping.response.OrderShippingHistoriesResponseDto;
import cn.com.gome.trade.dto.io.split.request.OrderSplitRequestDto;
import cn.com.gome.trade.dto.io.split.response.OrderSplitResponseDto;
import cn.com.gome.trade.dto.io.state.request.UpdateOrderStateToNoPendingActionResponseDto;
import cn.com.gome.trade.dto.io.state.response.FindOrderStateByIdResponseDto;
import cn.com.gome.trade.dto.io.state.response.FindOrderStatusHistoryByIdResponseDto;
import cn.com.gome.trade.dto.io.thirdparty.request.VerifyReturnRequestDto;
import cn.com.gome.trade.dto.io.thirdparty.response.VerifyReturnResponseDto;
import cn.com.gome.trade.dto.itemdto.Sku;
import cn.com.gome.trade.enums.GomeOrderInfoEnum;

/**
 * @描述: 订单服务
 * @作者 libin-ds9
 * @创建时间 2015年5月7日 下午5:29:28
 */

@Service("gomeOrderProcessService")
public interface GomeOrderProcessService {

	/**
	 * @描述:创建订单
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午10:30:42
	 * @param orderDto
	 */
	public OrderSaveResponseDto createOrder(OrderSaveRequestDto orderDto);

	/**
	 * @Description: 创建订单 端点调用接口
	 * @author: libin-ds9
	 * @date: 2015年5月20日 下午8:36:50
	 * @param order
	 * @param orderExtra
	 * @param orderitems
	 * @return
	 */
	public OrderSaveResponseDto createOrder(Order order, OrderExtra orderExtra,
			List<OrderItem> orderitems);

	/**
	 * @描述:根据订单id查询订单信息
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午10:30:52
	 * @param id
	 * @return
	 */
	@Deprecated
	public String findOrderById(String id);

	/**
	 * @描述:查询SKU信息
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午10:30:52
	 * @param id
	 * @return
	 */
	@Deprecated
	public String findSkuById(String id);

	/**
	 * @描述:订单支付
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午10:30:01
	 * @param t
	 * @param e
	 * @return
	 */
	public <T> OrderPayResponseDto orderPay(T t, GomeOrderInfoEnum e);

	/**
	 * @描述:订单支付通知国美 端点调用
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午10:30:01
	 * @param t
	 * @param e
	 * @return
	 */
	public OrderPayResponseDto orderPay(Order order);

	/**
	 * @描述:订单取消
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午11:08:33
	 * @param orderCancelRequestDto
	 * @return
	 */
	public OrderCancelResponse cancelOrder(
			OrderCancelRequestDto orderCancelRequestDto);

	/**
	 * @描述:订单取消 端点调用
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午11:08:33
	 * @param orderCancelRequestDto
	 * @return
	 */
	public OrderCancelResponse cancelOrder(Order order);

	/**
	 * @描述:拆单
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 上午11:31:24
	 * @param orderSplitRequestDto
	 * @return
	 */
	public OrderSplitResponseDto splitOrder(
			OrderSplitRequestDto orderSplitRequestDto);

	/**
	 * @描述:通过配送单号查询配送单履历
	 * @作者 libin-ds9
	 * @创建时间 2015年5月9日 下午3:30:32
	 * @param orderShippingHistoriesRequestDto
	 * @return
	 */
	@Deprecated
	public OrderShippingHistoriesResponseDto findShippingHistories(
			OrderShippingHistoriesRequestDto orderShippingHistoriesRequestDto);

	/**
	 * @描述:取消配送单
	 * @作者 libin-ds9
	 * @创建时间 2015年5月11日 上午10:26:37
	 * @param cancelOrderShippingGroupRequestDto
	 * @return
	 */
	@Deprecated
	public CancelOrderShippingGroupResponseDto cancelShippingGroup(
			CancelOrderShippingGroupRequestDto cancelOrderShippingGroupRequestDto);

	/**
	 * @描述:第三方订单商品是否可退
	 * @作者 libin-ds9
	 * @创建时间 2015年5月11日 上午10:33:14
	 * @param verifyReturnRequestDto
	 * @return
	 */
	public VerifyReturnResponseDto verifyReturn(
			VerifyReturnRequestDto verifyReturnRequestDto);

	/**
	 * @Description: 第三方订单商品是否可退 端点调用接口
	 * @author: libin-ds9
	 * @date: 2015年5月29日 下午4:52:20
	 * @param OrderItem
	 *            子订单
	 * @param type
	 *            TrackType类型 售后换货、售后退货
	 * @return
	 */
	public VerifyReturnResponseDto verifyReturn(OrderItem orderItem,
			Integer type);

	/**
	 * @描述:逆向订单提交
	 * @作者 libin-ds9
	 * @创建时间 2015年5月11日 上午11:08:32
	 * @param submitReturnOrderRequestDto
	 * @return
	 */
	public SubmitReturnOrderResponseDto submitReturnOrder(
			SubmitReturnOrderRequestDto submitReturnOrderRequestDto);

	/**
	 * @Description: 逆向订单提交 端点调用接口
	 * @author: libin-ds9
	 * @date: 2015年6月2日 上午9:53:19
	 * @return
	 */
	public SubmitReturnOrderResponseDto submitReturnOrder(
			OrderItemRefundTrack oirt);

	/**
	 * @描述:
	 * @作者 libin-ds9
	 * @创建时间 2015年5月13日 下午5:29:34
	 * @param orderId
	 */
	public FindOrderStateByIdResponseDto findOrderStateById(String orderId);

	/**
	 * @描述:通过订单ID查询订单履历
	 * @作者 libin-ds9
	 * @创建时间 2015年5月13日 下午12:15:36
	 */
	public FindOrderStatusHistoryByIdResponseDto findOrderStatusHistoryById(
			String orderId);

	/**
	 * @return
	 * @描述:区域商品可卖数数量查询 56
	 * @作者 libin-ds9
	 * @创建时间 2015年5月13日 下午1:34:13
	 */
	public AreaProductAvailableResponseDto findAreaProductAvailable(
			AreaProductAvailableRequestDto areaProductAvailableRequestDto);
	
	
	/**
	 * @Description: 区域商品可卖数数量查询 端点调用 
	 * @author: liutaiming
	 * @date: 2015年6月15日 上午11:04:17
	 * @param addressId  配送地址
	 * @param skuId 商品编码
	 * @param qty 数量
	 * @return
	 */
	public AreaProductAvailableResponseDto findAreaProductAvailable(Integer addressId, 
			Sku sku, Integer qty);

	/**
	 * @描述:查询逆向订单履历
	 * @作者 libin-ds9
	 * @创建时间 2015年5月14日 下午3:27:06
	 * @param returnOrderId
	 * @return
	 */
	public FindReturnHistoriesResponseDto findReturnHistories(
			String returnOrderId);

	/**
	 * @Description: 修改订单状态为妥投
	 * @author: libin-ds9
	 * @date: 2015年5月22日 下午3:16:27
	 * @param orderId
	 * @return
	 */
	public UpdateOrderStateToNoPendingActionResponseDto updateOrderStateToNoPendingAction(
			String orderId);

	
	/**
	 * @Description: 退款审核 
	 * @author: liutaiming
	 * @date: 2015年6月11日 上午11:44:59
	 * @param id 外部配送单号 或 退货单id
     * @param type shippingGroupId:外部配送单号     returnRequestId:退货单id
	 * @return
	 */
	public ReturnRequestFacetResponseDto findRefundState(String id,String type);
	
	/**
	 * @Description: io获取sku信息 
	 * @author: liutaiming
	 * @date: 2015年6月23日 上午11:26:03
	 * @param skuId
	 * @return
	 */
	public String getSkuById(String skuId);
}
