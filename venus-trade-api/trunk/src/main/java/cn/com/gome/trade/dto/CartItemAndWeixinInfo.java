package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.dto.CartItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by yangzefeng on 15/4/23
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class CartItemAndWeixinInfo extends CartItem implements Serializable {

    private static final long serialVersionUID = -7675490077680589920L;

    private String weixinInfo;

    /**
     * 直降价
     */
    private Integer discountPrice;
    
    private String sourceCode;//商品来源
}
