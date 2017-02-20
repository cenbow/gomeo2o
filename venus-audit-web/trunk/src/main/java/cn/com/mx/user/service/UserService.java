/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 下午2:07:08
 */
package cn.com.mx.user.service;

import cn.com.mx.user.model.User;
import cn.com.mx.utils.ResultModel;

import com.gomeo2o.common.page.PageParam;

/**
 * @Description 审核用户
 * @author kl_chaizhilei
 * @date 2016年1月28日 下午2:07:08
 */
public interface UserService {

	/**
	 * @Description 登陆用户
	 * @author kl_chaizhilei
	 * @date 2016年1月29日 上午10:39:24
	 * @param account
	 * @param password
	 * @return
	 */
	public ResultModel<User> loginUser(String account, String password);

	/**
	 * @Description 添加审核用户
	 * @author kl_chaizhilei
	 * @date 2016年1月28日 下午5:32:20
	 * @param user
	 * @return
	 */
	public ResultModel<Boolean> saveUser(User user);

	/**
	 * @Description 查询用户
	 * @author kl_chaizhilei
	 * @date 2016年1月29日 上午10:17:19
	 * @param account
	 *            账号名
	 * @return
	 */
	public ResultModel<User> getUser(String account);
	
	/**
	 * @Description 根据id查询用户 
	 * @author kl_chaizhilei
	 * @date 2016年2月18日 下午4:21:56
	 * @param id
	 * @return
	 */
	public ResultModel<User> getUserById(String id);
	
	/**
	 * @Description 查询所有用户
	 * @author kl_chaizhilei
	 * @date 2016年2月23日 下午2:08:36
	 * @return
	 */
	public ResultModel<Object> getAllUserByName(String name,PageParam page);
	
	/**
	 * @Description 更新用户信息 
	 * @author kl_chaizhilei
	 * @date 2016年2月26日 下午3:48:20
	 * @param user
	 * @return
	 */
	public ResultModel<Boolean> updateStatus(String userId,int status,String updateUserId);

}
