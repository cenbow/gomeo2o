package cn.com.gome.trade.service;


public interface GomeTradeOrderStatusService {

	/**
	 * @Description: 正向处理订单履历调度
	 * @author: libin-ds9
	 * @date: 2015年5月22日 下午3:33:35
	 */
	public void doOrder();

	/**
	 * @Description: 逆向订单换货处理
	 * @author: libin-ds9
	 * @date: 2015年5月29日 下午2:33:43
	 */
	public void doReverseOrderByExchange();


	public void doReverseOrderByReturn() ;
}
