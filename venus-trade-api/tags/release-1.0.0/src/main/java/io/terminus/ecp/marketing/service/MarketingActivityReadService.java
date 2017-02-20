package io.terminus.ecp.marketing.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.dto.MarketingActivityDto;
import io.terminus.ecp.marketing.model.MarketingActivity;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.util.Map;

/**
 * Desc:优惠活动的处理read服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
public interface MarketingActivityReadService {
    /**
     * 根据用户权限查询对应的活动信息
     * @param user          用户
     * @param name          活动名称
     * @param toolId        工具编号
     * @param eventType     活动事件类型(null:显示非营销活动的全部活动)
     * @param activityType  创建活动的用户类型
     * @param startTime     开始开始时间
     * @param endTime       活动结束时间
     * @param status        活动状态
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回活动信息
     */
    @Export(paramNames = {"user", "name", "toolId", "eventType", "activityType", "startTime", "endTime", "status", "pageNo", "pageSize"})
    public Response<Paging<MarketingActivity>> queryByParams(BaseUser user , String name, Long toolId, Integer eventType, Integer activityType,
                                                             String startTime, String endTime, Integer status, Integer pageNo, Integer pageSize);

    /**
     * 根据活动编号查询具体的活动数据信息
     * @param activityId    活动数据编号
     * @return  MarketingActivityDto
     * 返回活动数据
     */
    @Export(paramNames = {"activityId"})
    public Response<MarketingActivityDto> queryDetailById(Long activityId);

    /**
     * 查询详细的活动信息
     * @param user          用户
     * @param name          活动名称
     * @param toolId        工具编号
     * @param eventType     用户类型
     * @param activityType  创建活动的用户类型
     * @param startTime     开始开始时间
     * @param endTime       活动结束时间
     * @param status        活动状态
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回活动信息
     */
    @Export(paramNames = {"user", "name", "toolId", "eventType", "activityType", "startTime", "endTime", "status", "pageNo", "pageSize"})
    public Response<Paging<MarketingActivityDto>> queryDetailByParams(BaseUser user , String name, Long toolId, Integer eventType, Integer activityType,
                                                                      String startTime, String endTime, Integer status, Integer pageNo, Integer pageSize);
}
