package cn.com.mx.cms.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gomeo2o.common.core.dao.BaseDaoImpl;
import cn.com.mx.cms.entity.RecommendDataEntity;
import cn.com.mx.cms.platform.dao.RecommendDataDao;

@Repository("recommendDataDao")
public class RecommendDataDaoImpl extends BaseDaoImpl<RecommendDataEntity> implements RecommendDataDao {
	private String baseSQLUrl = "cn.com.mx.cms.platform.dao.impl.RecommendDataDaoImpl.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		String sqlurl = baseSQLUrl + "deleteByPrimaryKey";
		return super.getSessionTemplate().delete(sqlurl, id);
	}

	@Override
	public int insertSelective(RecommendDataEntity entity) {
		String sqlurl = baseSQLUrl + "insertSelective";
		return super.getSessionTemplate().delete(sqlurl, entity);
	}

	@Override
	public RecommendDataEntity selectByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(RecommendDataEntity recommend) {
		String sqlurl = baseSQLUrl + "updateByPrimaryKeySelective";
		return super.getSessionTemplate().delete(sqlurl, recommend);
	}

	@Override
	public int updateByPrimaryKey(RecommendDataEntity recommend) {
		String sqlurl = baseSQLUrl + "updateByPrimaryKey";
		return super.getSessionTemplate().delete(sqlurl, recommend);
	}

	@Override
	public int deleteByType(Long type) {
		String sqlurl = baseSQLUrl + "deleteByType";
		return super.getSessionTemplate().delete(sqlurl, type);
	}

	@Override
	public List<RecommendDataEntity> selectByRecommendType(Long type) {
		String sqlurl = baseSQLUrl + "selectByRecommendType";
		List<RecommendDataEntity> recommendList = super.getSessionTemplate().selectList(sqlurl, type);
		return recommendList;
	}
	
}