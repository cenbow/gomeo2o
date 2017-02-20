/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午2:47:23
 */
package cn.com.mx.user.dao;

import cn.com.mx.base.entity.User;

/**
 * @Description TODO 
 * @author guwoenbo
 * @date 2016年3月18日 下午2:47:23
 */
public interface IUserDao{

	public User queryUserByName(String loginName);
}
