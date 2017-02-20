package io.terminus.ecp.trade.dto.club;

import io.terminus.ecp.item.model.Item;
import io.terminus.ecp.shop.model.Shop;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangzefeng on 15/1/4
 */
@Data
public class HotItems implements Serializable {
    private static final long serialVersionUID = -1525621215734302530L;

    private Shop shop;

    private List<Item> items;

    private Long buyCount;   //登录用户所属公司在该店铺购买的商品数量
}
