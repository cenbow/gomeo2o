package io.terminus.ecp.trade.service;

import io.terminus.ecp.trade.model.OrderItemRefundTrack;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 *   功能描述: 订单退款服务类
 * </pre>
 *
 * @author wanggen on 2015-01-10.
 */
public interface OrderRefundService {


    /**
     * 子订单退款请求
     *
     * @param orderItemId 子订单ID
     * @param user        当前操作者
     * @return 退款操作页面路径
     */
    Response<String> refundRequest(
            @Min(value = 1L, message = "order.item.id.invalid") Long orderItemId,
            @NotNull(message = "user.not.login") BaseUser user);

    /**
     * 申请售后
     * @param orderItemId 子订单id
     * @param refundAmount 退款金额
     * @param Reason 退货款理由
     * @param remark 备注
     * @return 是否成功
     */
    Response<Long> afterSaleApply(@Min(value = 1l, message = "order.item.id.invalid")Long orderItemId,
                                     @NotNull(message = "refund.amount.invalid")Integer refundAmount,
                                     String Reason, String remark, Integer type);

    /**
     * 同意售后退货
     * @param orderItemRefundTrackId 售后id
     * @param user 操作人
     * @return 是否操作成功
     */
    Response<Boolean> agreeAfterSaleReturns(@Min(value = 1L, message = "order.refund.track.id.invalid")Long orderItemRefundTrackId,
                                            @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 拒绝售后退货
     * @param orderItemRefundTrackId 售后id
     * @param refuseReason 拒绝退货款理由
     * @param user 操作人
     * @return 是否操作成功
     */
    Response<Boolean> refuseAfterSaleReturns(@Min(value = 1L, message = "order.refund.track.id.invalid")Long orderItemRefundTrackId,
                                             String refuseReason,
                                             @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 售后买家发货
     * @param orderItemRefundTrackId 售后id
     * @param expressInfoId 快递公司信息id {@link io.terminus.ecp.trade.model.ExpressInfo#id}
     * @param waybillNo 快递运单号
     * @param user 操作人
     * @return 是否操作成功
     */
    Response<Boolean> afterSaleDeliver(@Min(value = 1L, message = "order.refund.track.id.invalid")
                                       @NotNull(message = "order.refund.track.id.invalid")Long orderItemRefundTrackId,
                                       @Nullable Long expressInfoId,
                                       @Nullable String waybillNo,
                                       @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 售后买家发货修改物流
     * @param orderItemRefundTrackId 售后id
     * @param expressInfoId 快递公司信息id {@link io.terminus.ecp.trade.model.ExpressInfo#id}
     * @param waybillNo 快递运单号
     * @param user 操作人
     * @return 是否操作成功
     */
    Response<Boolean> afterSaleDeliverModify(@Min(value = 1L, message = "order.refund.track.id.invalid")
                                             @NotNull(message = "order.refund.track.id.invalid")Long orderItemRefundTrackId,
                                             @Min(value = 1L, message = "express.info.id.invalid")
                                             @NotNull(message = "express.info.id.invalid")Long expressInfoId,
                                             @NotBlank(message = "logistics.waybill.blank") String waybillNo,
                                             @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 商家确认收到退货
     * @param refundTrackId 退货信息id
     * @return 是否操作成功
     */
    Response<Boolean> afterSaleConfirmReceiving(@Min(value = 1l, message = "order.refund.track.id.invalid")
                                              Long refundTrackId,
                                              @NotNull(message = "user.not.login") BaseUser user);

    /**
     * 售后运营退款
     * @param orderItemId 子订单id
     * @param user 操作人
     * @return 是否操作成功
     */
    Response<Boolean> afterSaleRefund(@Min(value = 1L, message = "order.item.id.invalid")Long orderItemId,
                                      @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 售后运营退款,直接完成售后流程,忽略其他与售后相关状态流转
     * @param orderItemId 子订单id
     * @param user 操作人
     * @return 是否操作成功
     */
    public Response<Boolean> afterSaleForceRefund(@Min(value = 1L, message = "order.item.id.invalid")Long orderItemId,
                                                  @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 判断是否是售后的退款请求
     * @param orderItemId 子订单id
     * @return 是否售后退款请求
     */
    Response<Boolean> judgeAfterSaleRefund(@Min(value = 1L, message = "order.item.id.invalid")Long orderItemId);

    /**
     * 超时自动确认退货
     * @param intervalHours 超时小时数
     */
    Response<Boolean> autoAgreeAfterSaleReturns(@NotNull(message = "interval.invalid")Integer intervalHours);

    /**
     * 更新退款单状态
     * @param refundTrackId 退款单id
     * @param status 待更新状态
     * @return 是否更新成功
     */
    Response<Boolean> updateOrderItemRefundTrack(@Min(value = 1L, message = "refund.track.id.invalid")Long refundTrackId, Integer status);

    /**
     * 更新退款单
     * @param refundTrack 退款单对象
     * @return 是否更新成功
     */
    Response<Boolean> updateRefundTrack(OrderItemRefundTrack refundTrack);
}
