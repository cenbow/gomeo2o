package cn.com.mx.log.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.log.dao.TopicLogDao;
import cn.com.mx.topic.entity.TopicLog;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;
/**
 * @Description 审核群组日志实现 
 * @author yuanchangjun
 * @date 2016年2月19日 下午1:44:55
 */
@Repository("topicLogDao")
public class TopicLogDaoImpl extends BaseMongoDaoImpl<TopicLog> implements TopicLogDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
