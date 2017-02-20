package cn.com.gome.trade.service;

import io.terminus.ecp.trade.service.OrderWriteService;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
    Response<Long> gomeApplyRefund(Long orderId, LoginUser loginUser, String reason, Integer refundAmount);

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
    Response<Boolean> gomeRefuseRefund(Long refundTrackId, LoginUser loginUser);

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
                                                        String channel, String data, LoginUser loginUser);

    /**
     * 妥投+7自动扣除余额
     * @param hours 应该扣除的时间
     */
    Response<Boolean> deductionBalance(Integer hours);

    /**
     * 创建支付提醒的redis key
     * @param orderId 订单id
     * @return 是否创建成功
     */
    Response<Boolean> createRemindPayKey(Long orderId);
}
