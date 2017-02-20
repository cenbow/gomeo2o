/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service;

import io.terminus.ecp.pay.dto.PayStageInfo;
import io.terminus.ecp.pay.model.PayChannel;
import io.terminus.ecp.trade.dto.SkuIdAndQuantityAndLevel;
import io.terminus.ecp.trade.model.ExpressInfo;
import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderComment;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderPay;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yangzefeng on 14-9-10
 */
public interface OrderWriteService {

    /************************ order *************************/

    /**
     * 创建订单
     * @param order 订单
     * @param orderItems 子订单
     * @param context 其他参数（营销工具信息）
     * @return 创建的订单id
     */
    Response<Long> createOrder(Order order, List<OrderItem> orderItems, Map<String, Serializable> context);

    /**
     * 批量创建订单，每个list相同的index对应的对象是一个组，调用上面createOrder接口的内部实现，同时保证事务
     */
    Response<List<Long>> batchCreateOrder(List<Order> orders, List<List<OrderItem>> orderItems, List<Map<String, Serializable>> contexts);

    /**
     * 普通订单在线支付
     * @param orderPay 订单支付信息
     * @return 操作是否成功
     */
    Response<Boolean> pay(@NotNull(message = "order.pay.invalid") OrderPay orderPay);

    /**
     * 普通订单在线支付 for 分期付款
     * @param payChannel 订单支付渠道信息
     * @return 操作是否成功
     */
    Response<Boolean> pay(@NotNull(message = "pay.channel.invalid") PayChannel payChannel);


    /**
     * 普通订单在线支付和货到付款的发货操作
     * @param orderId 订单id
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     * @deprecated TODO(Effet): 是否有保留的必要
     */
    @Deprecated
    Response<Boolean> deliver(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")Long orderId,
            @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 普通订单在线支付和货到付款的发货操作(快递公司信息)
     * @param orderId 订单id
     * @param expressInfoId 快递公司信息id {@link ExpressInfo#id}
     * @param waybillNo 快递运单号
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> deliver(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")Long orderId,
            @Nullable Long expressInfoId,
            @Nullable String waybillNo,
            @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 更新快递信息（发货后）
     * @param orderId 订单id
     * @param expressInfoId 快递公司信息id {@link io.terminus.ecp.trade.model.ExpressInfo#id}
     * @param waybillNo 运单号
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> updateDeliver(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid") Long orderId,
            @Min(value = 1L, message = "express.info.id.invalid")
            @NotNull(message = "express.info.id.invalid") Long expressInfoId,
            @NotBlank(message = "logistics.waybill.blank") String waybillNo,
            @NotNull(message = "user.not.login") BaseUser baseUser);

    /**
     * 普通订单在线支付和货到付款的确认收货操作
     * @param orderId 订单id
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> confirm(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")Long orderId,
            @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 普通订单在线支付和货到付款的买家取消订单操作
     * @param orderId 订单
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> cancelByBuyer(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")Long orderId,
            @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 普通订单在线支付和货到付款的卖家家取消订单操作
     * @param orderId 订单
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> cancelBySeller(
            @Min(value = 1L, message = "order.id.invalid")
            @NotNull(message = "order.id.invalid")Long orderId,
            @NotNull(message = "user.not.login")BaseUser baseUser);


    /**
     * 买家删除订单
     * @param orderId 订单id
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> buyerDelete(@Min(value = 1L, message = "order.id.invalid")
                                  @NotNull(message = "order.id.invalid")Long orderId,
                                  @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 禁止该子订单退款申请
     * @param orderItemId 子订单
     * @param baseUser 操作员
     * @return 处理结果
     */
    Response<Boolean> preventRefundReq(@NotNull(message = "order.item.id.invalid") List<Long> orderItemId,
                                       @NotNull(message = "user.not.login")BaseUser baseUser);


    /**
     * 普通订单在线支付 申请退款
     * @param orderItemId 子订单id
     * @param refundReason 退款原因
     * @param refundAmount 退款金额
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> applyRefund(
            @Min(value = 1L, message = "order.item.id.invalid")
            @NotNull(message = "order.item.id.invalid")Long orderItemId,
            @NotNull(message = "refund.reason.invalid")String refundReason,
            @NotNull(message = "refund.amount.invalid")
            @Min(value = 0, message = "refund.amount.invalid")Integer refundAmount,
            @NotNull(message = "user.not.login")BaseUser baseUser);


    /**
     * 普通订单在线支付 确认退款 订单关闭
     * @param orderItemId 子订单id
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean> confirmRefund(
            @Min(value = 1L, message = "order.item.id.invalid")
            @NotNull(message = "order.item.id.invalid")Long orderItemId,
            @NotNull(message = "user.not.login")BaseUser baseUser);


    /**
     * 卖家接受买家退款|退货申请
     * @param orderItemId   子订单ID
     * @param baseUser      当前操作者
     * @return  处理结果
     */
    Response<Boolean> agreeRefund(@Min(value = 1L, message = "order.item.id.invalid") Long orderItemId, @NotNull(message = "user.not.login") BaseUser baseUser);


    /**
     * 普通订单在线支付 卖家拒绝退款
     * @param orderItemId 子订单id
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean> refuseRefund(
            @Min(value = 1L, message = "order.item.id.invalid")
            @NotNull(message = "order.item.id.invalid")Long orderItemId,
            @NotNull(message = "user.not.login")BaseUser baseUser);


    /**
     * 普通订单在线支付和货到付款 买家申请退货款
     * @param orderItemId 子订单id
     * @param returnsReason 申请退货理由
     * @param returnsAmount 申请退货金额
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean> applyReturns(@Min(value = 1L, message = "order.item.id.invalid")
                                   @NotNull(message = "order.item.id.invalid")Long orderItemId,
                                   @NotNull(message = "returns.reason.invalid")String returnsReason,
                                   @Min(value = 0, message = "refund.amount.invalid")
                                   @NotNull(message = "refund.amount.invalid")Integer returnsAmount,
                                   @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 普通订单在线支付和货到付款 卖家同意退货款
     * @param orderItemId 子订单id
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean> agreeReturns(@Min(value = 1L, message = "order.item.id.invalid")
                                   @NotNull(message = "order.item.id.invalid")Long orderItemId,
                                   @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 普通订单在线支付和货到付款 卖家确认收到退货款 订单关闭
     * @param orderItemId 子订单id
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean>  confirmReturns(@Min(value = 1L, message = "order.item.id.invalid")
                                     @NotNull(message = "order.item.id.invalid")Long orderItemId,
                                     @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 普通订单在线支付和货到付款 卖家拒绝退货
     * @param orderItemId 子订单id
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean> refuseReturns(@Min(value = 1L, message = "order.item.id.invalid")
                                    @NotNull(message = "order.item.id.invalid")Long orderItemId,
                                    @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 撤销退款操作
     * @param orderItemId 子订单id
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean> undoRefund(@Min(value = 1L, message = "order.item.id.invalid")
                                 @NotNull(message = "order.item.id.invalid")Long orderItemId,
                                 @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 撤销退货操作
     * @param orderItemId 子订单id
     * @param baseUser 当前登录用户
     * @return 是否成功
     */
    Response<Boolean> undoReturns(@Min(value = 1L, message = "order.item.id.invalid")
                                  @NotNull(message = "order.item.id.invalid")Long orderItemId,
                                  @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 订单超时未付款自动取消
     */
    Response<Boolean> orderNotPaidExpire(Integer payExpireHours);

    /**
     * 海尔地产特殊需要，修改关联订单价格
     * @param orderId 总订单id
     * @param skuIdAndQuantityAndLevels 修改主订单价格参数,依次为skuId,quantity,level(第几阶梯价格)
     * @param stageAndAmount 每期支付金额
     * @return 是否修改成功
     */
    Response<Boolean> updateOrderPrice(@Min(value = 1L, message = "order.id.invalid")Long orderId,
                                       @NotNull(message = "sku.and.quantity.invalid")List<SkuIdAndQuantityAndLevel> skuIdAndQuantityAndLevels,
                                       @NotNull(message = "stage.and.amount.invalid")Map<Integer, Integer> stageAndAmount);

    /**
     * 更新订单额外信息
     * @param orderId 订单id
     * @param extra 额外信息
     * @return 是否修改成功
     */
    Response<Boolean> updateOrderExtra(@Min(value = 1L, message = "order.id.invalid")Long orderId, String extra);

    /**
     * 更新订单状态
     * @param orderId 订单id
     * @param status 订单状态
     * @return 是否修改成功
     */
    Response<Boolean> updateOrderStatus(@Min(value = 1L, message = "order.id.invalid")Long orderId,
                                        @NotNull(message = "order.status.invalid")Integer status);

    /**
     * 更新退款单额外信息
     * @param refundTrackId 退款单id
     * @param extra 额外信息
     * @return 是否修改成功
     */
    Response<Boolean> updateRefundTrackExtra(@Min(value = 1L, message = "refund.track.id.invalid")Long refundTrackId, String extra);

    /************************  cart ****************************/


    /**
     * 改变永久购物车商品数量
     * @param skuId 商品skuId
     * @param quantity 改变数量 正数为增负数为减
     * @param userId 用户id
     * @return 操作是否成功
     */
    Response<Boolean> changePermanentCart(@NotNull(message = "sku.id.invalid")
                                          @Min(value = 1L, message = "sku.id.invalid")Long skuId,
                                          @NotNull(message = "quantity.invalid")Integer quantity,
                                          @NotNull(message = "user.not.login")
                                          @Min(value = 1L, message = "user.id.invalid")Long userId);

    /**
     * 改变临时购物车商品数量
     * @param skuId 商品skuId
     * @param quantity 改变数量 正数为增负数为减
     * @param cookie cookie
     * @return 操作是否成功
     */
    Response<Boolean> changeTemporaryCart(@NotNull(message = "sku.id.invalid")
                                          @Min(value = 1L, message = "sku.id.invalid")Long skuId,
                                          @NotNull(message = "quantity.invalid")Integer quantity,
                                          @NotNull(message = "cookie.invalid")String cookie);

    /**
     * 合并临时购物车到永久购物车中
     * @param userId 当前登录用户id
     * @param cookie cookie值
     * @return 是否合并成功
     */
    Response<Boolean> mergePermanentAndTemporary(@Min(value = 1L, message = "user.id.invalid")
                                                 @NotNull(message = "user.not.login")Long userId,
                                                 @NotNull(message = "cookie.invalid")String cookie);

    /**
     * 删除购物车
     * @param userIdOrCookie 当前登录id或者cookie
     * @return 是否删除成功
     */
    Response<Boolean> deleteCart(@NotNull(message = "cookie.or.user.id.invalid")String userIdOrCookie);

    /**
     * 批量删除永久购物车中的商品
     * @param skuIds 商品skuId组
     * @param userId 当前登录用户id
     * @return 是否删除成功
     */
    Response<Boolean> batchDeletePermanent(@NotNull(message = "sku.id.invalid")List<Long> skuIds,
                                           @Min(value = 1L, message = "user.id.invalid")
                                           @NotNull(message = "user.not.login")Long userId);

    /**
     * 批量更新购物车
     * @param cartChanges 购物车需要修改的内容
     * @return 是否修改成功
     */
    Response<Boolean> batchChangePermanent(String cartChanges, LoginUser loginUser);

    /************************  order comment ****************************/


    /**
     * 添加订单评论
     * @param orderComments 一个总订单的所有评论
     * @param orderId 订单id
     * @return 创建的评论id
     */
    Response<Map<Long, List<String>>> createOrderComment(@NotEmpty (message = "order.comment.invalid")List<OrderComment> orderComments,
                                         @NotNull(message = "order.id.invalid")
                                         @Min(value = 1L, message = "order.id.invalid") Long orderId);

    /**
     * 创建子订单的评价
     * @param orderItemId 子订单id
     * @param orderComment 评价内容
     * @return 评价id
     */
    Response<Long> createOrderItemComment(@Min(value = 1L, message = "order.item.id.invalid")Long orderItemId,
                                          @NotNull(message = "order.comment.invalid")OrderComment orderComment,
                                          LoginUser loginUser);

    /**
     * 外部导入评价接口
     * @param orderComments 评价对象列表
     * @return 插入成功条数
     */
    Response<Integer> createOrderComments(@NotNull(message = "order.comment.invalid")List<OrderComment> orderComments);

    /**
     * 物理删除评价
     * @param orderCommentId 评价id
     * @return 是否操作成功
     */
    Response<Boolean> deleteOrderComment(@Min(value = 1L, message = "order.comment.id.invalid")Long orderCommentId,
                                         @NotNull(message = "user.not.login") LoginUser loginUser);

    /**
     * 添加评论回复
     * @param orderCommentId 评论id
     * @param reply 回复内容
     * @param loginerId 登录用户id
     * @return 是否添加成功
     */
    Response<List<String>> addCommentReply(@Min(value = 1L, message = "order.comment.id.invalid")
                                      @NotNull(message = "order.comment.id.invalid")Long orderCommentId,
                                      @NotNull(message = "order.comment.reply.invalid") String reply,
                                      @Min(value = 1L, message = "user.id.invalid")
                                      @NotNull(message = "user.not.login") Long loginerId);

    /**
     * 批量修改订单评价状态
     * @param orderCommentIds 订单评价id列表
     * @param status 评价状态
     * @return 是否修改成功
     */
    Response<Boolean> batchUpdateOrderComment(@NotNull(message = "order.comment.id.invalid")
                                              List<Long> orderCommentIds,
                                              @NotNull(message = "order.comment.status.invalid")
                                              Integer status);

    /**
     * 更新发票信息
     *
     * @param invoice 发票信息
     * @return 更新结果
     */
    Response<Boolean> updateInvoice(Map invoice);

    /**
     * 更新发票号
     *
     * @param sellerId  商家 id
     * @param subId     商家子帐号 id
     * @param orderId   订单号
     * @param invoiceNo 发票号
     * @return 是否成功
     */
    Response<Boolean> updateInvoiceNo(long sellerId, long subId, long orderId, String invoiceNo);

    /**
     * 更新卖家留言
     * @param orderId 订单id
     * @param sellerNotes 卖家留言
     * @param loginUser 登录的用户
     * @return 是否更新成功
     */
    Response<List<String>> updateSellerNotes(@Min(value = 1l, message = "order.id.invalid")Long orderId,
                                        String sellerNotes, @NotNull(message = "user.not.login")LoginUser loginUser);

    /**
     * 全量统计
     */
    Response<Boolean> forDumpOrderComment() ;

    /**
     * 增量统计
     */
    Response<Boolean> forDeltaDumpOrderComment();

    /**
     * 统计某一个店铺
     * @param shopId 店铺id
     */
    Response<Boolean> forShopDumpOrderComment(@Min(value = 1L, message = "shop.id.invalid")
                                  @NotNull(message = "shop.id.invalid")Long shopId);

    /**
     * 标记订单已支付
     * @param orderId 订单id
     * @return 是否成功
     */
    Response<Boolean> setSettled(@Min(value = 1L, message = "order.id.invalid") Long orderId);


    /**
     * 批量更新订单追踪信息中systemNo的值
     * @param orderIds 订单id集合
     * @return 系统内部流水号
     */
    Response<String> updateOrderTrackSystemNo(@NotEmpty(message = "order.id.invalid") List<Long> orderIds);

    /**
     * 创建支付相关信息 同时更新orderTrack中得systemNo
     * @param orders 订单集合 多个则代表合并支付
     * @param stageInfos 支付阶段信息封装
     * @return 是否创建成功
     */
    Response<Boolean> createPayInfo(List<Order> orders,List<PayStageInfo> stageInfos);

    /**
     * 超时未付款订单
     * @param expireHours 超时时间
     * @return 操作是否成功
     */
    Response<Boolean> expireNotPaidOrder(Integer expireHours);

    /**
     * 超时未确认收货订单
     * @param expireHours 超时时间
     * @return 操作是否成功
     */
    Response<Boolean> expireNotConfirmOrder(Integer expireHours);
    
    /***
     * 订单创建回写数据到总订单
     * @param map
     * @return
     */
    Response<Boolean> mergerOrderWriteBack (Map<String, Serializable> map);
}
