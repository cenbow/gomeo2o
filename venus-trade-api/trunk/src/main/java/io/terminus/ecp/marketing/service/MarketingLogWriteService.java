package io.terminus.ecp.marketing.service;

import io.terminus.ecp.marketing.model.MarketingActivityLog;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Desc:优惠日志的写服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-09.
 */
public interface MarketingLogWriteService {
    /**
     * 创建活动日志
     * @param activityLogList   活动日志
     * @return  Boolean
     * 返回日志创建是否成功
     */
    public Response<Boolean> createLogs(List<MarketingActivityLog> activityLogList);
}
