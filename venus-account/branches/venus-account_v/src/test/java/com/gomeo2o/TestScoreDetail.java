package com.gomeo2o;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreDetail;
import com.gomeo2o.facade.account.service.ScoreDetailFacade;
/**
 * 
 * @Description: 积分流水测试用例
 * @author: fengxin
 * @date: 2015年4月14日 上午9:56:04
 */
public class TestScoreDetail extends BaseTest {
	ScoreDetailFacade scoreDetailFacade = null;
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scoreDetailFacade = (ScoreDetailFacade) context.getBean("scoreDetailFacade");
	}
	
	public void utestQueryScoreDetalList() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dstr="2015-2-1"; 
		ScoreDetail s = new ScoreDetail();
		s.setSiStartDealTime(sdf.parse(dstr));
		s.setSiEndDealTime(new Date());
		CommonResultEntity<PageBean> crs  = scoreDetailFacade.queryScoreDetalList(new PageParam(1, 10),s);
		assertTrue("未查询到数据",crs.getBusinessObj().getTotalCount()>0);
	}
	
	public void utestAddScoreDetail() throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> map = null;
		String dstr="2015-7-9";
		for (int i = 0; i < 1; i++) {
			map = new HashMap<String,Object>();
			map.put("dealRemark", "冯鑫测试");
			map.put("dealTime", sdf.parse(dstr));
			map.put("dealType",  1);
			map.put("recordTime", new Date());
			map.put("recordValue", 30);
			map.put("pointId", (long)1);
			map.put("state", 1);
			map.put("userId", (long)12345678);
			map.put("ruleId", (long)1);
			map.put("orderNo", "orderNoorderNo");
			map.put("creator", "冯鑫");
			scoreDetailFacade.addScoreDetail(map);
		}
	}
	/**
	 * 
	 * @Description:测试根据积分埋点获取积分数值
     * @author: fengxin
     * @date: 2015年6月1日 下午6:03:28
     * @return void    
	 */
	public void testCreateScoreDetailByPoint(){
		/*for (int i = 0; i < 100; i++) {
			Map<String,Object> map =  new HashMap<String, Object>();
			map.put("code", 8981);
			map.put("userId", 12345678);
			map.put("dealRemark", "分享返积分");
			map.put("dealType", 90);
			CommonResultEntity<String> crs = scoreDetailFacade.createScoreDetailByPoint(map);
			System.out.println(crs);
		}*/
		
		/*map.put("code", 8982);
		map.put("userId", 620);
		map.put("dealRemark", "邀请注册返积分");
		map.put("dealType", 2);*/
		Map<String,Object> map =  new HashMap<String, Object>();
		/*map.put("code", 8983);
		map.put("userId", 620);
		map.put("orderNo", "订单成功返积分");
		map.put("orderMoney", 100002);
		map.put("dealRemark", "订单成功返积分");
		map.put("dealType", 3);*/
		
		map.put("code", 8984);
		map.put("userId", 11111);
		map.put("productId", 6);
		map.put("orderMoney", 44000);
		map.put("dealRemark", "评价/晒单返积分");
		map.put("dealType", 2);
		CommonResultEntity<String> crs = scoreDetailFacade.createScoreDetailByPoint(map);
		System.out.println("fengixn");
		
		/*map.put("code", 8985);
		map.put("userId", 620);
		map.put("dealRemark", "意见反馈发积分");
		map.put("dealType", 5);*/
	}
}
