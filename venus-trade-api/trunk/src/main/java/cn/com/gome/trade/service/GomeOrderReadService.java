package cn.com.gome.trade.service;

import cn.com.gome.trade.dto.orderdelivery.OrderDelivery;
import cn.com.gome.trade.dto.orderdelivery.OrderDeliveryDetail;
import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.dto.OrderItemWithCommentDto;
import io.terminus.ecp.trade.dto.SellerCommentDto;
import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.service.OrderReadService;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.InnerCookie;
import io.terminus.pampas.common.Response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.gomeo2o.common.entity.CommonResultEntity;

import cn.com.gome.trade.dto.CartItemAndWeixinInfo;
import cn.com.gome.trade.dto.GomePreOrder;
import cn.com.gome.trade.dto.WeidianOrderCustomerDto;
import cn.com.gome.trade.dto.WeidianOrderDetail;
import cn.com.gome.trade.dto.io.rebate.request.VshopOrderAmountRequestDto;
import cn.com.gome.trade.dto.io.rebate.request.VshopOrderCountsRequestDto;
import cn.com.gome.trade.dto.io.rebate.response.VshopOrderAmountResponseDto;
import cn.com.gome.trade.dto.io.rebate.response.VshopOrderCountsResponseDto;
import cn.com.gome.trade.dto.o2m.OrdersAndSubOrders;
import cn.com.gome.trade.dto.ordercreation.OrderDivisionReq;
import cn.com.gome.trade.dto.ordercreation.OrderDivisionResp;

/**
 * Created by yangzefeng on 15/4/23
 */
public interface GomeOrderReadService extends OrderReadService {

    /**
     * 查询当前登录用户的永久购物车
     * @param baseUser 当前登录用户
     * @return 购物车信息
     */
    @Export(paramNames = {"baseUser", "adderssId"})
    Response<List<CartItemAndWeixinInfo>> getPermanentWithWeixinInfo(BaseUser baseUser, Integer adderssId);

    /**
     * 查询当前登录用户的永久购物车的sku的种类
     * @param baseUser 当前登录用户
     */
    @Override
    @Export(paramNames = {"baseUser"})
    Response<Integer> getPermanentCount(BaseUser baseUser);

    /**
     * 订单预览页
     * @param skus skuId和对应的sku数量
     * @param wechatInfos 微店信息
     * @param addressSelect 是否选择了地址
     * @return 订单预览页信息
     */
    @Export(paramNames = {"skus", "wechatInfos", "addressSelect", "loginer", "cookie"})
    Response<List<GomePreOrder>> gomePreViewOrder(@NotNull(message = "skus.invalid") String skus,
                                              String wechatInfos,
                                          Boolean addressSelect,
                                          @NotNull(message = "user.not.login") BaseUser loginer,
                                          @NotNull(message = "cookie.invalid") InnerCookie cookie);

    /**
     * 获取拆单后的订单数量
     * @param skuIdAndQuantity skuId和购买数量
     * @param addressId 配送地址id
     * @param loginer 当前登录用户id
     * @return 拆单后的订单数量
     */
    Response<Integer> getGomeOrderNum(Map<Long, Integer> skuIdAndQuantity, Integer addressId, BaseUser loginer);

    /**
     * 判断是否可以提醒发货
     * @param orderId 订单id
     * @return 判断结果
     */
    Response<Boolean> remindPayKeyExist(Long orderId);

    /**
     * 微店商家的订单列表
     * @param referenceId 微店id
     * @param pageNo 页码
     * @param size 每页大小
     * @return 微店商家子订单列表
     */
    Response<Paging<OrderItem>> weidianOrders(String referenceId, String status, String hasComment, Integer pageNo, Integer size,Map<String, Serializable> map);

    /**
     * 返回订单商品行及商品评价
     * @param buyerId
     * @param pageNo
     * @param size
     * @return
     */
    Response<Paging<OrderItemWithCommentDto>> paidOrderItemWithComment(Long buyerId,Integer pageNo, Integer size);
    
    Response<WeidianOrderDetail> getWeidianOrderDetail(Long orderItemId);

    /**
     * 微店商品评价列表
     * @param pageNo 页码
     * @param size 每页大小
     * @param loginUser 当前登录用户
     */
    Response<Paging<SellerCommentDto>> weidianPagingOrderItem(Integer pageNo, Integer size, Long referenceId);

    /**
     * 微店客户管理列表
     * @param pageNo 页码
     * @param size 每页大小
     * @param referenceId 微店id
     */
    Response<Paging<WeidianOrderCustomerDto>> weidianPagingCustomer(Integer pageNo, Integer size, Long referenceId);

    /**
     * 查询订单记录信息
     * @param referenceId  微店id
     * @param buyerId   买家id
     * @param status    订单状态
     * @param pageNo    当前页
     * @param size      每页显示条数
     * @return  Paging
     * 返回分页数据
     */
    Response<Paging<OrderItem>> queryBuyerOrderByReferenceId(Long referenceId, Long buyerId, Integer status, Integer pageNo, Integer size);

    /**
     * 根据外部订单id查询order
     * @param outOrderIdList
     * @return
     */
    Response<Order> queryOrderByOutOrderId(Long outOrderId);
    
    
    /**
     * 根据外部订单id查询OrdersAndSubOrders
     * @param outMergerOrderIdList
     * @return
     */
    Response<OrdersAndSubOrders> queryMergerOrderByOutOrderId(List<Long> outMergerOrderIdList,List<Long> outSubOrderIdList);

    /**
     * 
     * @Description 订单预览页 
     * @author miaomiao
     * @date 2016年5月5日 下午7:41:33
     * @param orderDivisionReq
     * @return 
     */
    Response<OrderDivisionResp> previewOrder(OrderDivisionReq orderDivisionReq);
    
    /**
     * 根据子订单id和美店店铺id查找订单
     * @param orderItemId 子订单id
     * @param mshopId 美店店铺id
     * @return 子订单对象
     */
    Response<OrderItem> findOrderItemByIdAndMshopId(@Min(value = 1L, message = "order.item.id.invalid")
                                          @NotNull(message = "order.item.id.invalid")Long orderItemId,
                                          @NotNull(message = "mshopId.invalid")Long mshopId);

    /**
     * 根据总单Id与用户Id确认该总单是为已支付状态
     * @param mergerId
     * @param userId
     * @param extMap
     * @return
     */
    CommonResultEntity<Boolean> checkMergerOrderHasPaid(Long mergerId,Long userId,Map<String,Object> extMap);
    /**
     * 根据合单Id获取团购id
     * @param outOrderId
     * @return
     */
    Response<String> findGroupBuyIdByMergerId(Long mergerId);
    /**
     * 查看美店订单数量和商品数量
     * @param vshopOrderCountsDto
     * @return
     */
    Response<VshopOrderCountsResponseDto> getVshopOrderCounts(VshopOrderCountsRequestDto vshopOrderCountsRequestDto);
    /**
     * 查看美店订单数量和订单金额
     * @param vshopOrderCountsDto
     * @return
     */
    Response<VshopOrderAmountResponseDto> getVshopOrderAmount(VshopOrderAmountRequestDto vshopOrderAmountRequestDto);
    /**
     * 根据skuid和orderId查询订单商品行信息
     * @param vshopOrderCountsDto
     * @return
     */
    Response<List<Map<String, Object>>> getOrderItemByOrderIdAndSkuId(List<Map<String, Object>> params);

    /**
     * 查询配送单
     * @param map
     * @return
     */
    public Response<List<OrderDelivery>> getOrderDeliverys(Map<String, Object> map);

    /**
     * 查询配送单
     * @param map
     * @return
     */
    public Response<List<OrderDeliveryDetail>> getOrderDeliveryDetails(Map<String, Object> map);
}
