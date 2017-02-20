package com.gomeo2o.utils;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.json.JSON;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.exceptions.BizException;

/**
 * 
 * @Description: 日志基类
 * @author: fengxin
 * @date: 2015年4月7日 下午3:52:29
 */
public class LogAspect {
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	public void doAfter(JoinPoint jp) throws IOException {
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		log.info("log Begining method: "+ pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName());
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
			log.error("代码出错："+pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName());
			log.error("BizException code:" + e.getCode());
			log.error("exception message:" + e.getMessage(),e);
			exCom.setCode(e.getCode());
			exCom.setMessage(e.getMessage());
			rvt = exCom;
			//throw e;
		} catch (Exception e1) {
			log.error("代码出错："+pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName());
			log.error("Exception message:" + e1.getMessage(),e1);
			exCom.setCode(239999);
			exCom.setMessage(e1.getMessage());
			rvt = exCom;
			//throw e;
		}finally{
			try {
				//打印方法参数
				log.info("method Parameter:"+((null!=param)?JSON.json(param):""));
				//打印方法返回值
				log.info("method return value:"+((null!=rvt)?JSON.json(rvt):""));
			} catch (Exception e2) {
				log.error("log Ending method finally  error", e2);
			}
		}
		time = System.currentTimeMillis() - time;
		log.info("method process time: " + time + " ms");
		log.info("log Ending method: "+ pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName());
		return rvt;
	}

	public void doBefore(JoinPoint jp) throws IOException {
		
	}

	public void doThrowing(JoinPoint jp, Throwable ex) {
		
	}

}
