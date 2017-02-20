package cn.com.mx.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mx.base.entity.User;
import cn.com.mx.social.utils.StringUtils;
import cn.com.mx.user.service.IUserService;
import cn.com.mx.utils.CodeUtil;
import cn.com.mx.utils.ResultModel;



/**
 * 
 * @Description 用户管理 
 * @author zhangchunsheng
 * @date 2016年3月18日 下午4:03:05
 */
@Controller("user/userinfo")
@Scope(value = "prototype")
@Slf4j
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/queryuser")
	public ResultModel<List<User>> queryUser(User user) {
		ResultModel<List<User>> users = new ResultModel<List<User>>();
		try {
			
		}catch(Exception e) {
			
		}
		
		
		return users;
	}
	/**
	 * 
	 * @Description 创建客服账号 
	 * @author star
	 * @date 2016年3月18日 下午6:38:14
	 * @param request
	 * @param response
	 * @param check
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResultModel<Object> addUser(HttpServletRequest request, HttpServletResponse response, String check) {
		JSONObject jsonArray = JSONObject.fromObject(check);
		String userName = jsonArray.get("userName").toString();
		if (StringUtils.isBlank(userName)) {
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "账号不能为空！");
		}
		ResultModel<String> res = userService.addUser(userName);
		if (!res.getSuccess()) {
			log.error("failed to addUser with(userName={})", userName);
			return new ResultModel<Object>(false, CodeUtil.FAIL, CodeUtil.FAIL_MSG, "账号不存在！");
		}
		return new ResultModel<Object>(true, CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG, "");
	}
}
