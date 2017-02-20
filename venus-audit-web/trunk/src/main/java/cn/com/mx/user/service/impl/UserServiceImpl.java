/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 下午3:18:43
 */
package cn.com.mx.user.service.impl;

import io.terminus.common.exception.ServiceException;
import io.terminus.ecp.user.util.Password;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.com.mx.user.dao.UserDao;
import cn.com.mx.user.model.User;
import cn.com.mx.user.service.UserService;
import cn.com.mx.utils.CodeUtil;
import cn.com.mx.utils.ResultModel;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.google.common.base.Throwables;

/**
 * @Description 审核用户实现
 * @author kl_chaizhilei
 * @date 2016年1月28日 下午3:18:43
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResultModel<Boolean> saveUser(User user) {
		ResultModel<Boolean> res = new ResultModel<Boolean>();
		boolean falg = userDao.save(user) == null ? false : true;
		if (falg) {
			return res;
		} else {
			res.setCode(CodeUtil.ADD_FAIL);
			res.setMessage(CodeUtil.ADD_FAIL_MSG);
			return res;
		}
	}

	@Override
	public ResultModel<User> getUser(String account) {
		ResultModel<User> res = new ResultModel<User>();
		Query query = new Query();
		query.addCriteria(Criteria.where("account").is(account));
		User user = userDao.findOne(query);
		res.setData(user);
		return res;
	}

	@Override
	public ResultModel<User> loginUser(String account, String password) {
		ResultModel<User> res = new ResultModel<User>();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("account").is(account));
			User user = userDao.findOne(query);
			if (null != user) {
				if (checkUser(account, password, Boolean.TRUE, user)) {
					res.setData(user);
					return res;
				} else {
					res.setSuccess(Boolean.FALSE);
					res.setCode(CodeUtil.FAIL);
					res.setMessage("账号或密码错误");
					return res;
				}
			} else {
				res.setSuccess(Boolean.FALSE);
				res.setCode(CodeUtil.FAIL);
				res.setMessage("账户不存在");
				return res;
			}
		} catch (Exception e) {
			log.error("failed to login(account={}), cause: {}", account, Throwables.getStackTraceAsString(e));
			res.setCode(CodeUtil.FAIL);
			res.setMessage(CodeUtil.FAIL_MSG);
			return res;
		}
	}

	/**
	 * 
	 * @Description 校验密码
	 * @author kl_chaizhilei
	 * @date 2016年1月29日 上午10:47:24
	 * @param loginBy
	 * @param passwd
	 * @param checkPass
	 * @param user
	 */
	private boolean checkUser(String loginBy, String passwd, boolean checkPass, User user) {
		if (user == null) {
			log.error("user(loginBy={}) isn't existed.", loginBy);
			throw new ServiceException("user.not.exist");
		}
		if (checkPass && !Password.match(passwd, user.getPassword())) {
			log.error("user(loginBy={}) password isn't matched.", loginBy);
			return false;
		}
		return true;
	}

	@Override
	public ResultModel<User> getUserById(String id) {
		ResultModel<User> res = new ResultModel<User>();
		User user = userDao.findById(id);
		res.setData(user);
		return res;
	}

	/**
	 * @Description 查询所有用户
	 * @author kl_chaizhilei
	 * @date 2016年2月23日 下午2:08:57
	 * @return
	 */
	@Override
	public ResultModel<Object> getAllUserByName(String name,PageParam page) {
		ResultModel<Object> res = new ResultModel<Object>();
		try {
			Query query = new Query();
			PageBean findPageForPageBean = null;
			if (StringUtils.isNotBlank(name)) {
				query.addCriteria(Criteria.where("account").is(name));
				findPageForPageBean = userDao.findPageForPageBean(page, query);
			} else {
				findPageForPageBean = userDao.findPageForPageBean(page,query);
			}
			if (null != findPageForPageBean) {
				res.setData(findPageForPageBean);
			}
			return res;
		} catch (Exception e) {
			res.setCode(CodeUtil.FAIL);
			res.setMessage(CodeUtil.FAIL_MSG);
			return res;
		}
	}

	@Override
	public ResultModel<Boolean> updateStatus(String userId, int status, String updateUserId) {
		ResultModel<Boolean> res = new ResultModel<Boolean>();
		try {
			this.userDao.update(new Query(Criteria.where("id").is(userId)), Update.update("status", status).set("updateTime", new Date()).set("updateOperator",updateUserId));	
		} catch (Exception e) {
			res.setCode(CodeUtil.UPDATE_FAIL);
			res.setMessage(CodeUtil.UPDATE_FAIL_MSG);
			return res;
		}
		return res;
	}

}
