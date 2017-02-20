package cn.com.mx.cms.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import io.terminus.ecp.item.dto.ItemFullDetail;
import io.terminus.ecp.item.dto.SkuWithLvPrice;
import io.terminus.ecp.item.service.ItemReadService;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.gome.service.CacheService;
import com.google.common.collect.Maps;

import cn.com.gome.item.service.GomeItemReadService;
import cn.com.gome.rebate.constants.RebateType;
import cn.com.gome.rebate.dubbo.service.man.IDubboRebatePlanService;
import cn.com.gome.rebate.exception.ErrorCode;
import cn.com.gome.rebate.model.plan.RebatePlanDto;
import cn.com.gome.rebate.model.plan.RebateRuleDto;
import cn.com.gome.rebate.model.plan.RuleListReqDto;
import cn.com.gome.rebate.page.impl.CommonPagedList;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;
import cn.com.mx.cms.utils.ChangePriceUtil;

/**
 * Description: 返利
 * 
 * @author duwei
 * @date 2015年11月30日 下午9:12:34
 * @version V1.0
 */
@Slf4j
@Service
public class RebateClient {
	@Autowired
	private IDubboRebatePlanService rebatePlanService;
	@Autowired
	protected CacheService cacheService;
	@Autowired
	private GomeItemReadService gomeItemReadService;
	@Autowired
	private ItemReadService itemReadService;

	public static String getRebate() {
		return ResourceBundle.getBundle("app").getString("gcache.rebate.name");
	}

	/**
	 * @Description: 查询商家是否返利
	 */
	public RebateRuleDto getRuleDetailList(RecommendDto dto) throws Exception {
		long id = dto.getRecommendId() == null ? 0 : dto.getRecommendId();
		RuleListReqDto ruleDto = new RuleListReqDto();
		ruleDto.setMerchant_id(id + "");
		ruleDto.setCurrentPage(0);
		ruleDto.setPageSize(1);
		CommonPagedList<RebateRuleDto> resultList = rebatePlanService.getRuleDetailList(ruleDto);

		if (!ErrorCode.E0000.name().equals(resultList.getErrorCode())) {
			log.error("调用返利商户--返利接口失败id={},msg={}", id, resultList.getErrorMessage());
			throw CmsException.REBATE_RULE_INFO_FAILE;
		}

		RebateRuleDto rd = new RebateRuleDto();
		if (resultList != null) {
			if (CollectionUtils.isNotEmpty(resultList.getList())) {
				rd = resultList.getList().get(0);
			}
		}

		return rd;
	}
	
	public RebatePlanDto getPlanDetail(RecommendDto dto) throws Exception {
		long id = dto.getRecommendId() == null ? 0 : dto.getRecommendId();
		RebatePlanDto planDto = new RebatePlanDto();
		planDto.setMerchantScopes(id + "");
		RebatePlanDto returnDto = rebatePlanService.getPlanDetailByMercId(planDto);

		if (returnDto ==null) {
			log.error("调用返利商户--返利接口失败id={},msg={}", id);
			throw CmsException.REBATE_PLAN_INFO_FAILE;
		}

		return returnDto;
	}

	/**
	 * 
	 * @Description: 获得商品返利金额<br>
	 *               该商品是分享，平台基础+平台促销+商家规则
	 * @param rebateType
	 *            返利类型（分享、分销）
	 * @param itemId
	 *            商品ID
	 * @param itemPrice
	 *            商品销售价格
	 * @param userRoleId
	 *            用户角色ID
	 */
	public String getItemRebateAmount(int rebateType, long itemId, int userRoleId) throws Exception {
		// 获取最大返利金额
		String maxRebatePrice = getShareMaxRebatePriceByItem(rebateType, itemId, userRoleId);
		return maxRebatePrice;
	}
	
	/**
	 * 
	 * @Description: 获得分享商品最大返利金额
	 * @param rebateType
	 *            返利类型（分享、分销）
	 * @param itemId
	 *            商品ID
	 * @param userRoleId
	 */
	private String getShareMaxRebatePriceByItem(int rebateType, long itemId, int userRoleId) {
		// 获取商品SKU最大价格
		BigDecimal skuMaxPrice = new BigDecimal(0);
		Map<Long, BigDecimal> returnMap = getMaxPriceByItem(itemId);
		if (returnMap.size() > 0) {
			for (Entry<Long, BigDecimal> entry : returnMap.entrySet()) {
				skuMaxPrice = entry.getValue();
				// 从计算中心取到商品返利百分比
				JSONObject json = JSONObject.fromObject(cacheService.hget(getRebate(), "Rebate_Calc_Itm",
						"Rebate_Calc_Itm_" + itemId + ""));
				if (json != null && json.size() > 0) {
					DecimalFormat df5 = new DecimalFormat("0.00");
					df5.setRoundingMode(RoundingMode.HALF_UP);
					// 分享
					if (rebateType == RebateType.buyShare.getCode()) {// pmtShareRatio
						Integer pfShareRatio = (int) (json.getDouble("popShareRatio") * 1000000);
						Integer popShareRatio = (int) (json.getDouble("pfShareRatio") * 1000000);
						Integer pmtShareRatio = (int) (json.getDouble("pmtShareRatio") * 1000000);

						if (pfShareRatio == 0 && popShareRatio == 0 && pmtShareRatio == 0) {
							return "0.00";
						}
						// 百分比
						double shareRatio = (double) (((pfShareRatio == null) ? 0 : pfShareRatio)
								+ ((popShareRatio == null) ? 0 : popShareRatio) + ((pmtShareRatio == null) ? 0
									: pmtShareRatio)) / (double) 1000000;

						return df5.format(ChangePriceUtil.mul(shareRatio, skuMaxPrice.doubleValue()));
					}
				}
				break;
			}
		}
		return "0.00";
	}
	
	/**
	 * @Description: 商品SKU最大金额<br>
	 *              
	 * @param itemId
	 *            商品ID
	 * @return 返回商品sku最大金额。
	 */
	private Map<Long, BigDecimal> getMaxPriceByItem(long itemId) {
		BigDecimal skuMaxPrice = new BigDecimal(0.00);
		Map<Long, BigDecimal> returnMap = Maps.newHashMap();
		Response<ItemFullDetail> res;
		long skuid=0;
		try {
			res = itemReadService.findItemFullDetailById(itemId);
		} catch (Exception e) {
			log.error("调用查找商品的全部信息--商品全部信息失败id={},msg={}", itemId, e.getMessage());
			return returnMap;
		}

		if (!res.isSuccess()) {
			log.error("最大返利金额 itemID=" + itemId + "：在数据库有问题错误信息:" + res.getError() + "");
		} else {
			if (res.getResult() != null) {
				ItemFullDetail SkuWithItemList = res.getResult();
				if (SkuWithItemList == null) {
					return returnMap;
				}
				List<SkuWithLvPrice> skulist = SkuWithItemList.getFullItem().getSkus();
				int skuUpprice = 0;
				int j = 0;
				for (SkuWithLvPrice sku : skulist) {
					if (j == 0) {
						skuUpprice = sku.getSku().getPrice();
					} else {
						if (skuUpprice < sku.getSku().getPrice()) {
							skuUpprice = sku.getSku().getPrice();
						}
					}
					skuid = sku.getSku().getId();
					j++;
				}
				DecimalFormat df5 = new DecimalFormat("0.00");
				df5.setRoundingMode(RoundingMode.HALF_UP);
				skuMaxPrice = new BigDecimal(ChangePriceUtil.formatDiv(Double.valueOf(skuUpprice), 100d));
				returnMap.put(skuid, skuMaxPrice);
				return returnMap;
			}
		}
		return returnMap;
	}

	/**
	 * @Description: 商品是否有返利
	 * @param itemId
	 *            商品ID
	 */
	public boolean gethasRebate(long itemId) throws Exception {

		JSONObject json = JSONObject.fromObject(cacheService.hget(getRebate(), "Rebate_Calc_Itm", "Rebate_Calc_Itm_"
				+ itemId + ""));
		if (json != null && json.size() > 0) {
			return true;
		}
		return false;
	}
	
}
