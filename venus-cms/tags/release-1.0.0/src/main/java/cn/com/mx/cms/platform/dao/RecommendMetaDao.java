package cn.com.mx.cms.platform.dao;

import java.util.List;

import cn.com.mx.cms.entity.RecommendMetaEntity;

public interface RecommendMetaDao {
	
	int deleteByPrimaryKey(RecommendMetaEntity entity);

	int insertSelective(RecommendMetaEntity entity);

	RecommendMetaEntity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(RecommendMetaEntity record);
	
	List<RecommendMetaEntity> selectRecommendMetas();

	int updateByPrimaryKey(RecommendMetaEntity entity);
}