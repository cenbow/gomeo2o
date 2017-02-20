package cn.com.mx.topicBack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.social.entity.topic.SocialTopicPerson;
import cn.com.mx.topicBack.dao.ITopicBackDao;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;
/**
 * @Description 审核群组实现 
 * @author yuanchangjun
 * @date 2016年2月19日 下午1:44:55
 */
@Repository("topicBackDao")
public class TopicBackDaoImpl extends BaseMongoDaoImpl<SocialTopicPerson> implements ITopicBackDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
