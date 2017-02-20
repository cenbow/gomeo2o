package cn.com.mx.cms.platform.dao;

import com.gomeo2o.common.core.dao.BaseDao;

import cn.com.mx.cms.entity.RecommendTypeEntity;

public interface RecommendTypeDao extends BaseDao<RecommendTypeEntity> {

	int deleteByPrimaryKey(Integer id);

	long insert(RecommendTypeEntity record);

	int insertSelective(RecommendTypeEntity record);

	RecommendTypeEntity selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(RecommendTypeEntity record);

	int updateByPrimaryKey(RecommendTypeEntity record);
}