package cn.com.gome.trade.dto.orderStastics;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author wangjiatian
 * @descrption 用户订单数量的资源
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusCount implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 6482626605686821854L;

	private Integer pendPayment;
	private Integer pendDelivery;
	private Integer pendReceiving;
	private Integer pendComment;
}
