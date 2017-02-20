package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class ItemStockRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8424329962875941661L;
	
	List<ItemStock> items;

	

}
