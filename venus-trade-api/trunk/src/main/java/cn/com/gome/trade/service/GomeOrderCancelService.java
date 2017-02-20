package cn.com.gome.trade.service;

import io.terminus.ecp.trade.model.Order;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * 
 * @Description 订单相关活动处理
 * @author wangjiatian
 * @date 2016年8月17日 下午4:17:33
 */
public interface GomeOrderCancelService {

	/**
	 * 
	 * @param list 处理订单集合
	 * @param type 操作类型 1：同意取消  2:拒绝取消
	 * @return
	 */
	public Response<Boolean> dealCanceOrder(List<Order> orders,String type);
	
}
