/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午2:47:23
 */
package cn.com.mx.user.dao.impl;


import org.springframework.stereotype.Repository;

import cn.com.mx.base.dao.MyBatisDao;
import cn.com.mx.base.entity.User;
import cn.com.mx.user.dao.IUserDao;

/**
 * @Description TODO 
 * @author guwoenbo
 * @date 2016年3月18日 下午2:47:23
 */
@Repository("userDao")
public class UserDaoImpl extends MyBatisDao<User> implements IUserDao {

	private static String baseSql = "cn.com.mx.user.dao.UserDao.";
	
	public User queryUserByName(String loginName){
		return this.getSqlSession().selectOne(baseSql + "queryUserByName", loginName);
	}

	public int addUser(User user) {
		return this.getSqlSession().insert(baseSql+"insert",user);
	}
}
