package com.gomeo2o.service.account.biz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.facade.account.entity.AccountInfo;
import com.gomeo2o.facade.account.entity.ScoreDetail;
import com.gomeo2o.facade.account.entity.ScoreInfo;
import com.gomeo2o.facade.account.entity.ScoreReDay;
import com.gomeo2o.facade.account.entity.ScoreReSingle;
import com.gomeo2o.facade.account.entity.ScoreReTotal;
import com.gomeo2o.facade.account.entity.ScoreRule;
import com.gomeo2o.service.account.dao.AccountInfoDao;
import com.gomeo2o.service.account.dao.ScoreDetailDao;
import com.gomeo2o.service.account.dao.ScoreInfoDao;
import com.gomeo2o.service.account.dao.ScoreReDayDao;
import com.gomeo2o.service.account.dao.ScoreReSingleDao;
import com.gomeo2o.service.account.dao.ScoreReTotalDao;
import com.gomeo2o.service.account.dao.ScoreRuleDao;
/**
 * 
 * @Description: 积分信息Biz
 * @author: fengxin
 * @date: 2015年3月20日 下午4:51:38
 */
@Service("scoreInfoBiz")
public class ScoreInfoBiz {
	
	@Autowired
	private ScoreInfoDao scoreInfoDao;
	/**
	 * 积分明细DAO
	 */
	@Autowired
	private ScoreDetailDao scoreDetailDao;
	/**
	 * 总积分上限剩余Dao
	 */
	@Autowired
	private ScoreReTotalDao scoreReTotalDao;
	/**
	 * 日积分上限剩余DAO
	 */
	@Autowired
	private ScoreReDayDao scoreReDayDao;
	/**
	 * 人/日积分上限Dao
	 */
	@Autowired
	private ScoreReSingleDao scoreReSingleDao;
	/**
	 * 积分规则Dao
	 */
	@Autowired
	private ScoreRuleDao scoreRuleDao;
	/**
	 * 账户
	 */
	@Autowired
	private AccountInfoDao accountInfoDao;
	
	/**
	 * 
	 * @Description: 积分数据汇总信息查询
     * @author: fengxin
     * @date: 2015年3月25日 下午4:11:15
     * @param scoreInfo
     * @return Map<String,Integer>    
	 */
	public Map<String,Integer> queryScoreInfoTotal(ScoreInfo scoreInfo){
		return scoreInfoDao.queryScoreInfoTotal(scoreInfo);
	}
	/**
	 * 
	 * @Description: 根据积分明细(分批次查询数据) 修改积分信息
     * @author: fengxin
     * @date: 2015年3月26日 上午11:57:14
     * @return void    
	 */
	@Transactional
	public void updateRecordScoreInfo(){
		//得到需要修改的的积分明细总条数
		long list_sd_count = scoreDetailDao.queryUpdateScoreDetailCount();
		Map<String,Object> map = new HashMap<String,Object>();
		if(list_sd_count>0){
			//分批次查询数据
			//页数
			int pageSum=0;
			//每次条数
			int pageCount =1000;
			if(list_sd_count%pageCount==0){
				pageSum = (int) (list_sd_count/pageCount);
			}else{
				pageSum = (int) (list_sd_count/pageCount+1);
			}
			for (int i = 0; i < pageSum; i++) {
				map.put("pageSize", pageCount);
				map.put("pageFirst", pageCount*i);
				//查询符合入账信息的积分明细
				List<ScoreDetail> list_sd = scoreDetailDao.queryUpdateScoreDetail(map);
				if(list_sd.size()>0){
					for (int j = 0; j < list_sd.size(); j++) {
						ScoreDetail sd = list_sd.get(j);
						//积分明细对应的用户信息对象
						Map<String,Object> paramMap = new HashMap<String,Object>();
						paramMap.put("userId", sd.getUserId());
						AccountInfo accountInfo = accountInfoDao.getBy(paramMap);
						if(null != accountInfo){
							Map<String,Object> acc_map = new HashMap<String,Object>();
							acc_map.put("accountType", 2);
							acc_map.put("userId", sd.getUserId());
								//校验增加积分是否超过了限制值
								if(this.checkScoreLimit(sd, sd.getUserId())){
									acc_map.put("recordValue", sd.getRecordValue());
									accountInfoDao.updateAccountInfo(acc_map);
									//设置当前明细为已经入账状态
									sd.setState(1);
								}else{
									//设置为超过限制状态
									sd.setState(2);
								}
						}
						//修改积分明细
						scoreDetailDao.update(sd);
					}
				}
			}
			
		}
		
	}
	/**
	 * 
	 * @Description: 检查当前入账积分是否超过了积分规则限时
     * @author: fengxin
     * @date: 2015年3月31日 上午11:43:46
     * @return
     * @return boolean    
     * @throws
	 */
	public boolean checkScoreLimit(ScoreDetail scoreDetail, Long userId){
		//昨天日期 yyyy-MM-dd
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE,   -1);
	    //查询参数对象
		Map<String,Object> map = new HashMap<String,Object>();
		//积分格则对象
		ScoreRule sr = this.scoreRuleDao.getById(scoreDetail.getRuleId());
		//检查总积分上限
		map.put("ruleId", scoreDetail.getRuleId());
		//总积分上限对象
		ScoreReTotal srt = scoreReTotalDao.getBy(map);
		//如果不存在总积分上限余额对象 则创建
		if(srt==null){
			srt= new ScoreReTotal();
			srt.setRuleId(scoreDetail.getRuleId());
			srt.setTotalTop(sr.getTotalTop());
			this.scoreReTotalDao.insert(srt);
		}
		//判断当前所增加积分是否超过了总积分上限余额   没有
		if(srt.getTotalTop()-scoreDetail.getRecordValue()>=0){
			srt.setTotalTop(srt.getTotalTop()-scoreDetail.getRecordValue());
		//已经超过上限余额  代码终止  return
		}else{
			return false;
		}
		//检查日积分上限
		map.put("recordDate",new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime()));
		//日积分上限余额对象
		ScoreReDay srd = this.scoreReDayDao.getBy(map);
		//如果不存在日积分上限余额对象 则创建
		if(srd==null){
			srd = new ScoreReDay();
			srd.setRuleId(scoreDetail.getRuleId());
			srd.setRecordDate(new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime()));
			srd.setDayTop(sr.getDayTop());
			this.scoreReDayDao.insert(srd);
		}
		//判断是否超过了日积分上限余额   如果没有
		if(srd.getDayTop()-scoreDetail.getRecordValue()>=0){
			srd.setDayTop(srd.getDayTop()-scoreDetail.getRecordValue());
		//已经超过  代码终止  return false
		}else{
			return false;
		}
		//检查人/日积分上限
		map.put("userId", userId);
		//查询人/日积分上限余额  
		ScoreReSingle srs = this.scoreReSingleDao.getBy(map);
		//如果不存在则创建
		if(srs==null){
			srs = new ScoreReSingle();
			srs.setRecordDate(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
			srs.setUserId(userId);
			srs.setSingleTop(sr.getSingleTop());
			srs.setRuleId(scoreDetail.getRuleId());
			this.scoreReSingleDao.insert(srs);
		}
		//判断是否超过了日/人积分上限
		if(srs.getSingleTop()-scoreDetail.getRecordValue()>=0){
			srs.setSingleTop(srs.getSingleTop()-scoreDetail.getRecordValue());
		}else{
			return false;
		}
		this.scoreReDayDao.update(srd);
		this.scoreReSingleDao.update(srs);
		this.scoreReTotalDao.update(srt);
		return true;
	}

}
