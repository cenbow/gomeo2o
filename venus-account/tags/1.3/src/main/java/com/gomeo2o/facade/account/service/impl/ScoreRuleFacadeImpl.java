package com.gomeo2o.facade.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreRule;
import com.gomeo2o.facade.account.service.ScoreRuleFacade;
import com.gomeo2o.facade.account.utils.ValidateService;
import com.gomeo2o.service.account.biz.ScoreRuleBiz;
/**
 * 
 * @Description: 积分规则Service实现
 * @author: fengxin
 * @date: 2015年3月20日 下午4:43:14
 */
@Service("scoreRuleFacade")
public class ScoreRuleFacadeImpl implements ScoreRuleFacade{
	
	@Autowired
	private ScoreRuleBiz scoreRuleBiz;
	
	/**
	 * 
	 * @Description: 查询积分规则列表 分页
     * @author: fengxin
     * @date: 2015年3月24日 上午10:34:16
     * @param pageParam
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryScoreRulesList(PageParam pageParam){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(scoreRuleBiz.queryScoreRulesList(pageParam));
		return crs;
	}
	/**
	 * 
	 * @Description: 根据ID 查询积分规则信息
     * @author: fengxin
     * @date: 2015年3月24日 上午10:37:47
     * @param scoreRule
     * @return CommonResultEntity<ScoreRule>
	 */
	public CommonResultEntity<ScoreRule> queryScoreRuleByID(ScoreRule scoreRule){
		CommonResultEntity<ScoreRule> crs = new CommonResultEntity<ScoreRule>();
		crs.setBusinessObj(scoreRuleBiz.queryScoreRuleByID(scoreRule));
		return crs;
	}
	/**
	 * 
	 * @Description: 修改积分规则信息
     * @author: fengxin
     * @date: 2015年3月24日 上午10:49:01
     * @param scoreRule
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> updateScoreRule(ScoreRule scoreRule){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateService.valid(scoreRule);
		scoreRuleBiz.updateScoreRule(scoreRule);
		return crs;
	}
	/**
	 * 
	 * @Description: 新增积分规则
     * @author: fengxin
     * @date: 2015年3月30日 上午10:45:01
     * @param scoreRule
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> addScoreRule(ScoreRule scoreRule){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateService.valid(scoreRule);
		scoreRuleBiz.addScoreRule(scoreRule);
		return crs;
	}
	/**
	 * 
	 * @Description: 积分规则下拉框List
     * @author: fengxin
     * @date: 2015年3月30日 上午11:31:42
     * @return CommonResultEntity<List<ScoreRule>>
	 */
	public CommonResultEntity<List<ScoreRule>> findScoreRuleList(){
		CommonResultEntity<List<ScoreRule>> crs = new CommonResultEntity<List<ScoreRule>>();
		crs.setBusinessObj(scoreRuleBiz.findScoreRuleList());
		return crs;
	}
}
