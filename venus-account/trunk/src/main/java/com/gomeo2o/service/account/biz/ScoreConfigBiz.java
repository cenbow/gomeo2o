package com.gomeo2o.service.account.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreConfig;
import com.gomeo2o.service.account.dao.ScoreConfigDao;
import com.gomeo2o.service.account.dao.ScoreInfoDao;
/**
 * 
 * @Description: 积分配置Biz
 * @author: fengxin
 * @date: 2015年3月20日 下午4:51:38
 */
@Service("scoreConfigBiz")
public class ScoreConfigBiz {
	
	@Autowired
	private ScoreConfigDao scoreConfigDao;
	
	@Autowired
	private ScoreInfoDao scoreInfoDao;
	
	/**
	 * 
	 * @Description: 查询积分配置列表list
     * @author: fengxin
     * @date: 2015年3月25日 上午11:14:58
     * @param pageParam
     * @return PageBean    
	 */
	public PageBean queryScoreConfigList(PageParam pageParam){
		return scoreConfigDao.listPage(pageParam, null);
	}
	/**
	 * 
	 * @Description: 根据id查询ScoreConfig
     * @author: fengxin
     * @date: 2015年3月25日 上午11:19:47
     * @param scoreConfig
     * @return ScoreConfig    
	 */
	public ScoreConfig queryScoreConfigInfo(ScoreConfig scoreConfig){
		return scoreConfigDao.getById(scoreConfig.getId());
	}
	/**
	 * 
	 * @Description: 更新ScoreConfig
     * @author: fengxin
     * @date: 2015年3月25日 上午11:38:02
     * @param scoreConfig
     * @return void    
	 */
	@Transactional
	public void updateScoreConfig(ScoreConfig scoreConfig){
		scoreConfigDao.update(scoreConfig);
	}
	/**
	 * 
	 * @Description: 增加积分配置信息
     * @author: fengxin
     * @date: 2015年3月25日 上午11:55:10
     * @param scoreConfig
     * @return void    
	 */
	public void addScoreConfig(ScoreConfig scoreConfig){
		scoreConfigDao.insert(scoreConfig);
	}
	/**
	 * 
	 * @Description: 定时任务 积分清零
     * @author: fengxin
     * @date: 2015年4月2日 下午1:55:09
     * @return void    
	 */
	@Transactional
	public void updateResetScore(){
		//查询条件
		ScoreConfig scoreConfig = new ScoreConfig();
		//查询未执行的积分配置
		scoreConfig.setState(0);
		//查询已经启用的积分配置
		scoreConfig.setIsEnable(1);
		scoreConfig.setResetTime(new Date());
		//获得满足条件的积分配置
		List<ScoreConfig> list_scoreConfig = this.scoreConfigDao.queryScoreConfigByParameter(scoreConfig);
		if(list_scoreConfig.size()>0){
			for (int i = 0; i < list_scoreConfig.size(); i++) {
				scoreConfig = list_scoreConfig.get(i);
				scoreInfoDao.updateResetScoreInfo(scoreConfig);
				scoreConfig.setState(1);
				this.scoreConfigDao.update(scoreConfig);
			}
			
		}
	}
	
	

}
