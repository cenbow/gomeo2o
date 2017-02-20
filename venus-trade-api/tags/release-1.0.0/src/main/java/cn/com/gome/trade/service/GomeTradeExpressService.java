package cn.com.gome.trade.service;

/**
 * @author:zhangyihang
 * @Description:快递服务
 * @Date:2015年6月4日 11:51:56
 */
public interface GomeTradeExpressService {
	/**
	 * @author zhangyihang
	 * @Description 快递订单订阅
	 * @param company 快递公司的编码
	 * @param from 出发地城市
	 * @param to 目的城市
	 * @param number 快递单号
	 * @orderId 订单Id
	 */
	public void orderExpress(String company,String from,String to,String number,String orderId);
}
