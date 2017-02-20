package cn.com.mx.cms.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.com.mx.cms.entity.RecommendEntity;
import cn.com.mx.cms.platform.dao.RecommendTitleDao;

import com.gomeo2o.common.core.dao.BaseDaoImpl;

@Repository
public class RecommendTitleDaoImpl  extends BaseDaoImpl implements RecommendTitleDao{
	private String baseSQLUrl = "cn.com.mx.cms.platform.dao.impl.RecommendTitleDaoImpl.";
	
	@Override
	public long insert(Object entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecommendEntity selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectByType(Integer type) {
		String sqlurl = baseSQLUrl + "selectByType";
		String title = super.getSessionTemplate().selectOne(sqlurl, type);
		return title;
	}

}
