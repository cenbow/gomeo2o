package com.gomeo2o.facade.account.service;

import java.util.List;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreRule;

/**
 * @Description: 积分规则facade
 * @author: fengxin
 * @date: 2015年3月20日 下午4:41:29
 */
public interface ScoreRuleFacade {
	
	/**
	 * @Description: 查询积分规则列表 分页
     * @author: fengxin
     * @date: 2015年3月24日 上午10:34:16
     * @param pageParam
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryScoreRulesList(PageParam pageParam);
	/**
	 * 
	 * @Description: 根据ID 查询积分规则信息
     * @author: fengxin
     * @date: 2015年3月24日 上午10:37:47
     * @param scoreRule
     * @return CommonResultEntity<ScoreRule>    
	 */
	public CommonResultEntity<ScoreRule> queryScoreRuleByID(ScoreRule scoreRule);
	/**
	 * 
	 * @Description: 修改积分规则信息
     * @author: fengxin
     * @date: 2015年3月24日 上午10:49:01
     * @param scoreRule
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateScoreRule(ScoreRule scoreRule);
	/**
	 * 
	 * @Description: 新增积分规则
     * @author: fengxin
     * @date: 2015年3月30日 上午10:45:01
     * @param scoreRule
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addScoreRule(ScoreRule scoreRule);
	/**
	 * 
	 * @Description: 积分规则下拉框List
     * @author: fengxin
     * @date: 2015年3月30日 上午11:31:42
     * @return CommonResultEntity<List<ScoreRule>>
	 */
	public CommonResultEntity<List<ScoreRule>> findScoreRuleList();

}
