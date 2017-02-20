package com.gomeo2o.facade.account.service.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.ScoreInfo;
import com.gomeo2o.facade.account.service.ScoreInfoFacade;
import com.gomeo2o.service.account.biz.ScoreInfoBiz;
/**
 * 
 * @Description: 积分信息Service实现
 * @author: fengxin
 * @date: 2015年3月20日 下午4:43:14
 */
@Service("scoreInfoFacade")
public class ScoreInfoFacadeImpl implements ScoreInfoFacade{
	
	@Autowired
	private ScoreInfoBiz scoreInfoBiz;
	
	/**
	 * 
	 * @Description: 积分数据汇总信息查询
     * @author: fengxin
     * @date: 2015年3月25日 下午4:11:15
     * @param scoreInfo
     * @return CommonResultEntity<Map<String,Integer>>
	 */
	public CommonResultEntity<Map<String,Integer>> queryScoreInfoTotal(ScoreInfo scoreInfo){
		CommonResultEntity<Map<String,Integer>> crs = new CommonResultEntity<Map<String,Integer>>();
		crs.setBusinessObj(scoreInfoBiz.queryScoreInfoTotal(scoreInfo));
		return crs;
	}
	/**
	 * 
	 * @Description: 根据积分明细 修改积分信息
     * @author: fengxin
     * @date: 2015年3月26日 上午11:57:14
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> updateRecordScoreInfo(){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		scoreInfoBiz.updateRecordScoreInfo();
		return crs;
	}
}
