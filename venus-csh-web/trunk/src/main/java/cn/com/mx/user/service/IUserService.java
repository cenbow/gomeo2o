package cn.com.mx.user.service;

import java.util.List;

import cn.com.mx.base.entity.User;
import cn.com.mx.utils.ResultModel;

public interface IUserService {

	/**
	 * @Description 用户登录 
	 * @author guowenbo
	 * @date 2016年3月18日 下午3:16:17
	 * @param account
	 * @param password
	 * @return
	 */
	public ResultModel<User> loginUser(String account, String password);
	
	public List<User> queryUser(User user);

	public ResultModel<String> addUser(String userName);
}
