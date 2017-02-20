package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class SplitO2MOrder implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4188579843811735398L;
	String tempOrderId;
	List<SplitO2MSubOrder> subOrders;

}
