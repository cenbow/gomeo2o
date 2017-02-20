/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 订单详细, 创建订单时使用
 * Created by yangzefeng on 14-9-11
 */
@Data
public class FatOrder implements Serializable {

    private static final long serialVersionUID = -1057065211108186810L;

    /**
     * 卖家id
     */
    private Long sellerId;

    /**
     * 参加的店铺活动id
     */
    private Long shopActivityId;

    /**
     * 买家留言
     */
    private String buyerNotes;

    /**
     * 发票信息
     */
    private String invoice;

    /**
     * 支付类型
     * @see io.terminus.ecp.trade.enums.PaidType
     */
    private Integer payType;

    /**
     * 是否需要结算
     */
    private Boolean needSettle;

    /**
     * skuId以及sku对应的一些信息，如数量，阶段价格
     */
    private List<SkuIdAndInfo> skuIdAndInfos;

    /**
     * 订单来源
     */
    private String reference;

    /**
     * 来源id
     */
    private String referenceId;

    /**
     * 是否分批发送
     */
    private Boolean batchDeliver;

    /**
     * 营销活动的一些参数
     */
    private Map<String, Object> marketingParams;
}
