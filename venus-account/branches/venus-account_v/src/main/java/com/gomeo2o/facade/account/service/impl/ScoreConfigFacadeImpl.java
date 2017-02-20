package com.gomeo2o.facade.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreConfig;
import com.gomeo2o.facade.account.service.ScoreConfigFacade;
import com.gomeo2o.facade.account.utils.ValidateService;
import com.gomeo2o.service.account.biz.ScoreConfigBiz;
/**
 * 
 * @Description: 积分配置Service实现
 * @author: fengxin
 * @date: 2015年3月20日 下午4:43:14
 */
@Service("scoreConfigFacade")
public class ScoreConfigFacadeImpl implements ScoreConfigFacade{
	
	@Autowired
	private ScoreConfigBiz scoreConfigBiz;
	
	/**
	 * 
	 * @Description: 查询积分配置列表list
     * @author: fengxin
     * @date: 2015年3月25日 上午11:14:58
     * @param pageParam
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryScoreConfigList(PageParam pageParam){
		CommonResultEntity<PageBean> cre = new CommonResultEntity<PageBean>();
		cre.setBusinessObj(scoreConfigBiz.queryScoreConfigList(pageParam));
		return cre;
	}
	/**
	 * 
	 * @Description: 根据id查询ScoreConfig
     * @author: fengxin
     * @date: 2015年3月25日 上午11:19:47
     * @param scoreConfig
     * @return CommonResultEntity<ScoreConfig>
	 */
	public CommonResultEntity<ScoreConfig> queryScoreConfigInfo(ScoreConfig scoreConfig){
		CommonResultEntity<ScoreConfig> cre = new CommonResultEntity<ScoreConfig>();
		cre.setBusinessObj(scoreConfigBiz.queryScoreConfigInfo(scoreConfig));
		return cre;
	}
	/**
	 * 
	 * @Description: 更新ScoreConfig
     * @author: fengxin
     * @date: 2015年3月25日 上午11:38:02
     * @param scoreConfig
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> updateScoreConfig(ScoreConfig scoreConfig){
		CommonResultEntity<String> src = new CommonResultEntity<String>();
		ValidateService.valid(scoreConfig);
		scoreConfigBiz.updateScoreConfig(scoreConfig);
		return src;
	}
	/**
	 * 
	 * @Description: 增加积分配置信息
     * @author: fengxin
     * @date: 2015年3月25日 上午11:55:10
     * @param scoreConfig
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> addScoreConfig(ScoreConfig scoreConfig){
		CommonResultEntity<String> src = new CommonResultEntity<String>();
		ValidateService.valid(scoreConfig);
		scoreConfigBiz.addScoreConfig(scoreConfig);
		return src;
	}
	/**
	 * 
	 * @Description: 定时任务 积分清零
     * @author: fengxin
     * @date: 2015年4月2日 下午1:55:09
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateResetScore(){
		CommonResultEntity<String> src = new CommonResultEntity<String>();
		scoreConfigBiz.updateResetScore();
		return src;
	}
	
}
