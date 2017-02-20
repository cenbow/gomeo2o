package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class ItemStockResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4182472059083333254L;
    String respCode;//响应码,ok为成功
    String respMsg;//响应信息
    List<ItemStock> items;//o2m库存信息
	
    
}
