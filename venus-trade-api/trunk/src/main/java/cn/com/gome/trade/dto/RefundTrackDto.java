package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.dto.SkuAndItem;
import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangzefeng on 15/5/21
 */
@Data
public class RefundTrackDto implements Serializable {

    private static final long serialVersionUID = -8876560970691016258L;

    private Order order;

    private List<OrderItem> orderItemList;

    private OrderItemRefundTrack orderItemRefundTrack;

    private OrderExtra orderExtra;

    private List<SkuAndItem> skuAndItems;
}
