package cn.com.gome.trade.service;

/**
 * @Description: 订单状态推信息到返利 
 * @author: liutaiming
 * @date: 2015年5月19日 下午3:48:48
 */
public interface GomeOrderToRebateService {
	
	/**
	 * @Description: 推返利 
	 * @author: liutaiming
	 * @date: 2015年5月19日 下午3:56:28
	 * @param json
	 */
	public void orderToRebate(String json);
	
	/**
	 * @Description: 获取推订单json 
	 * @author: liutaiming
	 * @date: 2015年5月26日 上午10:44:43
	 * @param orderIdOrRefundId
	 * @param status
	 * @return
	 */
	public String getRebateJson(long orderIdOrRefundId,int status);
	
	/**
	 * @Description: 推返利json数据  
	 * @author: liutaiming
	 * @date: 2015年5月29日 下午12:00:14
	 * @param orderIdOrRefundId
	 * @param status
	 */
	public void orderToRebateJson(long orderIdOrRefundId,int status);

	
	/**
	 * @Description: 订单推积分 
	 * @author: liutaiming
	 * @date: 2015年7月2日 下午9:12:56
	 * @param orderId
	 */
	public void orderToScore(long orderId);
}
