package io.terminus.ecp.marketing.service;

import io.terminus.ecp.marketing.dto.MarketingActivityDto;
import io.terminus.ecp.marketing.model.MarketingActivity;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Desc:优惠活动的处理write服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
public interface MarketingActivityWriteService {
    /**
     * 创建优惠活动的定义
     * @param user          操作用户
     * @param activityDto   优惠活动信息
     * @return  Boolean
     * 返回优惠活动创建是否成功
     */
    public Response<Boolean> createActivity(BaseUser user, MarketingActivityDto activityDto);

    /**
     * 只有待发布状态的活动才可以被更新
     * @param user          操作用户
     * @param activityDto   优惠活动信息
     * @return Boolean
     * 返回优惠活动创建是否成功
     */
    public Response<Boolean> update(BaseUser user, MarketingActivityDto activityDto);

    /**
     * 删除活动，只有待发布状态的活动才能删除
     * @param user          操作用户
     * @param activityId    优惠活动信息
     * @return Boolean
     * 返回优惠活动删除是否成功
     */
    public Response<Boolean> delete(@NotNull(message = "user.not.login") BaseUser user,
                                    @Min(value = 1L, message = "activity.def.id.invalid") Long activityId);

    /**
     * 发布活动，只有待发布状态的活动才可以进行发布
     * @param user          当前登录用户
     * @param activityId    活动ID
     * @return  Boolean
     * 返回活动发布是否成功
     */
    public Response<Boolean> release(@NotNull(message = "user.not.login")BaseUser user,
                                     @Min(value = 1L, message = "activity.def.id.invalid")Long activityId);

    /**
     * 停止活动，只有已发布和活动开始的数据可以被停止
     * @param user          当前登录用户
     * @param activityId    活动编号
     * @return  Boolean
     * 返回活动停止是否成功
     */
    public Response<Boolean> stop(@NotNull(message = "user.not.login")BaseUser user,
                                  @Min(value = 1L, message = "activity.def.id.invalid")Long activityId);

    /**
     * 创建优惠活动的事件定义
     * @param user          创建人
     * @param activityDto   优惠活动
     * @return  Boolean
     * 返回活动创建结果
     */
    public Response<Boolean> createActEvent(BaseUser user, MarketingActivityDto activityDto);

    /**
     * 创建优惠活动的事件定义
     * @param user          创建人
     * @param activityDto   优惠活动
     * @return  Boolean
     * 返回活动创建结果
     */
    public Response<Boolean> updateActEvent(BaseUser user, MarketingActivityDto activityDto);

    /**
     * 更改事件活动状态
     * @param user          当前登录用户
     * @param activityId    活动编号
     * @return  Boolean
     * 返回状态更改是否成功
     */
    public Response<Boolean> updateActStatus(BaseUser user, Long activityId, Integer status);

    /**
     * 依据活动类型的type获取有效的活动
     * @param startAt   开始时间
     * @param endAt     结束时间
     * @return  MarketingActivity
     * 返回有效的活动
     */
    public Response<MarketingActivity> validActEvent(Integer actType, Date startAt, Date endAt);

    /**
     * 自动更新状态（job使用）
     */
    public Response<Boolean> autoUpdateStatus();
}
