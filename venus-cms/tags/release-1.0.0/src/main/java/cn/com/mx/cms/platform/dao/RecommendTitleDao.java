package cn.com.mx.cms.platform.dao;

import com.gomeo2o.common.core.dao.BaseDao;
import cn.com.mx.cms.entity.RecommendEntity;

public interface RecommendTitleDao extends BaseDao {

	RecommendEntity selectByPrimaryKey(Integer id);
	
	String selectByType(Integer type);

	int update(Object entity);

	long insert(Object entity);

}