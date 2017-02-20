/**
 * gomeo2o.com 
 * Copyright (c) 2010-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2010年4月17日 下午2:31:24
 */
package com.gomeo2o;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AccountInfo;
import com.gomeo2o.facade.account.service.AccountInfoFacade;

/**
 * @Description: 测试账户信息
 * @author: fengxin
 * @date: 2010年4月17日 下午2:31:24
 */
public class TestAccountInfo extends BaseTest {
	public static AccountInfoFacade accountInfoFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		accountInfoFacade = (AccountInfoFacade) context
				.getBean("accountInfoFacade");
	}

	/**	
	 * @Description:增加、减少、冻结跑批
	 * @author: gongjiaming
	 * @date: 2015年4月22日
	 * @throws IOException
	 */
	public void utestAccountInfo() throws IOException {
		int count = 10;
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < count; i++) {
			//service.execute(new Thread(new TestAccountInfo().new AddTask()));
			service.execute(new Thread(new TestAccountInfo().new EditTask()));
      		//service.execute(new Thread(new TestAccountInfo().new FroozeTask()));
		}
		service.shutdown();
		while (!service.isTerminated()) {  
             try {  
                  Thread.sleep((long)(Math.random()*100));  
             } catch (Exception e) {  
                  e.printStackTrace();  
             }  
        }
//		System.in.read();
	}
	/**
	 * 
	 * @Description: 测试查询账户汇总列表
     * @author: fengxin
     * @date: 2015年5月6日 下午5:19:22
     * @return void    
	 */
	public void utestqueryVirAssetsListByParamer(){
		Map<String,Object> map = new HashMap<String,Object>();
		PageParam p = new PageParam(1, 10);
		map.put("pageParam", p);
		CommonResultEntity<PageBean> crs = accountInfoFacade.queryVirAssetsListByParamer(map);
		System.out.println(crs.getBusinessObj().getRecordList());
	}
	/**
	 * 
	 * @Description: 测试增加账户积分，现金余额，返利信息
	 * @author: fengxin
	 * @date: 2010年4月17日 下午2:47:59
	 * @return void
	 * @throws IOException
	 */
	public void utestAddAccountInfo() throws IOException {
		ExecutorService service = Executors.newFixedThreadPool(60);
		for (int i = 0; i < 1; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					long start = System.currentTimeMillis();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("accountType", "3");
					map.put("userId", "12345678");
					map.put("dealTime", "2010-10-10");
					map.put("recordTime", "2010-10-10");
					map.put("recordValue", 12);
					map.put("dealRemark", "这是一个测试");
					map.put("dealType", "1");
					map.put("detailRemark", "这还是一个测试");
					map.put("creator", "冯鑫");
					map.put("rebateState", "1");
					map.put("state", "0");
					map.put("productId", 12345678);
					map.put("shopId", 12345678);
					map.put("orderNo", "12345678");
					CommonResultEntity<String> cre = accountInfoFacade
							.addAccountInfo(map);
					start = System.currentTimeMillis() - start;
					System.out.println(cre.getBusinessObj() + "----" + cre.getMessage() + "----耗时：" +start);
					try {
//						 Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		service.shutdown();
		System.in.read();
	}

	/**
	 * 
	 * @Description: 测试减少积分，现金余额，返利信息
	 * @author: fengxin
	 * @date: 2010年4月17日 下午2:50:29
	 * @return void
	 * @throws IOException
	 */
	public void utestEditAccountInfo() throws IOException {
		ExecutorService service = Executors.newFixedThreadPool(60);
		for (int i = 0; i < 1; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					try {
						long start = System.currentTimeMillis();
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("accountType", "1");
						map.put("userId", "1");
						map.put("dealTime", "2010-10-10");
						map.put("recordTime", "2010-10-10");
						map.put("recordValue", 1);
						map.put("dealRemark", "test_edit");
						map.put("dealType", 3);
						map.put("detailRemark", "test_edit");
						map.put("creator", "test");
						CommonResultEntity<String> cre = accountInfoFacade
								.editAccountInfo(map);
						start = System.currentTimeMillis() - start;
						System.out.println("线程" + Thread.currentThread().getName()+"---"+cre.getBusinessObj() + "----" + cre.getMessage() + "----耗时：" +start);
						// Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		service.shutdown();
		System.in.read();
	}

	/**
	 * @throws IOException
	 * 
	 * @Description: 测试冻结 积分，现金余额，返利信息
	 * @author: fengxin
	 * @date: 2010年4月17日 下午2:50:40
	 * @return void
	 * @throws
	 */
	public void utestUpdateAccountInfoState() throws IOException {
		ExecutorService service = Executors.newFixedThreadPool(60);
		for (int i = 0; i < 1; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					try {
						long start = System.currentTimeMillis();
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("userId", "1");
						map.put("productId", 1);
						map.put("shopId", 1);
						map.put("orderNo", 1);
						map.put("dealTime", "2010-10-10");
						map.put("expectTime", "2010-10-10");
						map.put("recordTime", "2010-10-10");
						map.put("merchantRebate", 1);
						map.put("platformRebate", 1);
						map.put("rebateState", 1);
						map.put("recordValue", 1);
						map.put("recordRule", 3);
						map.put("dealRemark", "test_dj");
						map.put("detailRemark", "test");
						map.put("dealType", 3);
						map.put("accountType", "3");
						map.put("creator", "test");
						map.put("state", 1);
						CommonResultEntity<String> cre = accountInfoFacade
								.froozeAccountInfo(map);
						start = System.currentTimeMillis() - start;
						System.out.println(cre.getBusinessObj() + "----" + cre.getMessage() + "----耗时：" +start);
						// Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		service.shutdown();
		System.in.read();
	}
	public void utestReSetfroozeAccountInfo(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accountType", "3");
		map.put("userId", 12346494);
		map.put("dealTime", "2010-10-10");
		map.put("recordTime", "2010-10-10");
		map.put("recordValue", 11);
		map.put("dealRemark", "这是一个测试");
		map.put("dealType", "1");
		map.put("detailRemark", "这还是一个测试");
		map.put("creator", "冯鑫");
		map.put("rebateState", "1");
		map.put("state", "0");
		map.put("productId", 12345678);
		map.put("shopId", 12345678);
		map.put("orderNo", "12345678");
		accountInfoFacade.reSetfroozeAccountInfo(map);
	}
	/**
	 * @Description:单个线程测试增加
	 * @author:gongjiaming
	 * @date: 2015年4月22日
	 */
	public class AddTask implements Runnable {
		@Override
		public void run() {
			try {
					long start = System.currentTimeMillis();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("accountType", "1");
					map.put("userId", "1");
					map.put("dealTime", "2010-10-10");
					map.put("recordTime", "2010-10-10");
					map.put("recordValue", 20);
					map.put("dealRemark", "test_add");
					map.put("dealType", 1);
					map.put("detailRemark", "test_add");
					map.put("creator", "test");
					CommonResultEntity<String> cre = accountInfoFacade
							.addAccountInfo(map);
					start = System.currentTimeMillis() - start;
					System.out.println(cre.getBusinessObj() + "----" + cre.getMessage() + "----耗时：" +start);
//				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @Description:单个线程测试减少
	 * @author:gongjiaming
	 * @date: 2015年4月22日
	 */
	public class EditTask implements Runnable {
		@Override
		public void run() {
			try {
				long start = System.currentTimeMillis();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("accountType", "1");
				map.put("userId", "1");
				map.put("dealTime", "2010-10-10");
				map.put("recordTime", "2010-10-10");
				map.put("recordValue", 5);
				map.put("dealRemark", "test_edit");
				map.put("dealType", 2);
				map.put("detailRemark", "test_edit");
				map.put("creator", "test");
				CommonResultEntity<String> cre = accountInfoFacade
						.editAccountInfo(map);
				start = System.currentTimeMillis() - start;
				System.out.println(cre.getBusinessObj() + "----" + cre.getMessage() + "----耗时：" +start);
//				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @Description:单个线程测试冻结
	 * @author:gongjiaming
	 * @date: 2015年4月22日
	 */
	public class FroozeTask implements Runnable {
		@Override
		public void run() {
			try {
				long start = System.currentTimeMillis();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("accountType", "3");
				map.put("userId", "1");
				map.put("dealTime", "2010-10-10");
				map.put("recordTime", "2010-10-10");
				map.put("recordValue", 1);
				map.put("dealRemark", "test_dj");
				map.put("dealType", 3);
				map.put("detailRemark", "test_dj");
				map.put("creator", "test");
				CommonResultEntity<String> cre = accountInfoFacade.froozeAccountInfo(map);
				start = System.currentTimeMillis() - start;
				System.out.println(cre.getBusinessObj() + "----" + cre.getMessage() + "----耗时：" +start);
//				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @Description: 根据条件查询账户信息
     * @author: fengxin
     * @date: 2015年5月8日 下午2:15:23
     * @return void    
	 */
	public void utestQueryAccountInfoByParamer(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 0);
		CommonResultEntity<AccountInfo> crs= accountInfoFacade.queryAccountInfoByParamer(map);
		assertNotNull("是空的", crs.getBusinessObj());
	}
	/**
	 * 
	 * @Description: 查询账户的收支明细
     * @author: fengxin
     * @date: 2015年5月9日 下午2:14:23
     * @return void
	 */
	public void utestQueryBalancePayMentsVoByParamer(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 0);
		CommonResultEntity<PageBean> rsc = accountInfoFacade.queryBalancePayMentsVoByParamer(new PageParam(1,10), map);
		System.out.println(rsc.getBusinessObj().getRecordList().size());
	}
	/**
	 * 
	 * @Description: 支付密码
     * @author: fengxin
     * @date: 2015年5月27日 下午6:19:34
     * @return void    
	 */
	public void testUpdateUserPassWord(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 7);
		map.put("payPassword", "1");
		CommonResultEntity<String> rsc = accountInfoFacade.updateUserPayPassWord(map);
		assertEquals(rsc.getCode(), 0);
	}
	/**
	 * 
	 * @Description: 创建用户
     * @author: fengxin
     * @date: 2015年5月27日 下午6:28:02
     * @return void    
	 */
	public void utestCreateAccountInfo(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 12345678);
		map.put("userName", "冯鑫");
		map.put("userPhone", "15011225919");
		CommonResultEntity<String> rsc = accountInfoFacade.createAccountInfo(map);
		assertNotNull("是空的", rsc.getBusinessObj());
	}
	/**
	 * 
	 * @Description: 创建用户操作序列号
     * @author: fengxin
     * @date: 2015年5月27日 下午6:20:04
     * @return void    
	 */
	public void utestcreateUserOperateNO(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", "fengxingdiagsa");
		CommonResultEntity<String> rsc = accountInfoFacade.createUserOperateNO(map);
		assertNotNull("是空的", rsc.getBusinessObj());
	}
	
	public void utestCheckPayPassword(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", "12345678");
		map.put("payPassword", "1");
		CommonResultEntity<String> rsc = accountInfoFacade.checkUserPayPassword(map);
		assertEquals(rsc.getBusinessObj(),"true");
	}
	
	public void utestQueryVirAssetsSumByParamer(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", "12345678");
		CommonResultEntity<Map<String,Object>> resmap = accountInfoFacade.queryVirAssetsSumByParamer(map);
		System.out.println(resmap);
	}
}
