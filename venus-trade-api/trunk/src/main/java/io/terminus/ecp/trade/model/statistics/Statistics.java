package io.terminus.ecp.trade.model.statistics;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yangzefeng on 15/1/30
 */
@Data
public class Statistics implements Serializable {
    private static final long serialVersionUID = -7129184826558582224L;

    private Long id;

    /**
     * 每日新增商品数量
     */
    private Integer itemIncrement;

    /**
     * 每日新上架商品数
     */
    private Integer onShelfItem;

    /**
     * 每日新增品牌数量
     */
    private Integer brandIncrement;

    /**
     * 每日新增店铺数量
     */
    private Integer shopIncrement;

    /**
     * 每日有成交的商品总数
     */
    private Integer buyItem;

    /**
     * 每日有成交的店铺总数
     */
    private Integer buyShop;

    /**
     * 每日有成交的品牌数
     */
    private Integer buyBrand;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}
