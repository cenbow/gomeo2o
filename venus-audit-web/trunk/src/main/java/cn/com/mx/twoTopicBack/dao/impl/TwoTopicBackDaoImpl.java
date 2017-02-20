package cn.com.mx.twoTopicBack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.social.entity.topic.SocialTopicReply;
import cn.com.mx.twoTopicBack.dao.ITwoTopicBackDao;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;

/**
 * @Description 二级回复审核 
 * @author yuanchangjun
 * @date 2016年3月1日 下午12:30:58
 */
@Repository("twoTopicBackDao")
public class TwoTopicBackDaoImpl extends BaseMongoDaoImpl<SocialTopicReply> implements ITwoTopicBackDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
