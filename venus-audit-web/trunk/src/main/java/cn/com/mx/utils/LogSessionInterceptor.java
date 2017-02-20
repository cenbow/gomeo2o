package cn.com.mx.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gomeo2o.common.constant.BaseConstants;


/**
 * @Description: 增加session,区分每次请求
 * @author: wanggang-ds6
 * @date: 2015年8月5日 上午11:19:32
 */
public class LogSessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 创建回话id
		String logSessionId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		// 设置会话id
		MDC.put(BaseConstants.LOG_SESSION_ID, logSessionId);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 删除会话id
		MDC.remove(BaseConstants.LOG_SESSION_ID);	
	}
	
}
