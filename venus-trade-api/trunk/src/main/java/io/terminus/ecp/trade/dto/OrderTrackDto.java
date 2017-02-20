package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderTrack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 功能描述: 订单状态DTO
 *  1. 订单
 *  2. List: 子订单
 *  3. 订单配送
 *  4. 订单状态
 * </pre>
 *
 * @author wanggen on 14/11/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTrackDto implements Serializable {
    private static final long serialVersionUID = 1605707960920913155L;

    /** 订单 **/
    private Order order;

    /** 子订单 **/
    private List<OrderItem>         orderItems;

    /** 订单配送信息 **/
    private Map                     tradeInfo;

    /** 发票信息  **/
    private Map                     invoice;

    /** 订单状态 **/
    private OrderTrack orderTrack;

}
