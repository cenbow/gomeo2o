package cn.com.mx.cms.platform.dao;

import java.util.List;
import com.gomeo2o.common.core.dao.BaseDao;
import cn.com.mx.cms.entity.RecommendDataEntity;

public interface RecommendDataDao extends BaseDao<RecommendDataEntity> {
	
	int deleteByPrimaryKey(Long id);

	long insert(RecommendDataEntity recommend);

	int insertSelective(RecommendDataEntity recommend);

	RecommendDataEntity selectByPrimaryKey(Long id);
	
	List<RecommendDataEntity> selectByRecommendType(Long type);

	int updateByPrimaryKeySelective(RecommendDataEntity record);

	int updateByPrimaryKey(RecommendDataEntity record);

	int deleteByType(Long type);
	
}