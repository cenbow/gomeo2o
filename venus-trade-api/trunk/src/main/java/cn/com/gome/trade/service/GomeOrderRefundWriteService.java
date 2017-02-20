package cn.com.gome.trade.service;

import java.util.Map;

import io.terminus.ecp.trade.service.OrderRefundService;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cn.com.gome.trade.dto.io.aftersalesorder.ApplyAfterSalesOrderRequestDto;
import cn.com.gome.trade.dto.paydto.PayChannel;
import cn.com.gome.trade.dto.userdto.EcpLoginUser;

/**
 * Created by yangzefeng on 15/5/12
 */
public interface GomeOrderRefundWriteService extends OrderRefundService {

    /**
     * 售后卖家拒收
     * @param refundTrackId 退款单id
     * @param loginUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> sellerReject(@Min(value = 1L, message = "refund.track.id.invalid")
                                   @NotNull(message = "refund.track.id.invalid")Long refundTrackId,
                                   @NotNull(message = "user.not.login")EcpLoginUser loginUser);

    /**
     * 售后卖家发货
     * @param refundTrackId 退款单id
     * @param loginUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> sellerDeliver(@Min(value = 1L, message = "refund.track.id.invalid")
                                    @NotNull(message = "refund.track.id.invalid")Long refundTrackId,
                                    @Nullable Long expressInfoId,
                                    @Nullable String waybillNo,
                                    @NotNull(message = "user.not.login")EcpLoginUser loginUser);

    /**
     * 售后买家拒收
     * @param refundTrackId 退款单id
     * @param loginUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> buyerReject(@Min(value = 1L, message = "refund.track.id.invalid")
                                  @NotNull(message = "refund.track.id.invalid")Long refundTrackId,
                                  @NotNull(message = "user.not.login")EcpLoginUser loginUser);

    /**
     * 售后换货成功
     * @param refundTrackId 退款单id
     * @param loginUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> buyerConfirmReceive(@Min(value = 1L, message = "refund.track.id.invalid")
                                      @NotNull(message = "refund.track.id.invalid")Long refundTrackId,
                                      @NotNull(message = "user.not.login")EcpLoginUser loginUser);

    /**
     * 申请售后
     * @param orderItemId 子订单id
     * @param refundAmount 退款金额
     * @param Reason 退货款理由
     * @param remark 备注
     * @param type 2表示申请退货，3表示申请换货
     * @return 是否成功
     */
    Response<Long> gomeAfterSaleApply(@Min(value = 1l, message = "order.item.id.invalid")Long orderItemId,
                                      Integer refundAmount,
                                      String Reason, String remark, Integer type, String deliverMethod);
   /**
    * 
    * @Description   由于账户余额不足等原因导致退款失败，重新生成新退款单
    * @author tangfeng
    * @time 2015年11月19日 下午1:23:10
    * @param refundTrackId   子订单ID
    * @param reason      退款失败原因
    * @param remark      退款失败备注
     * @return            是否成功
    */
    Response<Boolean> gomeRefundFailedApply(@Min(value = 1l, message = "order.refund.track.id.invalid")Long refundTrackId,
    		String reason, String remark);
    
    
    
    /**
     * 商家确认收到退货
     * @param refundTrackId 退货信息id
     * @return 是否操作成功
     */
    Response<Boolean> gomeAfterSaleConfirmReceiving(@Min(value = 1l, message = "order.refund.track.id.invalid")
                                                Long refundTrackId,
                                                @NotNull(message = "user.not.login") BaseUser user);

    /**
     * 买家拒收后运营或商家关闭订单
     * @param refundTrackId 退款单id
     * @param user 当前登录用户
     * @return 是否操作成功
     */
    Response<Boolean> cancelAfterBuyerReject(@Min(value = 1l, message = "order.refund.track.id.invalid")Long refundTrackId,
                                          @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 预退款接口
     * @param reqMap 退款信息 saleAfterId 售后单id refundShipFee 退运费金额 
     * @return 是否调用成功
     */
    Response<Boolean> preRefund(Map<String, Object> reqMap,Long saleAfterId,Integer refundShipFee);

    /**
     * 退款入口
     * @param payChannel 支付信息
     * @param refundAmount 真实退款金额（可能不包含运费）
     * @param refundShipFee 真实退运费金额(tangfeng 20160122)
     * @return 是否调用成功
     */
    Response<Boolean> refund(PayChannel payChannel, Integer refundAmount,Integer refundShipFee);

    /**
     * 售后买家发货
     * @param orderItemRefundTrackId 售后id
     * @param expressInfoId 快递公司信息id {@link io.terminus.ecp.trade.model.ExpressInfo#id}
     * @param waybillNo 快递运单号
     * @param user 操作人
     * @return 是否操作成功
     */
    Response<Boolean> gomeAfterSaleDeliver(@Min(value = 1L, message = "order.refund.track.id.invalid")
                                       @NotNull(message = "order.refund.track.id.invalid")Long orderItemRefundTrackId,
                                       @Nullable Long expressInfoId,
                                       @Nullable String waybillNo,
                                       @NotNull(message = "user.not.login")BaseUser user);

    /**
     * 卖家已上门取货
     * @param orderItemRefundTrackId
     * @param user
     * @return
     */
    public Response<Boolean> gomeAfterSaleSellerPickUp(Long orderItemRefundTrackId,
                                                       BaseUser user);
    /**
     * 更新退款单状态，如果是售中订单，事务中更新总订单状态
     * @param refundTrackId 退款单id
     * @param status 待更新状态
     * @param refundAmount 退款金额
     * @param refundShipFee 退的运费金额 (tangfeng 20160122)
     * @return 是否操作成功
     */
    Response<Boolean> gomeUpdateStatus(Long refundTrackId, Integer status, Integer refundAmount,Integer refundShipFee);

    /**
     * 更新同意退款时间
     * @param refundTrackId 退款单id
     * @return 是否操作成功
     */
    Response<Boolean> gomeUpdateAgreeRefundAt(Long refundTrackId);
    
    /**
     * 申请售后
     * @param applyAfterSalesOrderRequestDto 申请退货请求参数
     * @return 是否成功
     */
    Response<Long> gomeApplyAfterSalesOrder(ApplyAfterSalesOrderRequestDto applyAfterSalesOrderRequestDto);

    /**
     * 在线同步回来可以退货退款
     * @param afterSaleId
     * @param amount
     * @param extraMap
     * @return
     */
     Response<Boolean> onlineAfterSalesRefund(Long afterSaleId,Integer amount,Map extraMap);
}
