package cn.com.gome.marketing.service;

import cn.com.gome.marketing.model.TimeDownActivity;
import cn.com.gome.marketing.model.TimeDownItem;
import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.service.MarketingActivityReadService;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

/**
 * Desc:活动读取服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-24.
 */
public interface ActivityReadService extends MarketingActivityReadService {

    /**
     * 查询直降活动信息
     * @param user          用户
     * @param name          活动名称
     * @param activityType  创建活动的用户类型
     * @param itemId        商品编号
     * @param startTime     开始开始时间
     * @param endTime       活动结束时间
     * @param status        活动状态
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回活动信息
     */
    @Export(paramNames = {"user", "name", "activityType", "itemId", "startTime", "endTime", "status", "pageNo", "pageSize"})
    public Response<Paging<TimeDownActivity>> queryTimeDown(BaseUser user , String name, Integer activityType, Long itemId,
                                                            String startTime, String endTime, Integer status, Integer pageNo, Integer pageSize);

    /**
     * 查询详细的直降活动信息
     * @param activityId    活动编号
     * @return  TimeDownActivity
     * 获取直降活动详细信息
     */
    @Export(paramNames = {"activityId"})
    public Response<TimeDownActivity> queryTimeDownById(Long activityId);

    /**
     * 查询直降活动的规则数据
     * @param activityId    活动编号
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回规则信息数据
     */
    @Export(paramNames = {"activityId", "pageNo", "pageSize"})
    public Response<Paging<TimeDownItem>> queryTimeDownRules(Long activityId, Integer pageNo, Integer pageSize);

    /**
     * 国美依据卖家编号查询直降商品
     * @param sellerId      卖家编号
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回规则信息数据
     */
    @Export(paramNames = {"sellerId", "pageNo", "pageSize"})
    public Response<Paging<TimeDownItem>> queryTimeDownByShopId(Long sellerId, Integer pageNo, Integer pageSize);
}
