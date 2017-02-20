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
 * 
 * @Description: 异常处理基类
 * @author: fengxin
 * @date: 2015年4月17日 下午3:12:51
 */
public class AccountException{
	
	public static final BizException ACCOUNT_IS_OUT_TIME = new BizException(110001, "会话超时");
	//数据校验异常 所有的校验异常都抛此异常，只是提示文字信息会不一样！
	public static final BizException CHECK_FAILE =  new BizException(110002, "数据校验异常");
	//未知账户类型
	public static final BizException UNKNOWN_ACCOUNT_TYPE =  new BizException(110003, "未知账户类型");
	//数据库记录更新，如尝试3次失败，提示用户
	public static final BizException SAVE_ACCOUNT_FAILE =  new BizException(11004, "交易明细获取失败，请重试");
	//现金账户余额不足
	public static final BizException EXCEED_BALANCE =  new BizException(110005, "账户余额不足");
	//接口传入参数对象为空
	public static final BizException REQLIST_ERROE =  new BizException(110006, "传入参数对象为空");
	//接口传入参数对象为空
	public static final BizException BUDGET_UPDATE_ERROE =  new BizException(110007, "预算信息修改失败");
	//接口传入参数对象为空
	public static final BizException BUDGET_NOLL_ERROE =  new BizException(110008, "未查询到对象");
	//用户密码修改失败
	public static final BizException USER_PASSWORD_ERROE =  new BizException(110009, "用户支付密码修改失败");
	//用户不存在
	public static final BizException USER_NO_FIND =  new BizException(110010, "用户、账户不存在");
	//用户创建失败
	public static final BizException USER_CREATE_FIND =  new BizException(110011, "用户创建失败");
	//积分埋点获取失败
	public static final BizException SCORE_POINT_NULL =  new BizException(110012, "积分埋点不存在");
	//积分埋点获取失败
	public static final BizException SCORE_RULE_NULL =  new BizException(110012, "积分埋点不存在");
	//积分规则有效期已过
	public static final BizException SCORE_RULE_TIME_OUT = new BizException(110013, "积分规则有效期已过");
	//积分获取值计算失败
	public static final BizException SCORE_VALUE_IS_NULL = new BizException(110014, "积分值计算失败");
	//积分获取值计算失败
	public static final BizException SCORE_VALUE_IS_ZERO = new BizException(110015, "不满足返积分规则");
	
	public static final BizException ORDER_MONEY_IS_NULL = new BizException(110016, "订单金额为空");
	//获取用户开户行姓名失败
	public static final BizException USER_NO_CARD = new BizException(110017, "用户未绑定银行卡，无法获取开户行姓名");
	//国美币提现失败
	public static final BizException ADVANCE_RB_ERROR = new BizException(110018, "国美币提现失败");
	//提现流水创建失败
	public static final BizException ADVANCE_DETAIL_ERROR = new BizException(110019, "提现流水创建失败");
	//提现操作账户失败
	public static final BizException ADVANCE_ACCOUT_ERROR = new BizException(110020, "提现操作账户失败");
	//提现流水状态修改失败
	public static final BizException ADVANCE_STATE_ERROR = new BizException(110021, "提现流水状态修改失败");
	//提现流水状态修改失败
	public static final BizException ADVANCE_SAP_SEND_ERROR = new BizException(110021, "提现流水推送SAP失败");
	//账户支付密码错误次数超过5此
	public static final BizException ACCOUNT_PAYPASSWORD_OUTNO = new BizException(110022, "账户支付密码错误次数已经超过最大次数，请明天再试");
	//国美币交易校验位置业务类型
	public static final BizException UN_KNOW_LIMIT_TYPE = new BizException(110023, "国美币交易校验额度，未知业务类型");
	//国美币交易限额对象为空
	public static final BizException LIMIT_TYPE_OBJECT_IS_NULL = new BizException(110024, "国美币交易限额对象为空");
	//国美币交易超出当日交易次数
	public static final BizException LIMIT_DAY_COUNT_IS_OVER = new BizException(110025, "国美币交易次数超过日上限");
	//国美币交易额超过日上限
	public static final BizException LIMIT_DAY_TOP_IS_OVER = new BizException(110026, "国美币交易额超过日上限");
	//国美币交易额超过月上限
	public static final BizException LIMIT_MONTH_TOP_IS_OVER = new BizException(110027, "国美币交易额超过月上限");
	//国美币交易额超过单笔上限
	public static final BizException LIMIT_SINGLE_TOP_IS_OVER = new BizException(110028, "国美币交易额不符合单笔单机交易限额");
	//国美币交易校验未知业务日期
	public static final BizException UN_KNOW_LIMIT_DATE = new BizException(110023, "国美币交易校验额度，未知业务类型");
	//服务器异常
	public static final BizException SERVER_FAILE =  new BizException(119999, "服务器异常");


}
