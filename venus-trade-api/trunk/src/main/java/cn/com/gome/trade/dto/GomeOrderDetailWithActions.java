package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderDiscountDetail;
import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderTrack;
import io.terminus.ecp.trade.model.flow.OrderActionInstance;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import cn.com.gome.trade.dto.itemdto.Sku;

/**
 * Desc:
 * Mail: F@terminus.io
 * Data: 15/6/15
 * Author: yangzefeng
 */
@Data
public class GomeOrderDetailWithActions implements Serializable {
    private static final long serialVersionUID = 5972825314704748144L;

    /**
     * 订单
     */
    private Order order;

    /**
     * 订单状态
     */
    private OrderTrack orderTrack;

    /**
     * 订单附加信息
     */
    private OrderExtra tradeInfo;

    /**
     * actionInstance ID
     */
    private List<OrderActionInstance> actionInstances;

    /**
     * 子订单和sku dto
     */
    private List<OrderItemAndSku> orderItemAndSkus;

    @Data
    public static class OrderItemAndSku implements Serializable {

        private static final long serialVersionUID = 2219026401993545708L;

        /**
         * 子订单
         */
        private OrderItem orderItem;

        /**
         * sku
         */
        private Sku sku;
    }

    private List<OrderDiscountDetail> orderDiscountDetailList;
}
