/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月22日 下午3:02:33
 */
package com.gomeo2o.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Description:账户常量类
 * @author:gongjiaming
 * @date: 2015年4月22日
 */
public class Constants {
	// 业务参数 
	//余额账户
	public static final String MONEY_TYPE = "1";
	// 积分账户
	public static final String SCORE_TYPE = "2";
	// 返利账户
	public static final String REBATE_TYPE = "3";
	//余额提现流水
	public static final String ADVANCE_TYPE = "4";
	//预算流水
	public static final String BUDGET_TYPE = "5";
	//优惠券流水
	public static final String COUPON_TYPE = "6";
	//明细流水号格式暂定位{#}{yyyyMMdd}{#######}共16位，前缀代表业务参数1/2/3/4
	//现金流水号序列名称
	public static final String MONEY_SEQ = "money_detail";
	//积分流水号序列名称
	public static final String SCORE_SEQ = "score_detail";
	//返利流水号序列名称
	public static final String REBATE_SEQ = "rebate_detail";
	//余额提现流水号序列名称
	public static final String ADVANCE_SEQ = "advance_detail";
	//预算流水号序列名称
	public static final String BUDGET_SEQ = "budget_detail";
	//优惠券流水号序列名称
	public static final String COUPON_SEQ = "coupon_detail";
	//商家返利
	public static final String MERCHANT="2";
	//平台返利
	public static final String PLATFORM="1";
	//积分埋点   分享返积分 code
	public static final String POINT_CODE_1 = "8981";
	//积分埋点   邀请注册返积分 code
	public static final String POINT_CODE_2 = "8982";
	//积分埋点   订单成功返积分 code
	public static final String POINT_CODE_3 = "8983";
	//积分埋点   评价/晒单返积分 code
	public static final String POINT_CODE_4 = "8984";
	//积分埋点   意见反馈返积分code
	public static final String POINT_CODE_5 = "8985";
	//按次返积分
	public static final String SCORE_RULE_STATE_1 = "1";
	//按比例返积分
	public static final String SCORE_RULE_STATE_2 = "2";
	//阶梯式满返积分
	public static final String SCORE_RULE_STATE_3 = "3";
	
	public static final String ADVANCE_SUCCESS = "4";
	
	public static final String ADCANCE_ERROR = "0";
	//用户国美币支付限制
	public static final String PAY_LIMIT_TYPE = "2";
	//用户国美币提现限制
	public static final String ADVACNE_LIMIT_TYPE = "1";
	//流水号长度（除业务参数/日期）
	public static final Integer DETAILNO_LENGTH = 7;
	//获取明细流水号
	public static final String getMoneyDetailNo() {
		return getNo(MONEY_TYPE, new Date(), MONEY_SEQ, DETAILNO_LENGTH);
	}
	public static final String getScoreDetailNo() {
		return getNo(SCORE_TYPE, new Date(), SCORE_SEQ, DETAILNO_LENGTH);
	}
	public static final String getRebateDetailNo() {
		return getNo(REBATE_TYPE, new Date(), REBATE_SEQ, DETAILNO_LENGTH);
	}
	public static final String getAdvanceDetailNo(){
		return getNo(ADVANCE_TYPE, new Date(), ADVANCE_SEQ, DETAILNO_LENGTH);
	}
	public static final String getCouponDetailNo(){
		return getNo(COUPON_TYPE, new Date(), COUPON_SEQ, DETAILNO_LENGTH);
	}
	public static final String getBudgetDetailNo(){
		return getNo(BUDGET_TYPE, new Date(), BUDGET_SEQ, DETAILNO_LENGTH);
	}
	/**
	 * 
	 * @Description: 生成流水号
     * @author: fengxin
     * @date: 2015年5月26日 上午11:19:14
     * @param prefix 第一位 业务参数
     * @param prefixDate 
     * @param name
     * @param length 长度
     * @return String    
	 */
	private static String getNo(String prefix, Date prefixDate, String name, int length) {
		StringBuilder result = new StringBuilder(prefix);
		result.append((new SimpleDateFormat("yyyyMMdd")).format(prefixDate));
		result.append(ZKSeqUtil.getInstance().getSeqByFixedLength(name, length));
		return result.toString();
	}
	
}
