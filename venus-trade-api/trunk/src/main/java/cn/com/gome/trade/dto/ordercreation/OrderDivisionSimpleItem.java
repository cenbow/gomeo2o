package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;
@Data
public class OrderDivisionSimpleItem implements Serializable {

	private static final long serialVersionUID = 4713703246345416609L;
	
	private Long shopId;    	//xpop商铺id
	private String kid;      	//返利链条kid
	private Long skuId;      	//skuId	
	private Integer quantity;	//数量
    private String sourceCode;  //商品来源
}
