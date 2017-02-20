package cn.com.mx.cms.platform.service.impl;

import io.terminus.ecp.item.dto.FullItem;
import io.terminus.ecp.item.dto.ItemFullDetail;
import io.terminus.ecp.item.model.Item;
import io.terminus.ecp.item.model.ItemDetail;
import io.terminus.ecp.item.model.ItemTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.gome.rebate.constants.RebateType;
import cn.com.gome.rebate.model.plan.RebatePlanDto;
import cn.com.gome.rebate.model.plan.RebateRuleDto;
import cn.com.gome.user.model.MemberExpertInfo;
import cn.com.mx.cms.cache.IRecommendCache;
import cn.com.mx.cms.client.ExpertClient;
import cn.com.mx.cms.client.FavoriteClient;
import cn.com.mx.cms.client.GroupClient;
import cn.com.mx.cms.client.IMClient;
import cn.com.mx.cms.client.ItemClient;
import cn.com.mx.cms.client.LifeClient;
import cn.com.mx.cms.client.RebateClient;
import cn.com.mx.cms.client.ShopClient;
import cn.com.mx.cms.client.TopicClient;
import cn.com.mx.cms.constants.BaseConstants;
import cn.com.mx.cms.dto.platform.ItemDto;
import cn.com.mx.cms.dto.platform.RecommendDataDto;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.entity.RecommendDataEntity;
import cn.com.mx.cms.entity.RecommendEntity;
import cn.com.mx.cms.entity.RecommendMetaEntity;
import cn.com.mx.cms.enums.RebateEnums;
import cn.com.mx.cms.enums.RecommendType;
import cn.com.mx.cms.exception.CmsException;
import cn.com.mx.cms.platform.dao.RecommendDao;
import cn.com.mx.cms.platform.dao.RecommendDataDao;
import cn.com.mx.cms.platform.dao.RecommendMetaDao;
import cn.com.mx.cms.platform.dao.RecommendTitleDao;
import cn.com.mx.cms.platform.service.ICMSPlatformManager;
import cn.com.mx.cms.platform.service.ICMSRecommendService;
import cn.com.mx.cms.utils.CMSCodeUtil;
import cn.com.mx.cms.utils.ChangePriceUtil;
import cn.com.mx.cms.utils.DateUtil;
import cn.com.mx.cms.utils.EmojiFilterUtils;
import cn.com.mx.cms.utils.JsonUtil;
import cn.com.mx.cms.vo.GroupVo;
import cn.com.mx.cms.vo.ProductVo;
import cn.com.mx.cms.vo.RebateVo;
import cn.com.mx.cms.vo.ShopVo;
import cn.com.mx.cms.vo.TalentDynVo;
import cn.com.mx.cms.vo.TalentVo;
import cn.com.mx.cms.vo.TopicVo;
import cn.com.mx.social.dto.group.vo.GroupInfoVo;
import cn.com.mx.social.dto.topic.SocialTopicNewDto;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.exceptions.BizException;
import com.gomeo2o.facade.im.utils.StringUtils;
import com.gomeo2o.facade.shb.entity.SNSImageEntity;
import com.gomeo2o.facade.shb.entity.SNSPostEntity;
import com.gomeo2o.facade.vshop.entity.VshopInfo;
import com.gomeo2o.facade.vshop.service.VshopFacade;
import com.google.common.collect.Lists;

@SuppressWarnings("all")
@Slf4j
@Service("cmsRecomendService")
public class CMSRecomendServiceImpl implements ICMSRecommendService {

	@Autowired
	private RecommendDataDao recommendDataDao;
	@Autowired
	private RecommendMetaDao recommendMetaDao;
	@Autowired
	private IRecommendCache recCache;

	@Override
	public CommonResultEntity<Map<String, String>> addRecommend(List<RecommendDataDto> dtos, Long recommendType) {
		try {
			if (dtos == null) {
				return new CommonResultEntity(CMSCodeUtil.PAMAS_ERROR, CMSCodeUtil.PAMAS_ERROR_MSG, "");
			}

			// 1.删除推荐位
			if(recommendType == null){
				return new CommonResultEntity(CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_CODE,
						CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_MSG, "");
			}
			recommendDataDao.deleteByType(recommendType);
			recCache.writeRecommendDataDto(String.valueOf(recommendType), dtos);
			
			for (RecommendDataDto dto : dtos) {
				dto.setRecommendData(EmojiFilterUtils.filterEmoji(dto.getRecommendData()));
			}
			if(dtos.size() == 0){
				return new CommonResultEntity(CMSCodeUtil.SUCCESS, "删除推荐位成功", null);
			}
			List<RecommendDataEntity> entityList = getRecommendEntitys(dtos);
			
			// 2.新增推荐位
			for (RecommendDataEntity entity : entityList) {
				recommendDataDao.insertSelective(entity);
			}

		} catch (Exception e) {
			log.error("新增推荐位失败,失败原因:", e);
			return new CommonResultEntity(CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_CODE,
					CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_MSG, "");

		}
		return new CommonResultEntity(CMSCodeUtil.SUCCESS, CMSCodeUtil.SUCCESS_MSG, null);
	}

	private List<RecommendDataEntity> getRecommendEntitys(List<RecommendDataDto> dtos) {
		List<RecommendDataEntity> entityList = Lists.newArrayList();
		for (RecommendDataDto dto : dtos) {
			entityList.add(convertDto2Po(dto));
		}
		return entityList;
	}

	private RecommendDataEntity convertDto2Po(RecommendDataDto dto) {
		RecommendDataEntity entity = new RecommendDataEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public CommonResultEntity<Map<String, String>> deleteRecommend(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResultEntity<HashMap<String, Object>> findRecommendByType(Long type) {
		if (type != null) {
			List<RecommendDataEntity> recommendList = recommendDataDao.selectByRecommendType(type);
			RecommendMetaEntity metaEntity = recommendMetaDao.selectByPrimaryKey(type);
			List<RecommendDataDto> recommendDataDtos = new ArrayList<RecommendDataDto>();
			for (RecommendDataEntity recommendDataEntity : recommendList) {
				RecommendDataDto dto2 = new RecommendDataDto();
				BeanUtils.copyProperties(recommendDataEntity, dto2);
				recommendDataDtos.add(dto2);
			}
			String title = "";
			HashMap<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("title", title);
			resultMap.put("list", recommendDataDtos);
			return new CommonResultEntity<HashMap<String, Object>>(0, "成功", resultMap);
		}
		return new CommonResultEntity<HashMap<String, Object>>(1, "推荐位类型为空", new HashMap<String, Object>());
	}

	@Override
	public CommonResultEntity<HashMap<String, Object>> updateRecommendById(
			RecommendDataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResultEntity<Long> findRecommendDataRedis(String key) {
		if(key == null){
			return new CommonResultEntity<Long>(1, "参数为空", 0l);
		}
		Long result = recCache.getRecommendDataRedis(key);
		return new CommonResultEntity<Long>(0, "成功", result);
	}

}
