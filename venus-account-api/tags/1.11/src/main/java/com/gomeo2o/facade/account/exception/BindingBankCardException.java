/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 下午5:18:29
 */
package com.gomeo2o.facade.account.exception;

import com.gomeo2o.common.exceptions.BizException;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 下午5:18:29
 */
public class BindingBankCardException {
	//数据校验异常 所有的校验异常都抛此异常，只是提示文字信息会不一样！
	public static final BizException ADD_DATA_EXCEP =  new BizException(310001, "数据异常");
	
	public static final BizException ADD_ALREADY_EXCEP = new BizException(310002, "此银行卡已经被绑定");
	
	public static final BizException UPDATE_BINGING_BANKCARD_ERROR = new BizException(310003, "修改银行卡错误");
	
}
