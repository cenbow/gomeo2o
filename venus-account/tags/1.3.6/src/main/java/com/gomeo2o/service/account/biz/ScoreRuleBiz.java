package com.gomeo2o.service.account.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreRule;
import com.gomeo2o.service.account.dao.ScoreRuleDao;
/**
 * 
 * @Description: 积分规则Biz
 * @author: fengxin
 * @date: 2015年3月20日 下午4:51:38
 */
@Service("scoreRuleBiz")
public class ScoreRuleBiz {
	
	@Autowired
	private ScoreRuleDao scoreRuleDao;
	/**
	 * 
	 * @Description: 查询积分规则列表 分页
     * @author: fengxin
     * @date: 2015年3月24日 上午10:34:16
     * @param pageParam
     * @return PageBean    
	 */
	public PageBean queryScoreRulesList(PageParam pageParam){
		return scoreRuleDao.listPage(pageParam, null);
	}
	/**
	 * 
	 * @Description: 根据ID 查询积分规则信息
     * @author: fengxin
     * @date: 2015年3月24日 上午10:37:47
     * @param scoreRule
     * @return ScoreRule    
	 */
	public ScoreRule queryScoreRuleByID(ScoreRule scoreRule){
		return scoreRuleDao.getById(scoreRule.getId());
	}
	/**
	 * 
	 * @Description: 修改积分规则信息
     * @author: fengxin
     * @date: 2015年3月24日 上午10:49:01
     * @param scoreRule
     * @return void    
	 */
	@Transactional
	public void updateScoreRule(ScoreRule scoreRule){
		scoreRuleDao.update(scoreRule);
	}
	/**
	 * 
	 * @Description: 新增积分规则
     * @author: fengxin
     * @date: 2015年3月30日 上午10:45:01
     * @param scoreRule
     * @return void    
	 */
	@Transactional
	public void addScoreRule(ScoreRule scoreRule){
		scoreRuleDao.insert(scoreRule);
	}
	/**
	 * 
	 * @Description: 积分规则下拉框List
     * @author: fengxin
     * @date: 2015年3月30日 上午11:31:42
     * @return List<ScoreRule>    
	 */
	public List<ScoreRule> findScoreRuleList(){
		return scoreRuleDao.listBy(null);
	}
	
}
