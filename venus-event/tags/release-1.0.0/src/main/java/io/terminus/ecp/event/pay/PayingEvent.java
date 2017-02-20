/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.pay;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 支付事件 （用于支付前生产对应的支付信息、分期阶段信息）
 * Author: haolin
 * On: 8/27/14
 */
@Data
@AllArgsConstructor
public class PayingEvent {
    private List<Long> orderIds;    //订单id集合
    private Map<Integer,Integer> stageFees;     //分多少期 key第几期 value对应的还款金额
}
