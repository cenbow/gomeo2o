/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午2:26:42
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreDetail;
import com.gomeo2o.facade.account.service.ScoreDetailFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.facade.account.utils.ValidateService;
import com.gomeo2o.service.account.biz.ScoreDetailBiz;
import com.gomeo2o.utils.Constants;

/**
 * @Description: 积分明细
 * @author: fengxin
 * @date: 2015年4月30日 下午2:26:42
 */
@Service("scoreDetailFacade")
public class ScoreDetailServiceImpl implements ScoreDetailFacade {
	
	
	@Autowired
	private ScoreDetailBiz scoreDetailBiz;
	
	/**
	 * 
	 * @Description: 修改积分明细状态
     * @author: fengxin
     * @date: 2015年4月30日 下午2:31:18
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateScoreDetail(Map<String,Object> reqParam){
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ScoreDetail scoreDetail = new ScoreDetail();
		scoreDetail.setDetailNo((String)reqParam.get("detailNo"));
		scoreDetail.setUserId((Long)reqParam.get("userId"));
		scoreDetail.setState((Integer)reqParam.get("state"));
		this.scoreDetailBiz.updateScoreDetailState(scoreDetail);
		return rcs;
	}
	
	/**
	 * 
	 * @Description: 增加积分明细流水
     * @author: fengxin
     * @date: 2015年4月30日 下午2:40:22
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addScoreDetail(Map<String,Object> reqParam){
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ScoreDetail scoreDetail = new ScoreDetail();
		//积分流水号
		scoreDetail.setDetailNo(Constants.getScoreDetailNo());
		scoreDetail.setUserId((Long)reqParam.get("userId"));
		scoreDetail.setState((Integer)reqParam.get("state"));
		scoreDetail.setOrderNo((String)reqParam.get("orderNo"));
		scoreDetail.setCreator((String)reqParam.get("creator"));
		scoreDetail.setDealRemark((String)reqParam.get("dealRemark"));
		scoreDetail.setDealTime((Date)reqParam.get("dealTime"));
		scoreDetail.setDealType((Integer)reqParam.get("dealType"));
		scoreDetail.setProductId((Long)reqParam.get("productId"));
		scoreDetail.setDealTime((Date)reqParam.get("dealTime"));
		scoreDetail.setRecordValue((Integer)reqParam.get("recordValue"));
		scoreDetail.setPointId((Long)reqParam.get("pointId"));
		ValidateService.valid(scoreDetail);
		this.scoreDetailBiz.addScoreDetail(scoreDetail);
		return rcs;
	}
	/**
	 * 
	 * @Description: 积分明细查询带分页 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:36:19
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<List<ScoreDetail>>    
	 */
	public CommonResultEntity<List<ScoreDetail>> queryScoreDetailByParamer(Map<String,Object> reqParam,PageParam pageParam){
		CommonResultEntity<List<ScoreDetail>>  crs = new CommonResultEntity<List<ScoreDetail>> ();
		crs.setBusinessObj(scoreDetailBiz.queryScoreDetailByParamer(reqParam, pageParam));
		return crs;
	}
	/**
	 * 
	 * @Description: 积分获取明细列表
     * @author: fengxin
     * @date: 2015年3月25日 下午6:11:46
     * @param pageParam
     * @param scoreDetail
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryScoreDetalList(PageParam pageParam,ScoreDetail scoreDetail){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(scoreDetailBiz.queryScoreDetalList(pageParam,scoreDetail));
		return crs;
	}
	/**
	 * 
	 * @Description: 根据积分埋点创建积分流水
     * @author: fengxin
     * @date: 2015年5月29日 下午2:18:39
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createScoreDetailByPoint(Map<String,Object> reqParam){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		List<String> mustList =  new ArrayList<String>();
		//积分埋点编号
		mustList.add("code");
		//用户id
		mustList.add("userId");
		ValidateMapService.validate(reqParam,mustList);
		scoreDetailBiz.createScoreDetailByPoint(reqParam);
		return crs;
	}
	/**
	 * @Description 获取不同状态积分总值
	 * @author fengxin
	 * @date 2015年12月1日 下午6:37:38
	 * @param map
	 * @return CommonResultEntity<Long>
	 */
	public CommonResultEntity<Long> queryScoreTotal(Map<String,Object> map){
		CommonResultEntity<Long> crs  = new CommonResultEntity<Long>();
		crs.setBusinessObj(scoreDetailBiz.queryScoreTotal(map));
		return crs;
	}
	
}
