package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class SplitO2MOrderRequest implements Serializable{

	private static final long serialVersionUID = 421731871273643790L;
	String addressAreaCode;
	String saleTime;
	List<SplitO2MSkuItem> skuItems;

}
