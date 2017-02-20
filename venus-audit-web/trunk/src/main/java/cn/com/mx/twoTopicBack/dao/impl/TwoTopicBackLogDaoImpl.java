package cn.com.mx.twoTopicBack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.twoTopicBack.dao.ITwoTopicBackLogDao;
import cn.com.mx.twoTopicBack.entity.TwoTopicBackLog;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;
/**
 * @Description 日志dao 
 * @author yuanchangjun
 * @date 2016年3月1日 下午12:28:55
 */
@Repository("twoTopicBackLogDao")
public class TwoTopicBackLogDaoImpl extends BaseMongoDaoImpl<TwoTopicBackLog> implements ITwoTopicBackLogDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
