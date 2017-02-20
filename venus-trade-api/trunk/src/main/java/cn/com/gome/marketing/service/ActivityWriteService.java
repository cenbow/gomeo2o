package cn.com.gome.marketing.service;

import cn.com.gome.marketing.model.TimeDownActivity;
import cn.com.gome.marketing.model.TimeDownItem;
import io.terminus.ecp.marketing.service.MarketingActivityWriteService;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.util.Date;
import java.util.List;

/**
 * Desc:活动写入管理
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-24.
 */
public interface ActivityWriteService extends MarketingActivityWriteService {
    /**
     * 校验店铺是否被冻结
     * @param user          操作用户
     * @return Boolean
     * 返回店铺是否被冻结
     */
    public Response<Boolean> validateFreeze(BaseUser user);
    /**
     * 创建直降活动优惠
     * @param user          操作用户
     * @param timeDownActivity   优惠活动信息
     * @return  Long
     * 返回活动编号
     */
    public Response<Long> createTimeDown(BaseUser user, TimeDownActivity timeDownActivity);

    /**
     * 只有待发布状态的活动才可以被更新
     * @param user          操作用户
     * @param timeDownActivity   优惠活动信息
     * @return Boolean
     * 返回活动更改是否成功
     */
    public Response<Boolean> updateTimeDown(BaseUser user, TimeDownActivity timeDownActivity);

    /**
     * 异步创建活动规则
     * @param user          操作用户
     * @param activityId    活动编号
     * @param timeDownItem  直降活动
     * @return  Boolean
     * 返回创建规则数据是否成功
     */
    public Response<Boolean> createToolData(BaseUser user, Long activityId, TimeDownItem timeDownItem);

    /**
     * 异步更改活动规则
     * @param user          操作用户
     * @param activityId    活动编号
     * @param timeDownItem  直降活动
     * @return  Boolean
     * 返回更改规则数据是否成功
     */
    public Response<Boolean> updateToolData(BaseUser user, Long activityId, TimeDownItem timeDownItem);

    /**
     * 直降活动延期操作
     * @param user          操作用户
     * @param activityId    活动编号
     * @param deferStartDate 延期开始时间点
     * @param deferEndDate   延期结束时间点
     * @return  Boolean
     * 返回更改是否成功
     */
    public Response<Boolean> deferActivity(BaseUser user, Long activityId, Date deferStartDate, Date deferEndDate);

    /**
     * 批量创建更改活动规则
     * @param user          操作用户
     * @param activityId    活动编号
     * @param timeDownItems 直降活动
     * @return  Boolean
     * 返回创建更改规则数据是否成功
     */
    public Response<Boolean> batchCreateAndUpdate(BaseUser user, Long activityId, List<TimeDownItem> timeDownItems);

    /**
     * 异步删除活动规则
     * @param user          操作用户
     * @param toolDataId    工具数据编号
     * @return  Boolean
     * 返回删除规则数据是否成功
     */
    public Response<Boolean> deleteToolData(BaseUser user, Long toolDataId);
    
    /**
     * 冻结指定店铺的活动
     * @param shopId 店铺Id
     * @return Boolean
     * 返回冻结店铺活动是否成功
     */
    public Response<Boolean> freezeShopsActivities(Long shopId);
    
    /**
     * 解冻指定店铺的活动
     * @param shopId 店铺Id
     * @return Boolean
     * 返回解冻店铺活动是否成功
     */
    public Response<Boolean> unfreezeShopsActivities(Long shopId);
    
}
