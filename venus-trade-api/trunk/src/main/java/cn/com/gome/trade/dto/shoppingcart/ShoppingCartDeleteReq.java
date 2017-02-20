package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShoppingCartDeleteReq implements Serializable {
	private static final long serialVersionUID = -5660255598682693722L;
	private String ids;				// 删除主键

}
