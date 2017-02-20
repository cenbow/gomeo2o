package io.terminus.ecp.marketing.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.dto.ActivityLogDto;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

/**
 * Desc:优惠日志的读取服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-09.
 */
public interface MarketingLogReadService {
    /**
     * 获取所有的优惠日志信息
     * @param user          当前用户
     * @param activityId    活动编号
     * @param orderType     订单类型（1:总订单，2:子订单）
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回全部可用的工具模版
     */
    @Export(paramNames = {"user", "activityId", "orderType", "pageNo", "pageSize"})
    public Response<Paging<ActivityLogDto>> queryByParams(BaseUser user, Long activityId, Integer orderType, Integer pageNo, Integer pageSize);

    /**
     * 获取所有的优惠日志信息
     * @param activityId    活动编号
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回全部可用的工具模版
     */
    @Export(paramNames = {"activityId", "pageNo", "pageSize"})
    public Response<Paging<ActivityLogDto>> queryAllTools(Long activityId, Integer pageNo, Integer pageSize);
}
