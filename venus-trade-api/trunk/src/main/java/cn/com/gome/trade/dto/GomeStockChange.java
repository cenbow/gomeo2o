package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.dto.StockChange;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Mail: F@terminus.io
 * Data: 15/6/3
 * Author: yangzefeng
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GomeStockChange extends StockChange implements Serializable {
    private static final long serialVersionUID = -5316024821916785257L;

    private String wechatShopId;

    private String kid;
}
