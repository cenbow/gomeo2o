package cn.com.mx.cms.platform.dao.impl;

import org.springframework.stereotype.Repository;
import com.gomeo2o.common.core.dao.BaseDaoImpl;
import cn.com.mx.cms.entity.RecommendTypeEntity;
import cn.com.mx.cms.platform.dao.RecommendTypeDao;

@Repository
public class RecommendTypeDaoImpl extends BaseDaoImpl<RecommendTypeEntity> implements RecommendTypeDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(RecommendTypeEntity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecommendTypeEntity selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(RecommendTypeEntity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(RecommendTypeEntity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}