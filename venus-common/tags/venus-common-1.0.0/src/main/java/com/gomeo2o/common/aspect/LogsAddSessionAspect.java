package com.gomeo2o.common.aspect;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.slf4j.MDC;

import com.alibaba.dubbo.rpc.RpcContext;
import com.gomeo2o.common.constant.BaseConstants;

/**
 * @Description: 增加日志标识切面 
 * @author: wanggang-ds6
 * @date: 2015年8月6日 下午2:45:27
 */
public class LogsAddSessionAspect {

	public void doBefore(JoinPoint jp) throws IOException {
		// 设置会话id，用于log输出
		String logSessionId = RpcContext.getContext().getAttachment(BaseConstants.LOG_SESSION_ID);
		MDC.put(BaseConstants.LOG_SESSION_ID, logSessionId);	
	}
	
}
