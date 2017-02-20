package cn.com.mx.webapi.common.service;

import static cn.com.mx.webapi.common.exceptions.BaseExceptionMessage.CHECK_DATA_FAILED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCommands;
import cn.com.gome.user.service.UserBaseInfoFacade;
import cn.com.mx.webapi.common.annotation.LoggedInProcessor;
import cn.com.mx.webapi.common.constant.CommonConstant;
import cn.com.mx.webapi.common.constant.PublicParamsConstant;
import cn.com.mx.webapi.common.exceptions.code.C401Exception;
import cn.com.mx.webapi.common.exceptions.code.C422Exception;
import cn.com.mx.webapi.common.exceptions.code.C500Exception;
import cn.com.mx.webapi.common.model.PublicParams;
import cn.com.mx.webapi.common.servlet.BaseResource;
import cn.com.mx.webapi.common.utils.ResourceParameters;

import com.gomeo2o.common.redis.SimpleJedisTemplate;
import com.gomeo2o.common.redis.SimpleJedisTemplate.RedisCallback;

/**
 * @Description 检测服务 
 * @author wanggang-ds6
 * @date 2016年1月22日 下午1:38:14
 */
@Service
public class CheckService {
		
	@Autowired
	private SimpleJedisTemplate simpleJedisTemplate;
	
	@Autowired
	private UserBaseInfoFacade userBaseInfoFacade; //会员

	/**
	 * @Description 检测登录 
	 * @author wanggang-ds6
	 * @date 2016年1月22日 下午1:39:36
	 */
	public void checkLogin(ResourceParameters servletParam ,BaseResource controller, String methodName,  Class<?>... parameterTypes) {
		boolean needLogIn = false;
		try {
			needLogIn = LoggedInProcessor.needLogIn(controller, methodName, parameterTypes);
		} catch (Exception e) {
			throw new C500Exception(e);
		}
		if (needLogIn == true) {
			PublicParams publicParams = (PublicParams) servletParam.get(PublicParamsConstant.PUBLIC_PARAMS_NAME);
			if (publicParams == null) {
				throw new C500Exception();
			}
			final String token = publicParams.getToken();
			if (token == null || token.length() == 0) {
				throw new C422Exception(
						CHECK_DATA_FAILED.setArgs(PublicParamsConstant.X_GOMEPLUS_TOKEN + "不能为空！"));
			}
			String userId = simpleJedisTemplate.execute(new RedisCallback<String>() {
				@Override
				public String doInRedis(JedisCommands commands) {
					return commands.get(CommonConstant.USER_TOKEN_KEY + token);
				}
				
			});
			if (userId != null && userId.trim().length() > 0) {
				servletParam.put("userId", Long.parseLong(userId));
			} else {
				throw new C401Exception();
			}			
		}
	}
}
