package cn.com.gome.trade.service;

import io.terminus.ecp.trade.service.OrderWriteService;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cn.com.gome.trade.dto.ordercreation.OrderCreationReq;
import cn.com.gome.trade.dto.ordercreation.OrderCreationResp;
import cn.com.gome.trade.dto.userdto.EcpLoginUser;
import cn.com.gome.trade.dto.userdto.LoginUser;

/**
 * Created by yangzefeng on 15/4/23
 */
public interface GomeOrderWriteService extends OrderWriteService {

    /**
     * 改变永久购物车商品数量
     * @param skuId 商品skuId
     * @param quantity 改变数量 正数为增负数为减
     * @param userId 用户id
     * @param weixinInfo 微店信息
     * @param type 1:添加商品类型       2更改商品数量 类型
     * @return 操作是否成功
     */
    Response<Boolean> changePermanentCartWithWeidianInfo(@NotNull(message = "sku.id.invalid")
                                                         @Min(value = 1L, message = "sku.id.invalid") Long skuId,
                                                         @NotNull(message = "quantity.invalid") Integer quantity,
                                                         @NotNull(message = "user.not.login")
                                                         @Min(value = 1L, message = "user.id.invalid") Long userId,
                                                         String weixinInfo,Integer type);

    /**
     * 合并购物车
     * @param userId 当前登录用户id
     * @param skus 需要合并的临时购物车商品
     * @return 是否合并成功
     */
    Response<Boolean> gomeMergeCart(Long userId, String skus);


    Response<Boolean> gomeBatchDeletePermanent(@NotNull(message = "sku.id.invalid")List<String> skuIds,
                                               @Min(value = 1L, message = "user.id.invalid")
                                               @NotNull(message = "user.not.login")Long userId);

    /**
     * 普通订单在线支付的买家取消订单操作,解冻国美币
     * @param orderId 订单
     * @param baseUser 当前登录用户
     * @return 操作是否成功
     */
    Response<Boolean> gomeCancelByBuyer(@Min(value = 1L, message = "order.id.invalid")
                                        @NotNull(message = "order.id.invalid")Long orderId,
                                        @NotNull(message = "user.not.login")BaseUser baseUser);

    /**
     * 售中买家拒收
     * @param orderId 订单id
     * @return 操作是否成功
     */
    Response<Boolean> buyerReject(@Min(value = 1L, message = "order.id.invalid")Long orderId,
                                  @NotNull(message = "user.not.login")LoginUser loginUser);
    
    /**
     * 售中买家拒收
     * @param orderId 订单id
     * @return 操作是否成功
     */
    Response<Boolean> buyerDeliveryRejection(@Min(value = 1L, message = "order.id.invalid")Long orderId,@Min(value = 1L, message = "order.id.invalid")Long orderDeliveryId,
                                  @NotNull(message = "user.not.login")LoginUser loginUser);

    /**
     * 延迟确认收货
     * @param user 当前登录用户
     * @param orderId 订单id
     * @return 操作是否成功
     */
    Response<Boolean> delayConfirm(@NotNull(message = "user.not.login")EcpLoginUser user,
    		                      @Min(value = 1L, message = "order.id.invalid")Long orderId);
    /**
     * 确认退款
     * @param refundTrackId 退款单id
     * @return 确认退款
     */
    Response<Boolean> confirmReturnsAfterBuyerReject(@Min(value = 1L, message = "order.id.invalid")Long refundTrackId);

    /**
     * 申请退款
     * @param orderId 订单id
     * @param loginUser 当前登录用户id
     * @return 是否操作成功
     */
    Response<Long> gomeApplyRefund(Long orderId, EcpLoginUser loginUser, String reason, Integer refundAmount);

    /**
     * 同意退款
     * @param refundTrackId 退款单id
     * @return 是否操作成功
     */
    Response<Boolean> gomeAgreeRefund(Long refundTrackId);

    /**
     * 拒绝退款
     * @param refundTrackId 退款单id
     * @param loginUser 当前登录用户id
     * @return 是否操作成功
     */
    Response<Boolean> gomeRefuseRefund(Long refundTrackId, EcpLoginUser loginUser);

    /**
     * 国美创建订单
     * @param tradeInfo 收货地址信息
     * @param addressId 送货区域编号
     * @param channel 支付渠道
     * @param data 订单信息
     * @param loginUser 当前登录用户
     * @return 订单id
     */
    Response<Map<String, Serializable>> gomeCreateOrder(String tradeInfo, Integer addressId,
                                                        String channel, String data, EcpLoginUser loginUser);

    /**
     * 妥投+7自动扣除余额
     * @param hours 应该扣除的时间
     */
    Response<Boolean> deductionBalance(Integer hours);

    /**
     * 妥投+7自动扣减优惠券预算
     * @param hours
     * @return
     */
    Response<Boolean> cutCouponBudgetConfirmOrder(Integer hours);
    
    /**
     * 创建支付提醒的redis key
     * @param orderId 订单id
     * @return 是否创建成功
     */
    Response<Boolean> createRemindPayKey(Long orderId);
    
    
    /**
     * 
     * 新版创建订单
     * @time 2016年5月6日10:50:07
     * @author wangjiatian
     * @param orderCreationReq
     * @return
     */
    Response<OrderCreationResp> createOrder(OrderCreationReq orderCreationReq);
    
    /**
     * 
     * @Description TODO 批量取消订单
     * @author wangjiatian
     * @date 2016年7月1日 上午10:43:12
     * @param orderIds
     * @param baseUser
     * @return
     */
    Response<Boolean> gomeBatchCancelByBuyer(List<Long> orderIds, BaseUser baseUser);

    /**
     * 
     * @Description TODO 更新购物信息带商品来源的
     * @author wangjiatian
     * @date 2016年7月19日 下午9:41:37
     * @param skuId
     * @param quantity
     * @param userId
     * @param weixinInfo
     * @param type
     * @param sourceCode
     * @return
     */
    Response<Boolean> changePermanentCartWithSourceCode(Long skuId, Integer quantity, Long userId, String weixinInfo,Integer type,String sourceCode);
    /**
     * 发送消息提醒
     * @param userId
     * @param messageType
     * @param messageParams
     * @return
     */
    Response<Boolean> messageNotify(Long userId,Integer messageType,Map<String,Object> messageParams);


    
    /**
     * 
     * @param tradeInfo 
     * @param orderId
     * @param loginUser
     * @return
     */
    Response<Boolean> changeOrderTradeInfo(String tradeInfo, Long orderId, EcpLoginUser loginUser);
    
    /**
     * 
     * @Description 重新分配运费 
     * @author wangjiatian
     * @date 2016年9月12日 下午4:33:14
     * @param orderId
     * @param shipFee
     * @return
     */
    Response<Boolean> resetOrderShipFee(Long orderId, Integer shipFee,BaseUser baseUser);
}
