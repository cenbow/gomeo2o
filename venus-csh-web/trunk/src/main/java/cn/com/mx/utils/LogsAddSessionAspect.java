package cn.com.mx.utils;

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
		
		/*
		 *  如果logSessionId为空则不进行赋值
		 *  防止业务逻辑自己调用其他方法再次经过切面时，将空值赋给MDC，导致之后日志无logSessionId
		 */
		if (logSessionId != null && logSessionId.trim().length() > 0) {
			MDC.put(BaseConstants.LOG_SESSION_ID, logSessionId);
		}			
	}
	
}
