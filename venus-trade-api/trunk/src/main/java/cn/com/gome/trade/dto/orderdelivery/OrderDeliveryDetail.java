package cn.com.gome.trade.dto.orderdelivery;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class OrderDeliveryDetail  implements Serializable {
	private static final long serialVersionUID = 3583853551124686169L;

	private Long id;

    private Long orderId;

    private Long orderDeliveryId;

    private Long orderItemId;

    private Long itemId;

    private String itemName;

    private Long skuId;

    private String skuImg;

    private Integer quantity;

    private Date createdAt;

    private Date updatedAt;
}