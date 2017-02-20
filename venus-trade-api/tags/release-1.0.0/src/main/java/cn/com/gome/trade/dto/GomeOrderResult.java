package cn.com.gome.trade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Mail: F@terminus.io
 * Data: 15/6/3
 * Author: yangzefeng
 */
@Data
public class GomeOrderResult implements Serializable {
    private static final long serialVersionUID = -8678409985447849237L;

    List<GomeStockChange> stockChanges;
}
