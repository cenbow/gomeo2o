package cn.com.mx.cms.platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;

import cn.com.mx.cms.entity.RecommendMetaEntity;
import cn.com.mx.cms.platform.dao.RecommendMetaDao;

/**
 * 
 * Description: 推荐位元数据DAO层
 * 
 * @author duwei
 * @date 2015年12月22日 下午6:07:25
 * @version V1.0
 */
@Repository("recommendMetaDao")
public class RecommendMetaDaoImpl extends BaseDaoImpl<RecommendMetaEntity> implements RecommendMetaDao {
	private String baseSQLUrl = "cn.com.mx.cms.platform.dao.impl.RecommendMetaDaoImpl.";

	/**
	 * 查询所有有效的推荐位元数据列表信息
	 */
	@Override
	public List<RecommendMetaEntity> selectRecommendMetas() {
		String sqlurl = baseSQLUrl + "selectRecommendMetas";
		return super.getSessionTemplate().selectList(sqlurl);
	}

	@Override
	public int insertSelective(RecommendMetaEntity entity) {
		String sqlurl = baseSQLUrl + "insertSelective";
		return this.getSessionTemplate().insert(sqlurl, entity);
	}

	@Override
	public int updateByPrimaryKeySelective(RecommendMetaEntity entity) {
		String sqlurl = baseSQLUrl + "updateByPrimaryKeySelective";
		return this.getSessionTemplate().update(sqlurl, entity);
	}

	@Override
	public int deleteByPrimaryKey(RecommendMetaEntity entity) {
		String sqlurl = baseSQLUrl + "deleteByPrimaryKey";
		return this.getSessionTemplate().update(sqlurl, entity);
	}

	@Override
	public int updateByPrimaryKey(RecommendMetaEntity entity) {
		return 0;
	}

	@Override
	public RecommendMetaEntity selectByPrimaryKey(Long id) {
		String sqlurl = baseSQLUrl + "selectByPrimaryKey";
		return super.getSessionTemplate().selectOne(sqlurl, id);
	}

}