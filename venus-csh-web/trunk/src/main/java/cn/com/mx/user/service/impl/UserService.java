/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午3:15:29
 */
package cn.com.mx.user.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esotericsoftware.minlog.Log;

import cn.com.mx.base.entity.User;
import cn.com.mx.user.dao.impl.UserDaoImpl;
import cn.com.mx.user.service.IUserService;
import cn.com.mx.utils.Password;
import cn.com.mx.utils.ResultModel;
import cn.com.mx.utils.ldap.LdapDto;
import cn.com.mx.utils.ldap.LdapUtil;

/**
 * @Description TODO 
 * @author guowenbo
 * @date 2016年3月18日 下午3:15:29
 */
@Service("userService")
public class UserService implements IUserService{

	@Autowired
	private UserDaoImpl userDao;
	
	/**
	 * @Description 用户登录 
	 * @author guowenbo
	 * @date 2016年3月18日 下午3:16:17
	 * @param account
	 * @param password
	 * @return
	 */
	public ResultModel<User> loginUser(String account, String password) {
		ResultModel<User> result = new ResultModel<User>();
		User user = userDao.queryUserByName(account);
		if(user==null){
			result.setSuccess(false);
			return result;
		}else{
			if("admin".equals(account)){
				if(!Password.match(password, user.getPassword())){
					result.setSuccess(false);
					return result;
				}else{
					result.setData(user);
					return result;
				}
			}else{
				//验证ldap
				try {
					String resultAttrutes[] = {"distinguishedName"};
					List<LdapDto> ldapResult = LdapUtil.queryInfo("dc=meixin,dc=com", 0, resultAttrutes, "mail="+account);
					if(ldapResult!=null&&ldapResult.size()>0){
						String userName = ldapResult.get(0).getValue().get(0);
						if(LdapUtil.checkLdapByUser(userName, password)){
							result.setData(user);
							return result;
						}else{
							result.setSuccess(false);
							return result;
						}
					}else{
						result.setSuccess(false);
						return result;
					}
				} catch (Exception e) {
					result.setSuccess(false);
					return result;
				}
			}
		}
	}
	
	
	
	public List<User> queryUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 
	 * @Description 添加账号
	 * @author zhaoxingxing
	 * @date 2016年3月21日 上午10:16:17
	 * @param userName
	 * @return
	 */
	@Override
	public ResultModel<String> addUser(String userName) {
		ResultModel<String> res = new ResultModel<String>();
		//验证ldap
		try {
			String resultAttrutes[] = {"distinguishedName"};
			List<LdapDto> ldapResult = LdapUtil.queryInfo("dc=meixin,dc=com", 0, resultAttrutes, "mail="+userName);
			if(ldapResult!=null&&ldapResult.size()>0){
				res.setSuccess(true);
			}else{
				res.setSuccess(false);
				return res;
			}
		} catch (Exception e) {
			Log.error("ldap验证账户不存在，查询账户：userName：{},exception is:{}",userName,e);
			res.setSuccess(false);
			return res;
		}
		//ldap账号存在，创建本地账号
		User user = new User();
		user.setLoginName(userName);
		try {
			int addUser = userDao.addUser(user);
			if (addUser==1){
				res.setSuccess(true);
			}else{
				res.setSuccess(false);
				return res;
			}
		} catch (Exception e) {
			Log.error("新建本地账号失败：参数为：{},exception is:{}",user.toString(),e);
			res.setSuccess(false);
			return res;
		}
		return res;
	}

}
