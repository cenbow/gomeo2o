package cn.com.mx.cms.platform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.mx.cms.dto.platform.RecommendDataDto;

import com.gomeo2o.common.entity.CommonResultEntity;

public interface ICMSRecommendService {

	public CommonResultEntity<Map<String, String>> addRecommend(List<RecommendDataDto> dtos, Long type);

	public CommonResultEntity<Map<String, String>> deleteRecommend(Long id);

	public CommonResultEntity<HashMap<String, Object>> findRecommendByType(Long type);
	
	public CommonResultEntity<HashMap<String, Object>> updateRecommendById(RecommendDataDto dto);
	
	public CommonResultEntity<Long> findRecommendDataRedis(String key);

}
