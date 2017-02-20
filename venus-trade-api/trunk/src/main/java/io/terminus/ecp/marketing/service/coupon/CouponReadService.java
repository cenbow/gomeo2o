//package io.terminus.ecp.marketing.service.coupon;
//
//import io.terminus.common.model.Paging;
//import io.terminus.ecp.marketing.dto.coupon.BuyerCouponDto;
//import io.terminus.ecp.marketing.dto.coupon.RichCouponDto;
//import io.terminus.ecp.marketing.model.coupon.Coupon;
//import io.terminus.ecp.marketing.model.coupon.CouponDefinition;
//import io.terminus.ecp.marketing.model.coupon.CouponGrant;
//import io.terminus.ecp.marketing.model.coupon.CouponUsage;
//import io.terminus.ecp.marketing.model.coupon.ShopCoupon;
//import io.terminus.pampas.client.Export;
//import io.terminus.pampas.common.BaseUser;
//import io.terminus.pampas.common.Response;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//
//import cn.com.gome.trade.dto.userdto.EcpLoginUser;
//
///**
// * Desc:优惠券读操作
// * Mail:v@terminus.io
// * author:Michael Zhao
// * Date:2015-05-05.
// */
//public interface CouponReadService {
//    /**
//     * 根据优惠券id查询
//     *
//     * @param couponDefId 优惠券id
//     * @return 优惠券定义
//     */
//    @Export(paramNames = {"couponDefId"})
//    Response<CouponDefinition> findById(@Min(value = 1L, message = "coupon.def.id.invalid") Long couponDefId);
//
//    /**
//     * 根据优惠券id列表查询
//     *
//     * @param couponDefIds 优惠券id列表
//     * @return 优惠券列表
//     */
//    Response<List<CouponDefinition>> findCouponDefByIds(List<Long> couponDefIds);
//
//    /**
//     * 根据商品id列表查询
//     *
//     * @param itemIds 商品id列表
//     * @return 优惠券列表
//     */
//    Response<List<CouponDefinition>> findCouponDefByItemIds(List<Long> itemIds);
//
//    /**
//     * 优惠券分页查询
//     *
//     * @param user          操作用户
//     * @param couponName    优惠券名称
//     * @param discountAt    面值
//     * @param discountTo    面值
//     * @param startAt       开始时间(相对于发布时间而言)
//     * @param endAt         结束时间
//     * @param type          类型(1:商家优惠券， 2:平台优惠券)
//     * @param limitType     全部券的数量（1:不限制优惠券数量，2:限定优惠券数量）
//     * @param status        状态
//     * @param pageNo        页码
//     * @param size          大小
//     * @return 分页的优惠券定义
//     */
//    @Export(paramNames = {"user", "couponName", "discountAt", "discountTo", "startAt", "endAt", "type", "limitType", "status", "pageNo", "size"})
//    Response<Paging<CouponDefinition>> couponDefPaging(BaseUser user, String couponName, Integer discountAt, Integer discountTo,
//                                                       String startAt, String endAt, Integer type, Integer limitType, Integer status, Integer pageNo, Integer size);
//
//    /**
//     * 查询系统发布的优惠券
//     *
//     * @param type     类型(1:商家优惠券， 2:平台优惠券， null：展示全部)
//     * @param shopId   店铺编号
//     * @param couponChannel 优惠券渠道号 
//     * @param pageNo   页码
//     * @param size     大小
//     * @return  Paging
//     */
//    @Export(paramNames = {"type" , "shopId", "pageNo", "size"})
//    public Response<Paging<CouponDefinition>> queryCouponDef(Integer type, Long shopId, Long couponChannel,Integer pageNo, Integer size);
//
//    /**
//     * 查找某个商品的生效优惠券，同一时间应该只有一条记录
//     *
//     * @param itemId 商品id
//     * @return 优惠券定义
//     */
//    Response<CouponDefinition> findEffectItemCouponDef(@Min(value = 1l, message = "item.id.invalid") Long itemId);
//
//    /**
//     * 查询发布优惠券的店铺列表
//     *
//     * @param type      类型(1:商家优惠券， 2:平台优惠券， null：展示全部)
//     * @param pageNo   页码
//     * @param size     大小
//     * @return  Paging
//     */
//    @Export(paramNames = {"type" , "pageNo", "size"})
//    public Response<Paging<ShopCoupon>> findCouponShop(Integer type, Integer pageNo, Integer size);
//
//    /**
//     * 查询店铺下优惠额度最大的优惠券
//     * @param shopId    店铺编号
//     * @return  CouponDefinition
//     * 返回优惠券详情
//     */
//    @Export(paramNames = {"shopId"})
//    public Response<CouponDefinition> findMostDiscount(Long shopId);
//
//
//    /*******************************************        优惠券使用        *****************************************/
//    /**
//     * 查找某个用户持有有效商品券的情况
//     *
//     * @param userId 用户id
//     * @param itemId 商品id
//     * @return 持有情况
//     */
//    public Response<Coupon> findEffectUserCoupon(@Min(value = 1l, message = "user.id.invalid") Long userId,
//                                                 @Min(value = 1l, message = "item.id.invalid") Long itemId);
//
//    /**
//     * 查找某个用户在拥有某个商家的优惠券情况
//     * @param sellerId  商家编号
//     * @param userId    用户编号
//     * @return  List
//     * 返回优惠券信息
//     */
//    public Response<List<Coupon>> findBySellerCoupons(Long sellerId, Long userId);
//
//    /**
//     * 根据订单信息查询店铺可用的优惠券
//     *
//     * @param buyerId  买家id
//     * @param type     优惠券类型（1:商家优惠券，2:平台优惠券，null:显示全部优惠券）
//     * @param shopId   店铺
//     * @param total    订单总额
//     * @param quantity 商品件数
//     * @return 优惠券信息
//     */
//    public Response<List<BuyerCouponDto>> findUsefulCouponBy(Long buyerId, Integer type, Long shopId, Integer total, Integer quantity);
//
//    /**
//     * 根据买家id和券id查找优惠券信息
//     *
//     * @param userId      买家id
//     * @param couponDefId 优惠券id
//     * @return 优惠券信息
//     */
//    public Response<Coupon> findCouponByUserIdAndCouponDefId(Long userId, Long couponDefId);
//
//    /**
//     * 分页查询买家的优惠券
//     *
//     * @param baseUser 当前登录买家
//     * @param pageNo   页码
//     * @param size     大小
//     * @return 优惠券信息
//     */
//    @Export(paramNames = {"baseUser", "pageNo", "size"})
//    public Response<Paging<RichCouponDto>> pagingCoupon(BaseUser baseUser, Integer pageNo, Integer size);
//
//    /**
//     * 计算砍价商品的优惠金额
//     *
//     * @param userId   用户id
//     * @param itemId   商品id
//     * @param price    优惠前的金额
//     * @param quantity 购买数量,当活动列表也调用时，quantity一直为1
//     * @return 可以优惠的金额
//     */
//    public Response<Integer> getBargainDiscount(@Min(value = 1l, message = "user.id.invalid") Long userId,
//                                                @Min(value = 1l, message = "item.id.invalid") Long itemId,
//                                                @NotNull(message = "item.price.invalid") Integer price,
//                                                @NotNull Integer quantity);
//
//    /**
//     * 根据订单id查询该订单的优惠券使用记录
//     *
//     * @param orderId 订单id
//     * @return 优惠券使用列表
//     */
//    Response<List<CouponUsage>> findCouponUsagesByorderId(@Min(value = 1l, message = "order.id.invalid") Long orderId);
//
//    /**
//     * 获取用户未过期的优惠券数量
//     *
//     * @param userId 用户id
//     * @return 未过期的优惠券数量
//     */
//    public Response<Long> getRemainQuantityByUserId(Long userId);
//
//    /**
//     * 获取用户未过期的优惠券总优惠金额
//     *
//     * @param userId 用户id
//     * @return 未过期的优惠券总优惠金额
//     */
//    public Response<Long> getRemainTotalDiscountByUserId(Long userId);
//
//    /**
//     * 判断当前用户是否有指定商家的优惠券
//     * @param loginUser 当前用户
//     * @param shopId 店铺id
//     * @return 是否有优惠券
//     */
//    @Export(paramNames = {"loginUser", "shopId"})
//    Response<Boolean> checkUserCoupon(@NotNull(message = "user.not.login") EcpLoginUser loginUser,
//                                      @Min(value = 1l, message = "shop.id.invalid") Long shopId);
//
//    /**
//     * 查询发送的优惠券信息
//     * @param loginUser 当前用户（运营｜商家）
//     * @param type      优惠券类型（1:商家优惠券， 2:平台优惠券）
//     * @param pageNo    当前页
//     * @param size      分页数量
//     * @return  Coupon
//     * 返回优惠券分页数据
//     */
//    @Export(paramNames = {"loginUser", "type", "pageNo", "size"})
//    Response<Paging<Coupon>> queryCoupons(EcpLoginUser loginUser, Integer type, Integer pageNo, Integer size);
//
//    /**
//     * 根据券id查找当前用户的优惠券信息
//     *
//     * @param baseUser 买家
//     * @param couponId 券id
//     * @return 优惠券信息
//     */
//    @Export(paramNames = {"baseUser","couponId"})
//    public Response<Coupon> findCouponByCouponId(BaseUser baseUser, Long couponId);
//
//
//    /*******************************************        优惠券编码        *****************************************/
//
//    /**
//     * 获取优惠券码信息(优惠券发起人)
//     * @param couponDefId   优惠券定义编号
//     * @param receiveType   优惠券领取类型（1:发放，2:领取）
//     * @param status        状态
//     * @param pageNo        页码
//     * @param size          大小
//     * @return  Paging
//     * 返回优惠券码信息
//     */
//    @Export(paramNames = {"couponDefId", "receiveType", "status", "pageNo", "size"})
//    public Response<Paging<CouponGrant>> findCouponNumByDefId(Long couponDefId, Integer receiveType, Integer status, Integer pageNo, Integer size);
//
//    /**
//     * 获取优惠券码信息(优惠券拥有者)
//     * @param user          优惠券拥有者
//     * @param couponDefId   优惠券定义编号(NULL：显示全部)
//     * @param receiveType   优惠券领取类型（1:发放，2:领取）
//     * @param status        状态
//     * @param pageNo        页码
//     * @param size          大小
//     * @return  Paging
//     * 返回优惠券码信息
//     */
//    @Export(paramNames = {"user", "couponDefId", "receiveType", "status", "pageNo", "size"})
//    public Response<Paging<CouponGrant>> findCouponNumByBuyer(BaseUser user, Long couponDefId, Integer receiveType, Integer status, Integer pageNo, Integer size);
//    
//    
//    /**
//     * 
//     * @Description 根据用户id和订单的商家id和订单金额查询用户可用的优惠券包括平台券 
//     * @author wangjiatian
//     * @date 2016年6月7日 下午3:06:38
//     * @param buyerId
//     * @param shopIdAndMoneyList
//     * @return
//     */
//    public Response<List<RichCouponDto>> findUsefulCouponByShopIdAndMoney(Long buyerId, List<Map<String, Object>> shopIdAndMoneyList);
//
//}
