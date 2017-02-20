package cn.com.mx.cms.platform.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;

import cn.com.mx.cms.entity.RecommendEntity;
import cn.com.mx.cms.platform.dao.RecommendDao;

@Repository("recommendDao")
public class RecommendDaoImpl extends BaseDaoImpl<RecommendEntity> implements RecommendDao {
	private String baseSQLUrl = "cn.com.mx.cms.platform.dao.impl.RecommendDaoImpl.";

	@Override
	public int deleteByPrimaryKey(Integer id) {
		String sqlurl = baseSQLUrl + "deleteByPrimaryKey";
		return super.getSessionTemplate().delete(sqlurl, id);
	}

	@Override
	public int insertSelective(RecommendEntity entity) {
		String sqlurl = baseSQLUrl + "insertSelective";
		return super.getSessionTemplate().delete(sqlurl, entity);
	}

	@Override
	public RecommendEntity selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(RecommendEntity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(RecommendEntity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @Description: 删除指定推荐位类型的库信息
	 * @author duwei
	 * @param recType
	 *            推荐位类型
	 */
	@Override
	public int deleteByRecType(Integer recType) {
		String sqlurl = baseSQLUrl + "deleteByRecType";
		return super.getSessionTemplate().delete(sqlurl, recType);
	}

	@Override
	public List<RecommendEntity> selectByRecommendType(Integer type) {
		String sqlurl = baseSQLUrl + "selectByRecommendType";
		List<RecommendEntity> recommendList = super.getSessionTemplate().selectList(sqlurl, type);
		return recommendList;
	}
	
	
	@Override
	public List<RecommendEntity> findRecommendList(HashMap<String, Object> paramMap) {
		String sqlurl = baseSQLUrl + "recommendList";
		return super.getSessionTemplate().selectList(sqlurl, paramMap);
	}
	
	@Override
	public List<RecommendEntity> findSuperRebateList(HashMap<String, Object> paramMap) {
		String sqlurl = baseSQLUrl + "superRebateList";
		return super.getSessionTemplate().selectList(sqlurl, paramMap);
	}


}