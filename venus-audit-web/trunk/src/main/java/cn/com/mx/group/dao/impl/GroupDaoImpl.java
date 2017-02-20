package cn.com.mx.group.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.group.dao.GroupDao;
import cn.com.mx.social.entity.group.SocialGroup;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;
/**
 * @Description 审核群组实现 
 * @author yuanchangjun
 * @date 2016年2月19日 下午1:44:55
 */
@Repository("groupDao")
public class GroupDaoImpl extends BaseMongoDaoImpl<SocialGroup> implements GroupDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
