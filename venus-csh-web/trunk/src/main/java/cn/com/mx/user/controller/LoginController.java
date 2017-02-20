/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午1:10:35
 */
package cn.com.mx.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.com.mx.base.entity.User;
import cn.com.mx.user.service.IUserService;
import cn.com.mx.utils.CodeUtil;
import cn.com.mx.utils.ResultModel;

/**
 * @Description 登录相关业务处理
 * @author guowenbo
 * @date 2016年3月18日 下午1:10:35
 */

@Controller
@Scope(value = "prototype")
@Slf4j
public class LoginController {

	@Autowired
	private IUserService userService;
	
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
		return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, "");
	}
}
