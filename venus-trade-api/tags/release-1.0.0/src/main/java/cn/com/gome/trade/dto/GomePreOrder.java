package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.dto.PreOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by yangzefeng on 15/5/22
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GomePreOrder extends PreOrder {

    /**
     * 是否为国美在线商品
     */
    private Boolean isGome;
}
