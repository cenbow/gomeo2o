/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: wangyunpeng
 * @date: 2015年4月10日下午1:58:27
 */
package com.gomeo2o.facade.account.exception;

import com.gomeo2o.common.exceptions.BizException;

/**
 * @Description: 积分模块异常处理类
 * @author: wangyunpeng
 * @date: 2015年4月10日下午1:58:27
 */
public class ScoreException  extends BizException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1912426368446583523L;
	
	public static final BizException SCORE_IS_OUT_TIME = new BizException(230001, "会话超时");
	//数据校验异常 所有的校验异常都抛此异常，只是提示文字信息会不一样！
	public static final BizException CHECK_FAILE =  new BizException(230002, "数据校验异常");
	//服务器异常
	public static final BizException SERVER_FAILE =  new BizException(239999, "服务器异常");


}
