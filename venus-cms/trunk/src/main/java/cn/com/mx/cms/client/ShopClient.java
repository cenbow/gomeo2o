package cn.com.mx.cms.client;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import io.terminus.ecp.marketing.model.coupon.CouponDefinition;
import io.terminus.ecp.marketing.model.relations.ItemActivity;
import io.terminus.ecp.marketing.service.coupon.CouponReadService;
import io.terminus.ecp.marketing.service.relations.ItemActivityReadService;
import io.terminus.pampas.common.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.vshop.entity.VshopInfo;
import com.gomeo2o.facade.vshop.service.VshopFacade;
import com.google.common.collect.Maps;

import cn.com.gome.user.service.MemberShopFavoriteFacade;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;
import cn.com.mx.cms.utils.ChangePriceUtil;

/**
 * 
 * Description: 微店
 * 
 * @author duwei
 * @date 2015年11月30日 下午9:01:29
 * @version V1.0
 */
@Slf4j
@Service("qq")
public class ShopClient {

	@Autowired
	public VshopFacade vshopFacade;
	@Autowired
	private MemberShopFavoriteFacade memberShopFavoriteFacade; // 店铺收藏服务接口

	@Autowired
	private CouponReadService couponReadService;
	
	@Autowired
	private ItemActivityReadService itemActivityReadService;

	public VshopInfo queryVshopById(RecommendDto dto) throws Exception {
		long id = getId(dto);
		CommonResultEntity<VshopInfo> result = vshopFacade.queryVshopById(id);

		if (result.getCode() != 0) {
			log.error("调用商铺详情接口失败id={},msg={}", id, result.getMessage());
//			throw new JsonResponseException(result.getMessage());
			throw CmsException.VSHOP_INFO_FAILE;
		}
		VshopInfo shop = result.getBusinessObj();
		return shop;
	}

	/**
	 * @Description: 商铺优惠
	 */
	public Map<String, Boolean> getShopPrivilege(RecommendDto dto) throws Exception {
		Map<String, Boolean> map = Maps.newHashMap();
		map.put("isHaveCheap", false);// 是否设优惠--优惠
		map.put("isHaveRedBag", false);// 是否设有红包 --直降
		long id = getId(dto);

		// 通过shopId查询出微店信息
		VshopInfo vshopInfo = null;
		try {
			CommonResultEntity<VshopInfo> queryVshopById = vshopFacade.queryVshopById(id);
			if (queryVshopById.getCode() == 0) {
				vshopInfo = queryVshopById.getBusinessObj();
				if (vshopInfo == null) {
					log.error("通过shopId查询出微店不存在，参数商铺ID：" + id);
					throw CmsException.VSHOP_INFO_FAILE;
				}
			} else {
				throw CmsException.VSHOP_INFO_FAILE;
			}
		} catch (Exception e3) {
			log.error("vshopFacade.queryVshopById 调用dubbo服务异常");
			log.error(e3.getMessage(), e3);
			throw CmsException.VSHOP_INFO_FAILE;
		}
		/***************** 如果是(pop商家)微店 ******************/
		if ("2".equals(vshopInfo.getVshopType())) {
			if (vshopInfo.getVshopId() == 0) {
				log.error("数据库数据问题，vshopId没有对应的popId,参数，vshopId:" + id);
				throw CmsException.VSHOP_INFO_FAILE;
			}
			// 红包(最高红包金额)---
			try {
				Response<CouponDefinition> findMostDiscount = couponReadService.findMostDiscount(vshopInfo.getVshopId());
				if (findMostDiscount.isSuccess()) {
					CouponDefinition couponDefinition = findMostDiscount.getResult();
					if (couponDefinition != null) {
						String changePrice = ChangePriceUtil.changePrice(couponDefinition.getDiscount());
						if ("0.00".equals(changePrice)) {
							map.put("isHaveRedBag", false);// 是否设有红包 --直降

						} else {
							map.put("isHaveRedBag", true);// 是否设有红包 --直降
						}
					} else {
						map.put("isHaveRedBag", false);// 是否设有红包 --直降
					}
				} else {
					map.put("isHaveRedBag", false);// 是否设有红包 --直降
				}
			} catch (Exception e) {
				log.error("couponReadService.findMostDiscount 调用dubbo服务异常");
				map.put("isHaveRedBag", false);// 是否设有红包 --直降
			}
			// 店铺特惠(最高优惠额度)
			try {
				Response<ItemActivity> findMostDiscount2 = itemActivityReadService.findMostDiscount(vshopInfo.getVshopId());
				if (findMostDiscount2.isSuccess()) {
					ItemActivity itemActivity = findMostDiscount2.getResult();
					if (itemActivity != null) {
						String changePrice = ChangePriceUtil.changePrice(itemActivity.getDiscount());
						if ("0.00".equals(changePrice)) {
							map.put("isHaveCheap", false);// 是否设优惠--优惠
						} else {
							map.put("isHaveCheap", true);// 是否设优惠--优惠
						}
					} else {
						map.put("isHaveCheap", false);// 是否设优惠--优惠
					}
				} else {
					map.put("isHaveCheap", false);// 是否设优惠--优惠
				}
			} catch (Exception e) {
				log.error("itemActivityReadService.findMostDiscount 调用dubbo服务异常");
				map.put("isHaveCheap", false);// 是否设优惠--优惠
			}
		}
		return map;
	}

	private long getId(RecommendDto dto) {
		return dto.getRecommendId() == null ? 0 : dto.getRecommendId();
	}

}
