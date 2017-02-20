package cn.com.mx.topic.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.social.entity.topic.SocialTopic;
import cn.com.mx.topic.dao.TopicDao;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;
/**
 * @Description 审核群组实现 
 * @author yuanchangjun
 * @date 2016年2月19日 下午1:44:55
 */
@Repository("topicDao")
public class TopicDaoImpl extends BaseMongoDaoImpl<SocialTopic> implements TopicDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
