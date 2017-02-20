package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class SplitO2MSubOrder implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4500785971091165091L;
	String subInx;
	String shopCode;
	Integer dealAmount;
	Integer discAmount;
	Integer deliverFee;
	List<SplitO2MSkuItem> skuItems;

}
