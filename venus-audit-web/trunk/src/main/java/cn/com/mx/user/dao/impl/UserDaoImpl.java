/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午11:01:54
 */
package cn.com.mx.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import cn.com.mx.user.dao.UserDao;
import cn.com.mx.user.model.User;
import cn.com.mx.utils.mongo.BaseMongoDaoImpl;

/**
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午11:01:54
 */
@Repository("auditUserDao")
public class UserDaoImpl extends BaseMongoDaoImpl<User> implements UserDao{

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
