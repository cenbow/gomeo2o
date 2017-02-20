package cn.com.gome.trade.service;

import java.util.List;
import java.util.Map;

import io.terminus.pampas.common.Response;

/**
 * 
 * @Description 订单相关活动处理
 * @author wangjiatian
 * @date 2016年8月17日 下午4:17:33
 */
public interface GomeOrderActivityService {

	/**
	 * 
	 * @Description 取消订单和订单退款 
	 * @author wangjiatian
	 * @date 2016年8月17日 下午4:29:35
	 * @param succOrder 成功支付订单的orderlist map 里面key为mergerOrderId
	 * @param noPayOrder 没有支付成功的订单orderlist
	 * @param params
	 * @return
	 */
	public Response<Boolean> cancelOrRefundOrder(List<Map<String, Object>> succOrder,List<Map<String, Object>> noPayOrder,Map<String,Object> params);
	
}
