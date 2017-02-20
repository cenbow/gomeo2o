package cn.com.gome.trade.dto.orderdelivery;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class OrderDelivery  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long orderId;

    private String outOrderId;

    private Long buyerId;

    private Long sellerId;

    private String status;

    private Integer type;

    private String outDeliveryId;

    private String logisticsNo;

    private Long logisticsVendorId;

    private String logisticsVendorName;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isDel;
}