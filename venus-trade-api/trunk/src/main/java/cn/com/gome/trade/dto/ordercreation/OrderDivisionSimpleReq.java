package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class OrderDivisionSimpleReq implements Serializable {
	
	private static final long serialVersionUID = 3429125579323804394L;
	
	private Long addressId;    //地址id
	//private Integer gomeMoney;//可用国美币
	private List<OrderDivisionSimpleItem> orderItems = new ArrayList<OrderDivisionSimpleItem>();  //订单预览项

}
