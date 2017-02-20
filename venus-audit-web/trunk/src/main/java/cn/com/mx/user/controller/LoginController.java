/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 下午6:04:28
 */
package cn.com.mx.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mx.base.Contants;
import cn.com.mx.user.model.User;
import cn.com.mx.user.service.UserService;
import cn.com.mx.utils.CodeUtil;
import cn.com.mx.utils.ResultModel;

/**
 * @Description 登陆相关
 * @author kl_chaizhilei
 * @date 2016年1月28日 下午6:04:28
 */
@Controller
@Scope(value = "prototype")
@Slf4j
public class LoginController {

	// @Value("#{app.audit_domain}")
	// private String domain;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResultModel<Object> login(HttpServletRequest request, HttpServletResponse response, String check) {
		JSONObject jsonArray = JSONObject.fromObject(check);
		String account = jsonArray.get("account").toString();
		String password = jsonArray.get("password").toString();
		if (StringUtils.isBlank(account)) {
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "账号不能为空！");
		}
		if (StringUtils.isBlank(password)) {
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "密码不能为空！");
		}
		ResultModel<User> result = userService.loginUser(account, password);
		if (!result.getSuccess()) {
			log.error("failed to login with(account={},password={})", account);
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "账号或密码错误！");
		}
		User user = result.getData();
		request.getSession().setAttribute(Contants.SESSION_USERID, user.getId());
		// cookie CustomerLogin 设置为1,过期时间为30分钟
		// Cookie customerLogin = new Cookie(CUSTOMER_LOGIN,
		// CUSTOMER_LOGIN_VALUE);
		// customerLogin.setMaxAge(CUSTOMER_LOGIN_LIFE);
		// customerLogin.setPath("/"); // 在所有页面下都可见
		// customerLogin.setDomain(domain);
		// response.addCookie(customerLogin);
		return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, "");
	}

	/**
	 * @Description 退出登录
	 * @author kl_chaizhilei
	 * @date 2016年2月18日 下午6:00:56
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public ResultModel<Object> logout(HttpServletRequest request) {
		try {
			// 清除session
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, "");
		} catch (Exception e) {
			log.error("logout exception", e);
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "");
		}
	}

	@RequestMapping(value = "/auditinfo", method = RequestMethod.GET)
	@ResponseBody
	public ResultModel<Object> auditInfo(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute(Contants.SESSION_USERID);
			if (StringUtils.isBlank(userId)) {
				return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "");
			}
			ResultModel<User> user = userService.getUserById(userId);
			User userdata = user.getData();
			Map<String, Object> obj = new HashMap<String, Object>();
			if (null != userdata) {
				obj.put("account", userdata.getAccount());
				obj.put("id", userdata.getId());
			} else {
				return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "");
			}
			return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, obj);
		} catch (Exception e) {
			log.error("logout exception", e);
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "");
		}
	}

}
