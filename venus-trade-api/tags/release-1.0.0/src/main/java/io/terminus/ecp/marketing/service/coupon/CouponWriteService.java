package io.terminus.ecp.marketing.service.coupon;

import io.terminus.ecp.marketing.model.coupon.CouponDefinition;
import io.terminus.ecp.marketing.model.coupon.CouponUsage;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Desc:优惠券写操作
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-05.
 */
public interface CouponWriteService {
    /**
     * 创建优惠券定义
     *
     * @param couponDefinition 优惠券定义对象
     * @return 新创建对象的id
     */
    Response<Long> create(@NotNull(message = "coupon.def.invalid") CouponDefinition couponDefinition);

    /**
     * 批量创建优惠券定义
     *
     * @param couponDefinitions 优惠券定义列表
     * @return 新创建对应id列表
     */
    Response<List<Long>> batchCreate(@NotNull(message = "coupon.def.invalid")
                                     List<CouponDefinition> couponDefinitions);

    /**
     * 修改优惠券定义，只有未发布的优惠券才能修改
     *
     * @param couponDefinition 待修改的券定义对象
     * @return 操作是否成功
     */
    Response<Boolean> update(@NotNull(message = "coupon.def.invalid") CouponDefinition couponDefinition,
                             @NotNull(message = "user.not.login") BaseUser loginer);

    /**
     * 删除优惠券，只有未发布的优惠券能删除，删除是物理删除
     *
     * @param couponDefId 优惠券定义id
     * @return 操作是否成功
     */
    Response<Boolean> delete(@Min(value = 1L, message = "coupon.def.id.invalid") Long couponDefId,
                             @NotNull(message = "user.not.login") BaseUser loginer);

    /**
     * 发布优惠券，只有未发布的优惠券能发布，发布后判断是否生效
     *
     * @param couponDefId 优惠券定义id
     * @return 操作是否成功
     */
    Response<Boolean> release(@Min(value = 1L, message = "coupon.def.id.invalid") Long couponDefId,
                              @NotNull(message = "user.not.login") BaseUser loginer);

    /**
     * 优惠券自动生效，只有发布了的优惠券才能生效
     *
     * @param couponDefId 优惠券定义id
     * @return 操作是否成功
     */
    Response<Boolean> autoActive(@Min(value = 1L, message = "coupon.def.id.invalid") Long couponDefId);

    /**
     * 优惠券自动超时失效，只有生效了的优惠券才会失效
     *
     * @param couponDefId 优惠券定义id
     * @return 操作是否成功
     */
    Response<Boolean> autoExpire(@Min(value = 1L, message = "coupon.def.id.invalid") Long couponDefId);



    /*******************************************        优惠券使用        *****************************************/

    /**
     * 创建优惠券使用记录
     *
     * @param couponUsage 优惠券使用信息
     * @return 是否成功
     */
    public Response<Boolean> createCouponUsage(CouponUsage couponUsage);

    /**
     * 使用优惠券(买家优惠券数量减quantity) & 更新券定义中已使用数量
     * @param userId      买家id
     * @param couponDefId 优惠券id
     * @param quantity    使用数量
     * @return 是否成功
     */
    public Response<Boolean> consumerCoupon(Long userId, Long couponDefId, Integer quantity);

    /**
     * 撤销优惠券的使用（退还优惠券给用户，优惠券是否能够退回由订单状态决定:待付款,）
     * @param orderId   订单编号
     * @return  Boolean
     * 是否成功
     */
    public Response<Boolean> revokeCoupon(Long orderId);

    /**
     * 自动检查并更新优惠券状态(job调用)
     * @return Boolean
     * 是否成功
     */
    public Response<Boolean> autoUpdateStatus();


    /**
     * 停发优惠券
     *
     * @param couponDefId 优惠券id
     * @param baseUser    当前登录用户
     * @return 是否成功
     */
    public Response<Boolean> stop(Long couponDefId, BaseUser baseUser);

    /**
     * 买家领取优惠券
     * @param user                  买家对象
     * @param couponDefinitionId    优惠券编号
     * @return  Boolean
     * 返回优惠券领取结果
     */
    public Response<Boolean> bindingCoupon(BaseUser user, Long couponDefinitionId);

    /**
     * 自动赠送优惠券
     * @param userIds 赠送人编号集合
     * @param couponDefinitionId 优惠劵定义ID
     * @param num 数量
     * @return  Boolean
     * 返回自动赠送是否成功
     */
    Response<Boolean> autoSendCoupon(List<Long> userIds, Long couponDefinitionId, Integer num);

    /**
     * 赠送优惠券
     * @param nick      昵称
     * @param mobile    手机
     * @param email     邮箱
     * @param couponDefinitionId    优惠券定义Id
     * @param num                   数量
     * @return  Boolean
     * 返回自动赠送是否成功
     */
    public Response<Boolean> autoSendCoupon(String nick, String mobile, String email, Long couponDefinitionId, Integer num);


    /*******************************************        优惠券编码        *****************************************/
    /**
     * 创建优惠券编码
     * @param couponDefId   优惠券定义
     * @param numCount      需要生成编码的数量
     * @return  Boolean
     * 返回生成是否成功
     */
    public Response<Boolean> createCouponNum(Long couponDefId, Integer numCount);

    /**
     * 绑定优惠券到用户账户下
     * @param user          当前用户
     * @param couponNum     优惠券码
     * @return  Boolean
     * 返回绑定是否成功
     */
    public Response<Boolean> bindCoupon(BaseUser user, String couponNum);
}
