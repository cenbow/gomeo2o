package cn.com.mx.group.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.group.dao.EditGroupDao;
import cn.com.mx.social.entity.group.SocialGroupPending;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;

/**
 * @Description  修改圈子审核实现 
 * @author yuanchangjun
 * @date 2016年3月2日 下午4:47:35
 */
@Repository("editGroupDao")
public class EditGroupDaoImpl extends BaseMongoDaoImpl<SocialGroupPending> implements EditGroupDao {

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
