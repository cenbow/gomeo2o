package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.dto.FatOrder;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by yangzefeng on 15/5/22
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GomeFatOrder extends FatOrder implements Serializable  {

    private static final long serialVersionUID = 3568768558369045469L;

    private Boolean isGome;

    /**
     * 配送信息
     */
    private String remark;
    
    private Integer shopType;
    
    private String outerShopId;
    
    //订单总价
    private Integer totalMoney;
}
