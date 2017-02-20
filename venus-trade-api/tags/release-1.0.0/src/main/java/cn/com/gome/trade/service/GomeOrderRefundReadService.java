package cn.com.gome.trade.service;

import java.util.List;

import cn.com.gome.trade.dto.GomeRichRefundDto;
import cn.com.gome.trade.dto.RefundTrackDto;
import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by yangzefeng on 15/5/21
 */
public interface GomeOrderRefundReadService {

    /**
     * 查询退款单详情
     * @param refundTrackId 退款单id
     * @return dto
     */
    @Export(paramNames = {"refundTrackId", "loginUser"})
    Response<RefundTrackDto> refundTrackDetail(@Min(value = 1L, message = "refund.track.id.invalid")Long refundTrackId,
                                               @NotNull(message = "user.not.login")LoginUser loginUser);

    /**
     * 查询退款单列表
     * @param loginUser 当前登录用户id
     * @return 分页退款单列表
     */
    Response<Paging<GomeRichRefundDto>> refundPaging(@NotNull(message = "user.not.login")LoginUser loginUser,
                                                           Integer type, Long refundTrackId, Integer pageNo, Integer size);

    /**
     * 根据订单id查询退款单
     * @param orderId 订单id
     * @return 退款单
     */
    Response<OrderItemRefundTrack> findRefundTrackByOrderId(@Min(value = 1L, message = "order.id.invalid")
                                                            @NotNull(message = "order.id.invalid")Long orderId);
    
    
    /**
     * @Description  根据订单Id 查询所有退款单
     * @author tangfeng
     * @time 2015年11月27日 下午2:34:57
     * @param orderId
     * @return
     */
    Response<List<OrderItemRefundTrack>> findRefundTrackAllByOrderId(@Min(value = 1L, message = "order.id.invalid")
    																 @NotNull(message = "order.id.invalid")Long orderId);
    /**
     * @Description  根据子订单Id 查询所有退款单
     * @author tangfeng
     * @time 2015年11月27日 下午2:34:57
     * @param orderId
     * @return
     */
    Response<List<OrderItemRefundTrack>> findRefundTrackAllByOrderItemId(@Min(value = 1L, message = "order.id.invalid")
    @NotNull(message = "order.id.invalid")Long orderItemId);
    
    /**
     * 微店查询退款单列表
     * @param loginUser 当前登录用户id
     * @return 分页退款单列表
     */
    Response<Paging<GomeRichRefundDto>> weidianRefundPaging(@NotNull(message = "user.not.login")LoginUser loginUser,
                                                     Integer type, Long refundTrackId, Long referenceId, Integer pageNo, Integer size);

    /**
     * 微店达人查询退款单详情
     * @param refundTrackId 退款单id
     * @return dto
     */
    @Export(paramNames = {"refundTrackId", "loginUser"})
    Response<RefundTrackDto> weidianRefundTrackDetail(@Min(value = 1L, message = "refund.track.id.invalid")Long refundTrackId,
                                               @NotNull(message = "user.not.login")LoginUser loginUser);
}
