package cn.com.gome.trade.dto;

import io.terminus.ecp.item.model.Sku;
import io.terminus.ecp.trade.dto.SkuAndItem;
import io.terminus.ecp.trade.model.OrderItemRefundTrack;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Mail: F@terminus.io
 * Data: 15/5/30
 * Author: yangzefeng
 * Desc: 退款单列表页数据结构
 */
@Data
public class GomeRichRefundDto implements Serializable {
    private static final long serialVersionUID = 8072251148474618551L;

    private OrderItemRefundTrack orderItemRefundTrack;

    private List<OrderItemDto> orderItemDtos;
}
