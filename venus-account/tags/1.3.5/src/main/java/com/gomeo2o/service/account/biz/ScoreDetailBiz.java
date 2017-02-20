/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月16日 下午4:53:06
 */
package com.gomeo2o.service.account.biz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreDetail;
import com.gomeo2o.facade.account.entity.ScorePoint;
import com.gomeo2o.facade.account.entity.ScoreRule;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.service.account.dao.ScoreDetailDao;
import com.gomeo2o.service.account.dao.ScorePointDao;
import com.gomeo2o.service.account.dao.ScoreRuleDao;
import com.gomeo2o.utils.Constants;

/**
 * @Description:账户积分明细Biz
 * @author:gongjiaming
 * @date: 2015年4月16日
 */
@Service("scoreDetailBiz")
public class ScoreDetailBiz {

	@Autowired
	private ScoreDetailDao scoreDetailDao;
	@Autowired
	private ScorePointDao scorePointDao;
	@Autowired
	private ScoreRuleDao scoreRuleDao;
	/**
	 * @Description: 增加账户积分明细
	 * @author: gongjiaming
	 * @date: 2015年4月17日
	 * @param accountScoreDetail
	 */
	public long addAccountScoreDetail(ScoreDetail accountScoreDetail){
		return scoreDetailDao.insert(accountScoreDetail);
	}
	/**
	 * @Description: 修改账户积分明细状态
	 * @author: gongjiaming
	 * @date: 2015年4月17日
	 * @param accountScoreDetail
	 */
	public long updateScoreDetailState(ScoreDetail scoreDetail){
		return scoreDetailDao.update(scoreDetail);
	}
	/**
     *  
	 * @Description: 增加积分明细流水
     * @author: fengxin
     * @date: 2015年4月30日 下午2:39:05
     * @param scoreDetail
     * @return void    
	 */
	public void addScoreDetail(ScoreDetail scoreDetail){
		this.scoreDetailDao.insert(scoreDetail);
	}
	/**
	 * 
	 * @Description: 积分明细列表查询  带分页 条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:34:23
     * @param reqParam
     * @param pageParam
     * @return List<ScoreDetail>    
	 */
	@SuppressWarnings("unchecked")
	public List<ScoreDetail> queryScoreDetailByParamer(Map<String,Object> reqParam,PageParam pageParam){
		return (List<ScoreDetail>) this.scoreDetailDao.listPage(pageParam, reqParam);
	}
	/**
	 * 
	 * @Description: 积分获取明细列表
     * @author: fengxin
     * @date: 2015年3月25日 下午6:11:46
     * @param pageParam
     * @return PageBean    
	 */
	public PageBean queryScoreDetalList(PageParam pageParam,ScoreDetail scoreDetail){
		return scoreDetailDao.queryScoreDetalList(pageParam,scoreDetail);
	}
	/**
	 * 
	 * @Description: 根据积分买点创建非实时入账积分流水
     * @author: fengxin
     * @date: 2015年6月1日 上午11:32:20
     * @param reqParam
     * @return void    
	 */
	@Transactional
	public void createScoreDetailByPoint(Map<String,Object> reqParam){
		//获取积分买点
		ScorePoint scorePoint = scorePointDao.listBy(reqParam).get(0);
		if(scorePoint!=null){
			ScoreRule scoreRule = scoreRuleDao.getById(scorePoint.getRuleId());
			if(scoreRule!=null){
				String recordValue = calActualScore(scorePoint,scoreRule,reqParam);
				if(recordValue==null&&"".equals(recordValue)){
					throw AccountException.SCORE_VALUE_IS_NULL;
				}else if("0".equals(recordValue)){
					throw AccountException.SCORE_VALUE_IS_ZERO;
				}else{
					reqParam.put("recordValue", recordValue);
					reqParam.put("ruleId", scoreRule.getId());
					reqParam.put("pointId", scorePoint.getId());
					reqParam.put("detailNo", Constants.getScoreDetailNo());
					reqParam.put("state", 0);
					reqParam.put("dealTime", new Date());
					Calendar c=Calendar.getInstance();
					c.setTime(new Date());   
					c.add(Calendar.DATE,scoreRule.getRecordTimeStr());
					reqParam.put("recordTime", c.getTime());
					this.scoreDetailDao.addScoreDetail(reqParam);
				}
			}else{
				throw AccountException.SCORE_RULE_NULL;
			}
		}else{
			throw AccountException.SCORE_POINT_NULL;
		}
	}
	/**
	 * 
	 * @Description: 计算实际入账积分值
     * @author: fengxin
     * @date: 2015年6月1日 下午2:44:17
     * @param scorePoint
     * @param scoreRule
     * @param map
     * @return String    
	 */
	public static String calActualScore(ScorePoint scorePoint,ScoreRule scoreRule,Map<String,Object> map){
		//判断积分规则有效期
		if(scoreRule.getEndTime().getTime()>=new Date().getTime()&&new Date().getTime()>=scoreRule.getStartTime().getTime()){
			//分享返积分
			if(scorePoint.getCode().equals(Constants.POINT_CODE_1)){
				return scoreRule.getRecordValue();
			}
			// 邀请注册返积分 
			if(scorePoint.getCode().equals(Constants.POINT_CODE_2)){
				return scoreRule.getRecordValue();
			}
			// 订单成功返积分||评价/晒单返积分
			if(scorePoint.getCode().equals(Constants.POINT_CODE_3)||scorePoint.getCode().equals(Constants.POINT_CODE_4)){
				//订单金额是否为空
				if(map.get("orderMoney")!=null&&!"".equals(map.get("orderMoney"))){
					//订单金额转换为元
					double  orderMoney = ((Integer)map.get("orderMoney"))/100;
					if(scoreRule.getRuleState().toString().equals(Constants.SCORE_RULE_STATE_2)){
						return String.valueOf((int)Math.floor(orderMoney*Double.valueOf(scoreRule.getRecordValue())/100));
					}else if(scoreRule.getRuleState().toString().equals(Constants.SCORE_RULE_STATE_3)){
						//10,5,100,20
						String[] s = scoreRule.getRecordValue().split(",");
						if(s.length==2){
							if(orderMoney>=Integer.parseInt(s[0])){
								return s[1];
							}else{
								return "0";
							}
						}else if(s.length==4){
							if(orderMoney>=Integer.parseInt(s[2])){
								return s[3];
							}else if(orderMoney>=Integer.parseInt(s[0])){
								return s[1];
							}else{
								return "0";
							}
						}
					}
				}else{
					throw AccountException.ORDER_MONEY_IS_NULL;
				}
			}
			// 意见反馈返积分
			if(scorePoint.getCode().equals(Constants.POINT_CODE_5)){
				return scoreRule.getRecordValue();
			}
		}else{
			throw AccountException.SCORE_RULE_TIME_OUT;
		}
		return "0";
	}
	/**
	 * @Description 获取不同状态积分总值
	 * @author fengxin
	 * @date 2015年12月1日 下午6:37:38
	 * @param map
	 * @return
	 */
	public Long queryScoreTotal(Map<String,Object> map){
		return scoreDetailDao.queryScoreTotal(map);
	}
}
