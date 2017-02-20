/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.LogisticsInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     订单物流明细
 * </pre>
 *
 * @author wanggen on 2015-01-06.
 */
@Data
public class LogisticsDto implements Serializable {
    private static final long serialVersionUID = 5527116575194575273L;

    /** 运单号 */
    private String waybillNo;

    /**
     * 物流类型 (0. 无需物流, 1. 第三方物流[通过快递100查询], 2. 海尔物流)
     */
    private Integer logisticsType;

    /**
     * 快递公司代号
     */
    private String logisticsCode;

    /** 快递公司 */
    private String logisticsCompany;

    /**
     * {@code logisticsType} 为第三方物流(快递100), 标识是否走HTML api,
     * 若走HTML api, {@code logisticsDetail} 存放跳转的url, 否则存放 REST api 返回的json
     */
    private Boolean isSpecial;
    /**
     * {@code logisticsType} 为第三方物流(快递100), 调用HTML api 返回的 url 或调用 REST api 返回的json
     */
    private String logisticsDetail;

    /**
     * {@code logisticsType} 为海尔物流时, 存放的物流信息
     * 物流明细
     */
    private Map<String, List<LogisticsInfo>> logisticsInfos;


}
