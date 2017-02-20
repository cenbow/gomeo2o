package cn.com.gome.trade.service;

import cn.com.gome.trade.dto.GomeOrderDetailWithActions;
import io.terminus.ecp.trade.service.TradeReadService;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Desc:
 * Mail: F@terminus.io
 * Data: 15/6/15
 * Author: yangzefeng
 */
public interface GomeTradeReadService extends TradeReadService {

    /**
     * 订单详情页
     * @param loginer 登录用户
     * @param orderId 订单id
     * @return 订单详情
     */
    @Export(paramNames = {"loginer", "orderId"})
    Response<GomeOrderDetailWithActions> gomeViewOrder(LoginUser loginer,
                                            @Min(value = 1L, message = "order.id.invalid")
                                            @NotNull(message = "order.id.invalid")
                                            Long orderId);
}
