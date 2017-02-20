package cn.com.mx.cms.platform.dao;

import java.util.HashMap;
import java.util.List;

import com.gomeo2o.common.core.dao.BaseDao;

import cn.com.mx.cms.entity.RecommendEntity;

public interface RecommendDao extends BaseDao<RecommendEntity> {
	int deleteByPrimaryKey(Integer id);

	long insert(RecommendEntity record);

	int insertSelective(RecommendEntity record);

	RecommendEntity selectByPrimaryKey(Integer id);
	
	List<RecommendEntity> selectByRecommendType(Integer type);

	int updateByPrimaryKeySelective(RecommendEntity record);

	int updateByPrimaryKey(RecommendEntity record);

	/**
	 * 
	 * @Description: 删除指定推荐位类型的库信息
	 * @author duwei
	 * @param recType
	 *            推荐位类型
	 */
	int deleteByRecType(Integer recType);
	
	List<RecommendEntity> findRecommendList(HashMap<String, Object> paramMap);

	List<RecommendEntity> findSuperRebateList(HashMap<String, Object> paramMap);
}