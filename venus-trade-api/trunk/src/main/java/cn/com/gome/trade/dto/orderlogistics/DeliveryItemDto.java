package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeliveryItemDto implements Serializable {
	private static final long serialVersionUID = 2487295797735724622L;
	private Long id; //商品Id
	private String name; //商品名称
}
