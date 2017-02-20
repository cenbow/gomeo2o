package cn.com.mx.utils;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.MDC;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSONObject;
import com.gomeo2o.common.constant.BaseConstants;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.exceptions.BizException;

/**
 * @Description: 通用日志切面 
 * @author: wanggang-ds6
 * @date: 2015年8月5日 下午3:04:17
 */
@Slf4j
public class LogsAspect {
	
	public void doAfter(JoinPoint jp) throws IOException {
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		
		// 设置会话id，用于log输出
		String logSessionId = RpcContext.getContext().getAttachment(BaseConstants.LOG_SESSION_ID);
		/*
		 *  如果logSessionId为空则不进行赋值
		 *  防止业务逻辑自己调用其他方法再次经过切面时，将空值赋给MDC，导致之后日志无logSessionId
		 */
		if (logSessionId != null && logSessionId.trim().length() > 0) {
			MDC.put(BaseConstants.LOG_SESSION_ID, logSessionId);
		}	
	
		log.info("log Begining method: {}.{}",pjp.getTarget().getClass().getName(),pjp.getSignature().getName());
		CommonResultEntity<String> exCom = new CommonResultEntity<String>();
		long time = System.currentTimeMillis();
		//方法返回对象
		Object rvt = null;
		//方法参数对象
		Object[] param = null;
		try {
			rvt = pjp.proceed();
			param = pjp.getArgs();
		} catch (BizException e) {
			log.error("代码出错：{}.{}",pjp.getTarget().getClass().getName(),pjp.getSignature().getName(), e);
			exCom.setCode(e.getCode());
			exCom.setMessage(e.getMessage());
			rvt = exCom;
			//throw e;
		} catch (Exception e1) {
			log.error("代码出错：{},{}",pjp.getTarget().getClass().getName() , pjp.getSignature().getName(), e1);
			exCom.setCode(999999);
			exCom.setMessage("服务异常");
			rvt = exCom;
			//throw e;
		}finally{
			try {
				//打印方法参数
				log.info("method Parameter:{}",((null!=param)?JSONObject.toJSONString(param):""));
				//打印方法返回值
				log.info("method return value:{}",((null!=rvt)?JSONObject.toJSONString(rvt):""));
			} catch (Exception e2) {
				log.error("log Ending method finally  error {}", e2);
			}
			time = System.currentTimeMillis() - time;
			log.info("method process time: {}ms" , time);
			log.info("log Ending method: {}.{}", pjp.getTarget().getClass().getName() , pjp.getSignature().getName());
			
			// 删除会话id
			MDC.remove(BaseConstants.LOG_SESSION_ID);	
		}
		return rvt;
	}

	public void doBefore(JoinPoint jp) throws IOException {
		
	}

	public void doThrowing(JoinPoint jp, Throwable ex) {
		
	}

}
