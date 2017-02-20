package io.terminus.ecp.marketing.service.promo;

import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.model.promo.PromoDefinition;
import io.terminus.ecp.marketing.model.promo.PromoUsage;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

/**
 * Desc: 优惠码服务
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/18/15.
 */
public interface PromoService {
    /**
     * 创建优惠码信息
     * @param user              操作用户
     * @param promoDefinition   优惠码定义
     * @return  Boolean
     * 返回优惠码创建结果
     */
    public Response<Boolean> createPromo(BaseUser user, PromoDefinition promoDefinition);

    /**
     * 更新优惠码信息
     * @param user              操作用户
     * @param promoDefinition   优惠码更改信息
     * @return  Boolean
     * 返回更改是否成功
     */
    public Response<Boolean> updatePromo(BaseUser user, PromoDefinition promoDefinition);

    /**
     * 删除优惠码信息
     * @param user              操作用户
     * @param promoId           优惠码编号
     * @return  Boolean
     * 返回删除是否成功
     */
    public Response<Boolean> deletePromo(BaseUser user, Long promoId);

    /**
     * 更新优惠码状态
     * @param user      操作用户
     * @param promoId   优惠码编号
     * @param status    需要切换的状态
     * @return  Boolean
     * 返回状态切换是否成功
     */
    public Response<Boolean> changePromoStatus(BaseUser user, Long promoId, Integer status);

    /**
     * 依据参数查询具体的优惠码的定义数据，返回定义列表
     * @param user      优惠码创建人
     * @param type      类型
     * @param startAt   开始时间
     * @param endAt     结束时间
     * @param status    状态
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @return Paging
     * 返回优惠码定义信息
     */
    @Export(paramNames = {"user", "type", "startAt", "endAt", "status", "pageNo", "pageSize"})
    public Response<Paging<PromoDefinition>> queryPromoByParams(BaseUser user, Integer type, String startAt,
                                                                String endAt, Integer status, Integer pageNo, Integer pageSize);

    /**
     * 使用优惠码
     * @param buyer     卖家
     * @param promoId   优惠码编号
     * @return  Boolean
     * 返回使用优惠码是否成功
     */
    public Response<Boolean> usePromoNum(BaseUser buyer, Long promoId);

    /**
     * 依据优惠码获取优惠码定义信息
     * @param promoNum  优惠码
     * @return  PromoDefinition
     * 返回优惠码定义数据
     */
    public Response<PromoDefinition> queryPromoDef(String promoNum);

    /**
     * 创建优惠码使用记录
     * @param promoUsage    优惠码使用记录
     * @return  Boolean
     * 返回优惠编码创建结果
     */
    public Response<Boolean> createPromoUsage(PromoUsage promoUsage);

    /**
     * 查询该优惠码该用户的使用记录
     * @param buyerId   买家
     * @param promoId   优惠码编号
     * @return  PromoUsage
     * 返回使用记录
     */
    public Response<PromoUsage> queryPromoUsage(Long buyerId, Long promoId);

    /**
     * 买家获取优惠码使用记录
     * @param user      用户
     * @param type      优惠码类型
     * @param startAt   有效开始时间
     * @param endAt     有效结束时间
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @return  Paging
     * 返回优惠码使用记录列表
     */
    @Export(paramNames = {"user", "type", "startAt", "endAt", "pageNo", "pageSize"})
    public Response<Paging<PromoUsage>> queryUsageByBuyer(BaseUser user, Integer type, String startAt,
                                                          String endAt, Integer pageNo, Integer pageSize);

    /**
     * 卖家查询优惠码使用记录
     * @param user          用户
     * @param promoDefId    优惠码定义
     * @param type          优惠码类型
     * @param shopId        店铺编号
     * @param startAt       有效开始时间
     * @param endAt         有效结束时间
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回优惠码使用记录列表
     */
    public Response<Paging<PromoUsage>> queryUsageByCreator(BaseUser user, Long promoDefId, Integer type, Long shopId, String startAt,
                                                            String endAt, Integer pageNo, Integer pageSize);
}
