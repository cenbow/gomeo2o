package com.gomeo2o.facade.account.service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreConfig;

/**
 * 
 * @Description: 积分配置Facade
 * @author: fengxin
 * @date: 2015年3月20日 下午4:05:17
 */
public interface ScoreConfigFacade {
	
	/**
	 * 
	 * @Description: 查询积分配置列表list
     * @author: fengxin
     * @date: 2015年3月25日 上午11:14:58
     * @param pageParam
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryScoreConfigList(PageParam pageParam);
	
	/**
	 * 
	 * @Description: 根据id查询ScoreConfig
     * @author: fengxin
     * @date: 2015年3月25日 上午11:19:47
     * @param scoreConfig
     * @return CommonResultEntity<ScoreConfig>    
	 */
	public CommonResultEntity<ScoreConfig> queryScoreConfigInfo(ScoreConfig scoreConfig);
	/**
	 * 
	 * @Description: 更新ScoreConfig
     * @author: fengxin
     * @date: 2015年3月25日 上午11:38:02
     * @param scoreConfig
     * @return CommonResultEntity<String>  
     * @throws Exception
	 */
	public CommonResultEntity<String> updateScoreConfig(ScoreConfig scoreConfig);
	/**
	 * 
	 * @Description: 增加积分配置信息
     * @author: fengxin
     * @date: 2015年3月25日 上午11:55:10
     * @param scoreConfig
     * @return CommonResultEntity<String>  
     * @throws Exception  
	 */
	public CommonResultEntity<String> addScoreConfig(ScoreConfig scoreConfig);
	
	/**
	 * 
	 * @Description: 定时任务 积分清零
     * @author: fengxin
     * @date: 2015年4月2日 下午1:55:09
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateResetScore();
}
