package cn.com.gome.trade.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cn.com.gome.trade.dto.GomeRichRefundDto;
import cn.com.gome.trade.dto.RefundTrackDto;
import cn.com.gome.trade.dto.TradeUser;
import cn.com.gome.trade.dto.openapi.aftersalesorder.AfterSalesOrdersReq;
import cn.com.gome.trade.dto.openapi.aftersalesorder.AfterSalesOrdersResp;
import cn.com.gome.trade.dto.userdto.EcpLoginUser;
import cn.com.gome.trade.dto.userdto.LoginUser;

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
                                               @NotNull(message = "user.not.login")EcpLoginUser loginUser);

    /**
     * 查询退款单详情
     * @param refundTrackId 退款单id
     * @return dto
     */
    @Export(paramNames = {"refundTrackId", "loginUser"})
    Response<RefundTrackDto> refundTrackDetailWithoutUser(Long refundTrackId,TradeUser tradeUser);

    
    /**
     * 查询退款单列表
     * @param loginUser 当前登录用户id
     * @return 分页退款单列表
     */
    Response<Paging<GomeRichRefundDto>> refundPaging(@NotNull(message = "user.not.login")EcpLoginUser loginUser,
                                                           Integer type, Long refundTrackId, Integer pageNo, Integer size,Map<String,Object> map);

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
    Response<Paging<GomeRichRefundDto>> weidianRefundPaging(@NotNull(message = "user.not.login")EcpLoginUser loginUser,
                                                     Integer type, Long refundTrackId, Long referenceId, Integer pageNo, Integer size,Map<String,Object> map);

    /**
     * 微店达人查询退款单详情
     * @param refundTrackId 退款单id
     * @return dto
     */
    @Export(paramNames = {"refundTrackId", "loginUser"})
    Response<RefundTrackDto> weidianRefundTrackDetail(@Min(value = 1L, message = "refund.track.id.invalid")Long refundTrackId,
                                               @NotNull(message = "user.not.login")EcpLoginUser loginUser);
    
    /**
     * @Description  根据订单Ids 查询所有退款单
     * @author zhangxinxing
     * @time 2016年6月20日 下午2:34:57
     * @param orderIds
     * @return
     */
    Response<List<OrderItemRefundTrack>> findRefundTrackAllByOrderIds(List<Long> orderIds);
    /**
     * @Description  根据子订单Ids 查询所有退款单
     * @author zhangxinxing
     * @time 2016年6月20日 下午2:34:57
     * @param orderItemIds
     * @return
     */
    Response<List<OrderItemRefundTrack>> findRefundTrackAllByOrderItemIds(List<Long> orderItemIds);
    
    /**
     * 开放API
     * 获取卖家的售后单列表
     * @param afterSalesOrdersReq
     * @return
     */
    Response<AfterSalesOrdersResp> getAfterSalesOrdersByOpen(AfterSalesOrdersReq afterSalesOrdersReq);
}
