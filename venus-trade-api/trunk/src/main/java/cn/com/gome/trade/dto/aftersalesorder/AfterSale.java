package cn.com.gome.trade.dto.aftersalesorder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import cn.com.gome.trade.dto.ordercreation.Buyer;
import cn.com.gome.trade.dto.ordercreation.CreationOrderItem;

/**
 * 
 * @Description TODO 售后订单
 * @author wangjiatian
 * @date 2016年6月12日 下午5:00:25
 */
@Data
public class AfterSale implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 582989806274675882L;

	private Long id;
	private Integer type;
	private String typeDesc;
	private String statusDesc;
	private Integer orderType;
	private Integer totalPrice;
	private Integer paymentAmount;
	private Integer shippingCost;
	private Integer totalQuantity;
	private String reason;
	private String memo;
    private Long orderId;
    private Boolean hasLogistics;
    private Buyer buyer;
    private Integer mshopCommission;
    private Integer maxRefundShippingCost;
    private List<CreationOrderItem> orderItems = new ArrayList<CreationOrderItem>();
}
