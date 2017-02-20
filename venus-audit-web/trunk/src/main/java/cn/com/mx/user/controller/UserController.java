/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午10:43:02
 */
package cn.com.mx.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mx.base.BaseController;
import cn.com.mx.user.dto.UserListDto;
import cn.com.mx.user.enums.UserStatusEnum;
import cn.com.mx.user.model.User;
import cn.com.mx.user.service.UserService;
import cn.com.mx.utils.CodeUtil;
import cn.com.mx.utils.DateUtils;
import cn.com.mx.utils.Password;
import cn.com.mx.utils.ResultModel;
import cn.com.mx.utils.ResultModelData;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;

/**
 * @Description 审核用户管理
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午10:43:02
 */
@Controller
@RequestMapping("/user")
@Scope(value = "prototype")
@Slf4j
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("/save")
	@ResponseBody
	public ResultModel<Object> saveUser(HttpServletRequest request, String check) {
		User user = new User();
		JSONObject jsonArray = JSONObject.fromObject(check);
		String account = jsonArray.get("account").toString();
		String password = jsonArray.get("password").toString();
		if (StringUtils.isBlank(account)) {
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "账号不能为空！");
		}
		//校验账号唯一性
		ResultModel<User> hisUser = userService.getUser(account);
		if (null != hisUser.getData()) {
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "账号已存在!");
		}
		if (StringUtils.isBlank(password)) {
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "密码不能为空！");
		}
		// if (user.getTel() == null || user.getTel().equals("")) {
		// return JsonUtil.buildJsonRtnEro("手机号不能为空!");
		// }
		// String reg = "^1[3|5|8]\\d{9}$";
		// if
		// (!Pattern.compile(reg).matcher(user.getTel().toLowerCase()).find()) {
		// return JsonUtil.buildJsonRtnEro("请输入正确的手机号!");
		// }
		user.setAccount(account);
		user.setPassword(Password.encrypt(password));
		user.setStatus(UserStatusEnum.ACTIVE.getValue());
		// TODO 从session中获取id
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		user.setCreateOperator(userId);
		user.setCreateTime(new Date());
		ResultModel<Boolean> saveUser = null;
		try {
			saveUser = userService.saveUser(user);
			if (saveUser.getSuccess() != Boolean.TRUE) {
				return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "添加账号失败!");
			}
		} catch (Exception e) {
			log.error("新增用户失败", e);
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "添加账号失败!");
		}
		return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, "");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/findUser")
	@ResponseBody()
	public ResultModelData<Object> findUser(String aoData, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String userId = (String)session.getAttribute("userId");
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		List<UserListDto> uList = new ArrayList<UserListDto>();
		String account = jsonArray.getString("account");
		int pageNum = jsonArray.getInt("iDisplayStart");
		int numPerPage = jsonArray.getInt("iDisplayLength");
		PageParam pageParam = new PageParam();
		pageParam.setPageNum(pageNum/numPerPage+1);
		pageParam.setNumPerPage(numPerPage);
		// 查询所有的账户
		ResultModel<Object> allUser = userService.getAllUserByName(account,pageParam);
		if (allUser.getSuccess() == Boolean.TRUE) {
			PageBean pageData = (PageBean) allUser.getData();
			List<User> userList = (List<User>) pageData.getRecordList();
			if (CollectionUtils.isNotEmpty(userList)) {
				for (User user : userList) {
					UserListDto dto = new UserListDto();
					dto.setId(user.getId());
					dto.setAccount(user.getAccount());
					dto.setCreateTime(user.getCreateTime() == null ? ""
							: DateUtils.formatDatetime(user.getCreateTime()));
					ResultModel<User> createUserRes = this.userService.getUserById(user.getCreateOperator());
					User createUser = createUserRes.getData();
					dto.setCreaterName(createUser == null ? "" : createUser.getAccount());
					dto.setStatus(user.getStatus());
					uList.add(dto);
				}
			}
			return new ResultModelData<Object>(jsonArray, pageData.getTotalCount(), pageData.getTotalCount(), uList);
		}
		return new ResultModelData<Object>(jsonArray, 0, 0, uList); 
	}
	
	@RequestMapping("/updatestatus")
	@ResponseBody
	public ResultModel<Object> update(HttpServletRequest request, String check) {
		JSONObject jsonArray = JSONObject.fromObject(check);
		String userId = jsonArray.get("check").toString();
		String status = jsonArray.get("status").toString();
		String updateUserId = jsonArray.get("auditUserId").toString();
		if (StringUtils.isBlank(userId)) {
			return new ResultModel<Object>(true, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "更新失败了！");
		}
		if (StringUtils.isBlank(updateUserId)) {
			return new ResultModel<Object>(true, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "更新失败了！");
		}
		if(userId.equals(updateUserId)){
			return new ResultModel<Object>(true, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "无权更新自己信息！");
		}
		ResultModel<Boolean> updateUser = null;
		try {
			updateUser = userService.updateStatus(userId, Integer.parseInt(status), updateUserId);
			if (updateUser.getSuccess() != Boolean.TRUE) {
				return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "操作失败!");
			}
		} catch (Exception e) {
			log.error("操作用户失败失败", e);
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "操作用户失败失败!");
		}
		return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, "");
	}
	
	@RequestMapping("/initadmin")
	@ResponseBody
	public ResultModel<Object> initAdmin(HttpServletRequest request) {
		User user = new User();
		String account = "admin";
		String password = "123456";
		user.setAccount(account);
		//校验账号唯一性
		ResultModel<User> hisUser = userService.getUser(account);
		if (null != hisUser.getData()) {
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "账号已存在!");
		}
		user.setPassword(Password.encrypt(password));
		user.setStatus(UserStatusEnum.ACTIVE.getValue());
		user.setCreateTime(new Date());
		ResultModel<Boolean> saveUser = null;
		try {
			saveUser = userService.saveUser(user);
			if (saveUser.getSuccess() != Boolean.TRUE) {
				return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "添加账号失败!");
			}
		} catch (Exception e) {
			log.error("新增用户失败", e);
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "添加账号失败!");
		}
		return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, "");
	}

}
