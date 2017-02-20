package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;
@Data
public class SplitO2MSkuItem implements Serializable{
	
	private static final long serialVersionUID = -4116320618590703785L;
	String skuInx;
	String shopCode;
	Integer skuId;
	Integer outerSkuId;
	Integer retailPrice;
	Integer dealPrice;
	Integer dealAmount;
	Integer discAmount;
	Integer saleNum;

}
