package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


/**
 * 外部合单和订单集合
 * @author wangjiatian
 *
 */
@Data
public class OrdersAndSubOrders implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5468486106718883125L;

	private List<O2MOrder> orders = new ArrayList<O2MOrder>();

	private List<SubOrder> subOrders = new ArrayList<SubOrder>();
}
