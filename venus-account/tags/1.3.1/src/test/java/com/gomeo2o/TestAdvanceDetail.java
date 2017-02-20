package com.gomeo2o;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AdvanceDetail;
import com.gomeo2o.facade.account.service.AccountInfoFacade;
import com.gomeo2o.facade.account.service.AdvanceDetailFacade;

/**
 * 
 * @Description: 提现流水测试类
 * @author: fengxin
 * @date: 2015年5月4日 下午2:01:07
 */
public class TestAdvanceDetail extends BaseTest {
	
	public static AdvanceDetailFacade advanceDetailFacade = null;
	public static AccountInfoFacade accountInfoFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		advanceDetailFacade = (AdvanceDetailFacade) context
				.getBean("advanceDetailFacade");
		accountInfoFacade = (AccountInfoFacade) context
				.getBean("accountInfoFacade");
	}
	/**
	 * 
	 * @Description: 测试增加提现流水
     * @author: fengxin
     * @date: 2015年5月4日 下午2:03:18
     * @return void    
	 */
	public void utestAddAdvanceDetail(){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", 7);
			map.put("applyTime", new Date());//提现申请时间
			map.put("auditTime", new Date());//审核通过时间
			map.put("acceptTime", new Date());//提现受理时间
			map.put("successTime", new Date());//提现成功时间
			map.put("cashCardnumber", "62146800003041942");
			map.put("bankName", "中国银行");
			map.put("advanceName", "冯鑫12");
			map.put("identityNum", "620523199008240016");
			map.put("advanceValue", 1000);
			map.put("recordValue", 500);
			map.put("cashFee", 12);
			map.put("advanceRemark", "我是申请提现的 ，不要少钱");
			map.put("verifyType", 2);
			map.put("state", 1);
			map.put("creator", "冯鑫");
			map.put("bankCode", "301");
			//CommonResultEntity<String> crs_id = accountInfoFacade.createUserOperateNO(map);
			//map.put("userOpNo", crs_id.getBusinessObj());
			CommonResultEntity<String> crs = advanceDetailFacade.addAdvanceDetail(map);
			assertTrue(crs.getCode()==0);
	}
	/**
	 * 
	 * @Description: 修改提现流水状态
     * @author: fengxin
     * @date: 2015年5月4日 下午2:20:47
     * @return void    
	 */
	public void utestUpdateAdvanceDetail(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", 4);
		map.put("userId", 7);
		map.put("detailNo", "4201508130000319");
		map.put("successTime","Fri Jun 19 11:37:36 CST 2015");
		CommonResultEntity<String> crs = advanceDetailFacade.updateAdvanceDetail(map);
		assertTrue(crs.getCode()==0);
	}
	/**
	 * 
	 * @Description: 分页查询提现柳树i
     * @author: fengxin
     * @date: 2015年5月4日 下午2:25:29
     * @return void    
     * @throws
	 */
	public void utestQueryAdvanceDetailByParamer(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", 12345678);
		CommonResultEntity<PageBean> crs  = advanceDetailFacade.queryAdvanceDetailByParamer(map, new PageParam(1,10));
		assertNotNull("查询结果为空", crs.getBusinessObj());
	}
	/**
	 * 
	 * @Description: 根据ID查询余额提现流水
     * @author: fengxin
     * @date: 2015年5月9日 下午3:55:28
     * @return void    
	 */
	public void utestQueryAdvanceDetailById(){
		CommonResultEntity<AdvanceDetail> crs  = advanceDetailFacade.queryAdvanceDetailById(1);
		assertNotNull("查询结果为空", crs.getBusinessObj());
	}
	/**
	 * 
	 * @Description: 发送数据到SAP
     * @author: fengxin
     * @date: 2015年6月3日 下午7:34:07
     * @return void    
	 */
	public void testSendSOAPWithAdvanceDetail(){
		CommonResultEntity<String> crs  = advanceDetailFacade.sendSOAPWithAdvanceDetail();
		assertNotNull("查询结果为空", crs.getBusinessObj());
	}
	/**
	 * 
	 * @Description: 测试修改凭证号
     * @author: fengxin
     * @date: 2015年6月3日 下午7:34:55
     * @return void    
	 */
	public void utestUpdateAdvanceDetailVoucher(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("payoffNo", "620523199008240016");
		map.put("payoffTime", new Date());
		map.put("detailNo", "4201506080000219");
		advanceDetailFacade.updateAdvanceDetailVoucher(map);
	}
}
