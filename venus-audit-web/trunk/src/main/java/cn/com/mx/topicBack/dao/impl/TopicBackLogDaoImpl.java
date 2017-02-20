package cn.com.mx.topicBack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.topicBack.dao.ITopicBackLogDao;
import cn.com.mx.topicBack.entity.TopicBackLog;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;
/**
 * @Description 话题回复日志dao实现 
 * @author yuanchangjun
 * @date 2016年2月19日 下午1:44:55
 */
@Repository("topicBackLogDao")
public class TopicBackLogDaoImpl extends BaseMongoDaoImpl<TopicBackLog> implements ITopicBackLogDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
