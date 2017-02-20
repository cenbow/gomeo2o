/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.dto.OrderCommentDto;
import io.terminus.ecp.trade.dto.OrderDetail;
import io.terminus.ecp.trade.dto.OrderInvoice;
import io.terminus.ecp.trade.dto.OrderSnapshot;
import io.terminus.ecp.trade.dto.PreOrder;
import io.terminus.ecp.trade.dto.PrePay;
import io.terminus.ecp.trade.dto.RichOrderBuyerView;
import io.terminus.ecp.trade.dto.RichOrderSellerView;
import io.terminus.ecp.trade.dto.RichRefundInfo;
import io.terminus.ecp.trade.dto.SellerCommentDto;
import io.terminus.ecp.trade.dto.UserCart;
import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderComment;
import io.terminus.ecp.trade.model.OrderDiscountDetail;
import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;
import io.terminus.ecp.trade.model.OrderTrack;
import io.terminus.ecp.trade.model.statistics.OrderStatistics;
import io.terminus.ecp.user.dto.LoginSeller;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.InnerCookie;
import io.terminus.pampas.common.Response;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by yangzefeng on 14-9-10
 */
public interface OrderReadService {

    /********************  订单查询 ******************************/

    /**
     * 根据id查找订单
     * @param id 订单id
     * @return 订单对象
     */
    Response<Order> findOrderById(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid") Long id);

    /**
     * 根据子订单id查找订单
     * @param orderItemId 子订单id
     * @return 子订单对象
     */
    Response<OrderItem> findOrderItemById(@Min(value = 1L, message = "order.item.id.invalid")
                                          @NotNull(message = "order.item.id.invalid")Long orderItemId);


    /**
     * 根据订单id查找订单列表
     * @param orderIds  订单id列表
     * @return  订单列表
     */
    Response<List<Order>> findOrderByIds(
            @Valid
            @NotEmpty(message = "order.id.invalid")
            List<Long> orderIds);



    /**
     * 根据订单id查找订单详情
     * @param orderId 订单id
     * @return 订单详情
     */
    @Export(paramNames = {"orderId"})
    Response<OrderDetail> findOrderDetailByOrderId(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")Long orderId);

    /**
     * 根据订单id查找订单详情
     * @param orderId 订单id
     * @param loginUser 当前登录用户id
     * @return 订单详情
     */
    Response<OrderDetail> findAuthOrderDetailByOrderId(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")Long orderId,
            @NotNull(message = "user.not.login") BaseUser loginUser
    );

    /**
     * 运营订单列表
     * @param status 订单状态
     * @param orderId 订单id
     * @param nickName 买家名称
     * @param mobile 手机号码
     * @param email email地址
     * @param shopName 店铺名称
     * @param pageNo 页码
     * @param size 每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return 订单分页信息
     */
    @Export(paramNames = {"status", "orderId", "nickName", "mobile", "email", "shopName", "pageNo", "size", "startAt", "endAt"})
    Response<Paging<RichOrderSellerView>> adminPaging(Integer status, Long orderId, String nickName, String mobile,
                                                      String email, String shopName,
                                                      Integer pageNo, Integer size, String startAt, String endAt);

    /**
     * 买家订单列表
     * @param loginer 当前登录买家id
     * @param status 订单状态
     * @param orderId 订单id
     * @param pageNo 页码
     * @param size 每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return 订单分页信息
     */
    @Export(paramNames = {"loginer", "status", "orderId", "pageNo", "size", "startAt", "endAt"})
    Response<Paging<RichOrderBuyerView>> buyerPaging(BaseUser loginer, Integer status,
                                       Long orderId, Integer pageNo, Integer size, String startAt, String endAt);

    /**
     * 买家订单列表(根据数据偏移量查询)
     * @param loginer 当前登录买家id
     * @param status 订单状态
     * @param orderId 订单id
     * @param offset 数据偏移量
     * @param size 每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return 订单分页信息
     */
    @Export(paramNames = {"loginer", "status", "orderId", "offset", "size", "startAt", "endAt"})
    Response<Paging<RichOrderBuyerView>> buyerpaging(BaseUser loginer, Integer status,
                                                     Long orderId, Integer offset, Integer size,
                                                     String startAt, String endAt);

    /**
     * 卖家订单列表
     * @param loginer 当前登录卖家id
     * @param status 订单状态
     * @param orderId 订单id
     * @param nickName 昵称
     * @param mobile 订单id
     * @param email 订单id
     * @param pageNo 页码
     * @param size 每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return 订单分页信息
     */
    @Export(paramNames = {"loginer", "status", "orderId", "nickName", "mobile", "email", "pageNo", "size", "startAt", "endAt"})
    Response<Paging<RichOrderSellerView>> sellerPaging(BaseUser loginer, Integer status,
                                                       Long orderId, String nickName, String mobile,
                                                       String email, Integer pageNo, Integer size, String startAt, String endAt);

    /**
     * 运营查看退货款订单列表
     * @param status  订单状态
     * @param orderId 订单id
     * @param pageNo  页码
     * @param size    每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return  完整的订单退款信息分页列表
     */
    @Deprecated
//    @Export(paramNames = {"status","orderId","pageNo","size","startAt","endAt","trackType"})
    Response<Paging<RichRefundInfo>> adminRefundPaging(Integer status, Long orderId,
                                                       Integer pageNo, Integer size,
                                                       String startAt, String endAt, String trackType);

    /**
     * 运营查看退货款订单列表
     * @param status  订单状态
     * @param orderId 订单id
     * @param pageNo  页码
     * @param size    每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return  完整的订单退款信息分页列表
     */
    @Export(paramNames = {"status","orderId","pageNo","size","startAt","endAt","trackType","refundTrackId"})
    Response<Paging<RichRefundInfo>> adminRefundPaging(String status, Long orderId,
                                                       Integer pageNo, Integer size,
                                                       String startAt, String endAt,
                                                       String trackType, Long refundTrackId);

    /**
     * 买家查看退货款订单入口
     * @param loginer 当前登录用户id
     * @param status  订单状态
     * @param orderId 订单id
     * @param pageNo  页码
     * @param size    每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return  完整的订单退款信息分页列表
     */
    @Deprecated
//    @Export(paramNames = {"loginer","status","orderId","pageNo","size","startAt","endAt","trackType"})
    Response<Paging<RichRefundInfo>> buyerRefundPaging(BaseUser loginer, Integer status,
                                                       Long orderId, Integer pageNo, Integer size,
                                                       String startAt, String endAt, String trackType);

    /**
     * 买家查看退货款订单入口
     * @param loginer 当前登录用户id
     * @param status  订单状态
     * @param orderId 订单id
     * @param pageNo  页码
     * @param size    每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return  完整的订单退款信息分页列表
     */
    @Export(paramNames = {"loginer","status","orderId","pageNo","size","startAt","endAt","trackType"})
    Response<Paging<RichRefundInfo>> buyerRefundPaging(BaseUser loginer, String status,
                                                       Long orderId, Integer pageNo, Integer size,
                                                       String startAt, String endAt, String trackType);

    /**
     * 卖家查看退货款订单入口
     * @param loginer 当前登录用户id
     * @param status  订单状态
     * @param orderId 订单id
     * @param pageNo  页码
     * @param size    每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return  完整的订单退款信息分页列表
     */
    @Deprecated
//    @Export(paramNames = {"loginer","status","orderId","pageNo","size","startAt","endAt","trackType"})
    Response<Paging<RichRefundInfo>> sellerRefundPaging(BaseUser loginer, Integer status,
                                                        Long orderId, Integer pageNo, Integer size,
                                                        String startAt, String endAt, String trackType);

    /**
     * 卖家查看退货款订单入口
     * @param loginer 当前登录用户id
     * @param status  订单状态
     * @param orderId 订单id
     * @param pageNo  页码
     * @param size    每页大小
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return  完整的订单退款信息分页列表
     */
    @Export(paramNames = {"loginer","status","orderId","pageNo","size","startAt","endAt","trackType","refundTrackId"})
    Response<Paging<RichRefundInfo>> sellerRefundPaging(BaseUser loginer, String status,
                                                        Long orderId, Integer pageNo, Integer size,
                                                        String startAt, String endAt, String trackType, Long refundTrackId);

    /**
     * 卖家查看管理订单发票信息
     *
     * @param loginSeller  登录卖家
     * @param orderId      订单号
     * @param invoiceNo    发票号
     * @param isInvoiceSet 发票筛选: true => 已开票, false => 未开票, null => 不筛选
     * @param paidFrom     支付时间筛选: 起始
     * @param paidTo       支付时间筛选: 为止
     * @param pageNo       页号
     * @param size         页面大小
     * @return 订单及发票信息
     */
    @Export(paramNames = {"loginSeller", "orderId", "invoiceNo", "isInvoiceSet", "paidFrom", "paidTo", "pageNo", "size"})
    Response<Paging<OrderInvoice>> sellerInvoicePaging(LoginSeller loginSeller,
                                                       @Nullable Long orderId, @Nullable String invoiceNo,
                                                       @Nullable Boolean isInvoiceSet,
                                                       @Nullable String paidFrom, @Nullable String paidTo,
                                                       @Nullable Integer pageNo, @Nullable Integer size);

    /**
     * 订单预览页
     * @param skus skuId和对应的sku数量
     * @param addressSelect 是否选择了地址
     * @return 订单预览页信息
     */
    @Export(paramNames = {"skus", "addressSelect", "loginer", "cookie"})
    Response<List<PreOrder>> preViewOrder(@NotNull(message = "skus.invalid") String skus,
                                          Boolean addressSelect,
                                          @NotNull(message = "user.not.login") BaseUser loginer,
                                          @NotNull(message = "cookie.invalid") InnerCookie cookie);


    /**
     * 订单支付预览
     * @param orderIds  待支付订单列表
     * @return 支付预览信息
     */
    @Export(paramNames = {"loginUser", "orderIds"})
    Response<PrePay> preViewPay(@NotNull(message = "user.not.login") LoginUser loginUser,
            @NotNull(message = "order.id.invalid") String orderIds);

    /**
     * 查询需要结算的订单 finishDAT>=startAt and finishDAT< endAt AND pay_type =1(在线支付) AND status != -6(买家取消订单) AND need_settle=true
     * @param startAt 起始时间
     * @param endAt 结束时间
     * @pageNo 当前页
     * @size    每页显示条数
     * @return 订单跟踪
     */
    Response<Paging<OrderTrack>> findNeedSettlementOrders(Date startAt,Date endAt, Integer pageNo, Integer size);




    /*******************   购物车查询  ****************************/


    /**
     * 查询当前登录用户的永久购物车
     * @param baseUser 当前登录用户
     * @return 购物车信息
     */
    @Export(paramNames = {"loginer"})
    Response<List<UserCart>> getPermanent(BaseUser baseUser);

    /**
     * 查询当前登录用户的永久购物车的sku的种类
     * @param baseUser 当前登录用户
     */
    @Export(paramNames = {"loginer"})
    Response<Integer> getPermanentCount(BaseUser baseUser);

    /**
     * 查询临时购物车
     * @param cookie 用户cookie
     * @return 临时购物车信息
     */
    Response<List<UserCart>> getTemporary(@NotNull(message = "cookie.invalid") String cookie);

    /**
     * 查询临时购物车sku种类
     * @param cookie 用户cookie
     */
    Response<Integer> getTemporaryCount(@NotNull(message = "cookie.invalid") String cookie);





    /*******************   订单评论查询  ****************************/


    /**
     * 买家根据多个维度的条件查询订单评价信息
     * @param loginer 当前登录用户
     * @param orderItemId 子订单id
     * @param itemId 商品id
     * @param itemName 商品名称
     * @param shopId 店铺id
     * @param shopName 店铺名称
     * @return 评价分页信息
     */
    @Export(paramNames = {"loginer","orderItemId","itemId","itemName","shopId","shopName","isReply","reference", "status", "quality","startAt","endAt","pageNo","size"})
    Response<Paging<OrderComment>> buyerOrderCommentPaging(BaseUser loginer, Long orderItemId,Long itemId,
                                                           String itemName, Long shopId, String shopName,
                                                           Boolean isReply, String reference,
                                                           Integer status,String quality,
                                                           String startAt, String endAt, Integer pageNo, Integer size);

    /**
     * 卖家根据多个维度的条件查询订单评价信息
     * @param loginer 当前登录用户
     * @param userName 买家名称
     * @param orderItemId 子订单id
     * @param itemId 商品id
     * @param itemName 商品名称
     * @param shopId 店铺id
     * @param shopName 店铺名称
     * @return 评价分页信息
     */
    @Export(paramNames = {"loginer","userName","orderItemId","itemId","itemName","shopId","shopName","isReply","reference","status","quality","startAt","endAt","pageNo","size"})
    Response<Paging<OrderComment>> sellerOrderCommentPaging(BaseUser loginer, String userName, Long orderItemId,
                                                            Long itemId, String itemName, Long shopId, String shopName,
                                                            Boolean isReply, String reference,
                                                            Integer status,String quality,
                                                            String startAt, String endAt, Integer pageNo, Integer size);


    /**
     * 运营根据多个维度的条件查询订单评价信息
     * @param userName 买家名称
     * @param orderItemId 子订单id
     * @param itemId 商品id
     * @param itemName 商品名称
     * @param shopId 店铺id
     * @param shopName 店铺名称
     * @param status 评价状态
     * @return 评价分页信息
     */
    @Export(paramNames = {"userId","userName","orderItemId","itemId","itemName","shopId","shopName","status","isReply","reference","quality","startAt","endAt","pageNo","size"})
    Response<Paging<OrderComment>> adminOrderCommentPaging(Long userId, String userName, Long orderItemId, Long itemId, String itemName,
                                                           Long shopId, String shopName, Integer status,
                                                           Boolean isReply, String reference ,String quality,
                                                           String startAt, String endAt, Integer pageNo, Integer size);

    /**
     * 商品详情页评价列表
     * @param itemId 商品id
     * @param pageNo 页码
     * @param size  每页大小
     * @return 分页的商品评价
     */
    Response<Paging<OrderComment>> itemOrderCommentPaging(@Min(value = 1L, message = "item.id.invalid")Long itemId,
                                                          Integer pageNo, Integer size);

    /**
     * 商品详情页评价数量
     * @param itemId 商品id
     * @return 商品的数量
     */
    Response<Long> itemOrderCommentNum(@Min(value = 1L, message = "item.id.invalid")Long itemId);

    /**
     * 商品详情页评价列表
     * @param itemId 商品id
     * @param offset 数据偏移
     * @param size  每页大小
     * @return 分页的商品评价
     */
    Response<Paging<OrderComment>> itemOrderCommentPagingByOffset(@Min(value = 1L, message = "item.id.invalid")Long itemId,
                                                          Integer offset, Integer size);

    /**
     * 买家商品评价列表
     * @param pageNo 页码
     * @param size 每页大小
     * @param hasComment 是否已评价
     * @param loginUser 当前登录用户
     * @return 分页子订单
     */
    Response<Paging<OrderCommentDto>> buyerPagingOrderItem(Integer pageNo, Integer size, Boolean hasComment,
                                                           @NotNull(message = "user.not.login")LoginUser loginUser);

    /**
     * 卖家商品评价列表
     * @param pageNo 页码
     * @param size 每页大小
     * @param loginUser 当前登录用户
     */
    Response<Paging<SellerCommentDto>> sellerPagingOrderItem(Integer pageNo, Integer size,
                                                             @NotNull(message = "user.not.login")LoginUser loginUser);

    /**
     * 根据订单id查找订单交易快照
     * @param loginer       登录用户
     * @param orderItemId   子订单id
     * @return 订单交易快照
     */
    @Export(paramNames = {"loginer", "orderItemId"})
    Response<OrderSnapshot> findOrderSnapshotByOrderId(BaseUser loginer, @NotNull Long orderItemId);

    /**
     * 查询子订单
     * @param orderItemId 子订单ID
     * @return 子订单
     */
    Response<OrderItem> findItemIdOfOrderItem(Long orderItemId);

    /**
     * 查询订单下的商品ID列表
     * @param orderId 订单ID
     * @return 商品ID列表
     */
    Response<List<Long>> findItemIdsByOrderId(Long orderId);


    /**
     * 查询订单跟踪信息
     * @param orderId 订单ID
     * @return 订单跟踪信息
     */
    Response<OrderTrack> findOrderTrackByOrderId(Long orderId);

    /**
     * 根据订单id查找子订单列表
     * @param orderId  订单id
     * @return  订单列表
     */
    Response<List<OrderItem>> findOrderItemByOrderId(
            @Valid
            @NotNull(message = "order.id.invalid")
            Long orderId);


    /**
     * 根据订单id集合查找子订单列表
     * @param orderIds  订单id集合
     * @return  子订单列表
     */
    Response<List<OrderItem>> findOrderItemByOrderIds(
            @Valid
            @NotNull(message = "order.id.invalid")
            List<Long> orderIds);


    /**
     * 根据订单id查找订单退款跟踪
     * @param orderId  订单id
     * @param types  退款类型
     * @return  订单退款跟踪列表
     */
    Response<List<OrderItemRefundTrack>> findOrderItemRefundTracksByOrderId(
            @NotNull(message = "order.id.invalid")
            Long orderId,List<OrderItemRefundTrack.TrackType> types);


    /**
     * 查询需要结算的订单退款信息 returnGoodsAt>=startAt and returnGoodsAt< endAt AND track_type =2 售后 AND status = -105 退货款完成
     * @param startAt 起始时间
     * @param endAt 结束时间
     * @pageNo 当前页
     * @size    每页显示条数
     * @type    退款类型 售中售后
     * @return 订单退款跟踪
     */
    Response<Paging<OrderItemRefundTrack>> findOrderItemRefundTracks(Date startAt,Date endAt, Integer pageNo, Integer size, OrderItemRefundTrack.TrackType type);

    /**
     * 每日订单统计数据
     * @param startAt 开始时间
     * @param endAt 结束时间
     * @return 每日订单统计数据
     */
    Response<OrderStatistics> dailyOrderStatistics(String startAt, String endAt);


    /**
     * 查询订单跟踪信息
     * @param orderIds 订单ID集合
     * @return 订单跟踪信息集合
     */
    Response<List<OrderTrack>> findOrderTrackByOrderIds(List<Long> orderIds);

    /**
     * 根据第三方支付流水号查询 订单跟踪信息
     * @param paymentCode 第三方支付流水号
     * @return 订单跟踪信息集合
     */
    Response<List<OrderTrack>> findOrderTrackByPaymentCode(String paymentCode);

    /**
     * 查询订单额外信息
     * @param orderIds 订单ID集合
     * @return 订单额外信息集合
     */
    Response<List<OrderExtra>> findOrderExtraByOrderIds(List<Long> orderIds);

    /**
     * 根据总订单主键查询关联订单并计算所有关联订单的差价和
     * @param orderId 总订单主键
     * @return 差价和
     */
    Response<Integer> findSubtractPriceByOrderId(Long orderId);

    /**
     * 根据总订单主键查询所有关联订单的所有子订单
     * @param orderId 总订单主键
     * @return 子订单集合
     */
    Response<List<OrderItem>> getChildOrderItemsByPid(Long orderId);

    /**
     * 查询订单记录信息
     * @param sellerId  卖家编号
     * @param buyerId   买家编号
     * @param status    订单状态
     * @param pageNo    当前页
     * @param size      每页显示条数
     * @return  Paging
     * 返回分页数据
     */
    Response<Paging<OrderItem>> queryBuyerOrder(Long sellerId, Long buyerId, Integer status, Integer pageNo, Integer size);

    /**
     * 根据多个子订单id批量查询优惠明细
     * @param orderItemIds 子订单id集合
     * @return 优惠明细
     */
    Response<List<OrderDiscountDetail>> findOrderDiscountDetailByItemIds(List<Long> orderItemIds);

    /**
     * 根据子订单id查询查询优惠明细
     * @param orderItemId 子订单id
     * @return查询优惠明细
     */
    Response<List<OrderDiscountDetail>> findOrderDiscountDetailByItemId(Long orderItemId);

    /**
     * 查询退款单
     * @param refundTrackId 退款单id
     * @return 退款单
     */
    Response<OrderItemRefundTrack> findRefundTrackById(@Min(value = 1L, message = "refund.track.id.invalid")Long refundTrackId);

    /**
     * 查询退款单
     * @param refundTrackId 退款单id
     * @return 退款单
     */
    Response<OrderItemRefundTrack> loadRefundTrackById(@Min(value = 1L, message = "refund.track.id.invalid")Long refundTrackId);

    /**
     * 根据类型和状态查询订单
     * @param type 订单类型
     * @param statuses 订单状态
     * @return 订单列表
     */
    Response<Paging<Order>> findOrderByTypeAndStatuses(Integer type, List<Integer> statuses, Integer pageNo, Integer size);

    /**
     * 根据类型和状态查询退款单
     * @param trackTypes 退款单类型,详见OrderItemRefundTrack.TrackType
     * @param statuses 状态,详见AfterSaleStatus
     * @param orderType 订单类型,详见OrderType.java
     * @param pageNo 页码
     * @param size 每页大小
     * @return 退款单列表
     */

    Response<Paging<OrderItemRefundTrack>> findRefundTrackByTypesAndStatusesAndTrackTypes(List<Integer> trackTypes, List<Integer> statuses,
                                                                             List<Integer> orderType, Integer pageNo, Integer size);

    /**
     * 统计微店分销商品数和金额
     * @return 微店分销商品数和金额统计
     */
    Response<List<OrderItem>> dailyItemAndFeeCounts();
   

    /***
     * 卖家【订单】不同状态的销量
     * dao层支持全量订单统计
     * @param sellerId  卖家ID
     * @param statuses  订单状态集
     * @return
     */
    Response<Long> findOrderSellerStatus(Long sellerId,String statuses);
    
    /***
     * 卖家【订单商品】评论量
     * dao层支持全量订单商品统计
     * @param sellerId      卖家ID
     * @param hasComment    是否评论
     * @return
     */
    Response<Long> findItemSellerComment(Long sellerId,Boolean hasComment);
    
    /***
     * 卖家未回复评论的数量
     * dao层支持全量订单商品统计
     * @param sellerId      卖家ID
     * @param isReply       
     * @return
     */
    Response<Long> findItemSellerReply(Long sellerId,int isReply);
}
