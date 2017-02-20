package cn.com.mx.cms.platform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.entity.RecommendEntity;
import cn.com.mx.cms.enums.RecommendEnums;
import cn.com.mx.cms.enums.RecommendType;
import cn.com.mx.cms.platform.dao.RecommendDao;
import cn.com.mx.cms.recommend.service.IRecommendFacade;
import cn.com.mx.cms.utils.CMSCodeUtil;

import com.gomeo2o.common.entity.CommonResultEntity;

/**
 * 
 * @Description
 * @author zhangxianpeng
 * @date 2015年11月30日 上午11:27:18
 */
@Service("recommendFacade")
@Slf4j
public class RecommendFacadeImpl implements IRecommendFacade {

	@Autowired
	public RecommendDao recommendDao;

	@Override
	public CommonResultEntity<List<RecommendDto>> findRecommendList() {

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("isDisabled", RecommendEnums.AVAILABLE.getValue());
		paramMap.put("recommendType", RecommendType.superRebateRec.getCode());// 超级返类型
		List<RecommendEntity> list = recommendDao.findRecommendList(paramMap);

		List<RecommendDto> recommendDtos = new ArrayList<RecommendDto>();
		if (list != null && list.size() > 0) {
			for (RecommendEntity recommendEntity : list) {
				RecommendDto dto = new RecommendDto();
				BeanUtils.copyProperties(recommendEntity, dto);
				recommendDtos.add(dto);
			}
		}

		return new CommonResultEntity<List<RecommendDto>>(CMSCodeUtil.SUCCESS, CMSCodeUtil.SUCCESS_MSG, recommendDtos);
	}

	@Override
	public CommonResultEntity<List<RecommendDto>> findSuperRebateList() {

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("isDisabled", RecommendEnums.AVAILABLE.getValue());
		paramMap.put("recommendType", RecommendType.superRebateRec.getCode());// 超级返类型
		List<RecommendEntity> list = recommendDao.findSuperRebateList(paramMap);

		List<RecommendDto> recommendDtos = new ArrayList<RecommendDto>();
		if (list != null && list.size() > 0) {
			for (RecommendEntity recommendEntity : list) {
				RecommendDto dto = new RecommendDto();
				BeanUtils.copyProperties(recommendEntity, dto);
				recommendDtos.add(dto);
			}
		}
		return new CommonResultEntity<List<RecommendDto>>(CMSCodeUtil.SUCCESS, CMSCodeUtil.SUCCESS_MSG, recommendDtos);
	}
	
	@Override
	public CommonResultEntity<List<RecommendDto>> findRecommendListByType(int type) {

		List<RecommendEntity> list = recommendDao.selectByRecommendType(type);

		List<RecommendDto> recommendDtos = new ArrayList<RecommendDto>();
		if (list != null && list.size() > 0) {
			for (RecommendEntity recommendEntity : list) {
				RecommendDto dto = new RecommendDto();
				BeanUtils.copyProperties(recommendEntity, dto);
				recommendDtos.add(dto);
			}
		}

		return new CommonResultEntity<List<RecommendDto>>(CMSCodeUtil.SUCCESS, CMSCodeUtil.SUCCESS_MSG, recommendDtos);
	}

}
