package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class TradeItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016093001173441921L;
	private Long id;
	private String outerItemId;
	private String name;
	private Long brandId;
	private String brandName;
}
