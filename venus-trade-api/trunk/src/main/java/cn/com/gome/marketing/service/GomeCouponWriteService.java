//package cn.com.gome.marketing.service;
//
//import java.util.List;
//import java.util.Map;
//
//import io.terminus.ecp.marketing.service.coupon.CouponWriteService;
//import io.terminus.pampas.common.Response;
//
///**
// * Mail: xiao@terminus.io <br>
// * Date: 2015-05-23 12:05 PM  <br>
// * Author: xiao
// */
//public interface GomeCouponWriteService extends CouponWriteService {
//	/**
//	 * @Description 还原用户优惠券 
//	 * @author miaomiao
//	 * @date 2016年1月15日 下午12:17:09
//	 * @param couponDefId 优惠券id
//	 * @param userId 用户id
//	 * @return
//	 */
//	//Response<Boolean> backCouponToUser(Long couponDefId,Long userId);
//	/**
//	 * @Description 还原用户指定数量优惠券 
//	 * @author miaomiao
//	 * @date 2016年1月15日 下午12:17:41
//	 * @param couponDefId 优惠券id
//	 * @param userId 用户id
//	 * @param couponNum 还原优惠券数量
//	 * @return
//	 */
//	Response<Boolean> backCouponToUser(Map<Long,String> mergeIdAndOrderIds);
//	/**
//	 * @Description 批量发放优惠券
//	 * @author miaomiao
//	 * @date 2016年1月15日 下午12:17:41
//	 * @param userIds 
//	 * @param couponDefinitionId 
//	 * @param num
//	 * @return 发放失败的优惠券id
//	 */
//	List<Long> autoSendBatchCoupon(List<Long> userIds, Long couponDefinitionId, Integer num);
//	
//}
