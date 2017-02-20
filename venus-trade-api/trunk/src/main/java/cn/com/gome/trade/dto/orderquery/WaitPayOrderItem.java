package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.MshopDto;
import cn.com.gome.trade.dto.common.SkuDto;
import cn.com.gome.trade.dto.ordercreation.ActivityDto;

@Data
public class WaitPayOrderItem implements Serializable {
	private static final long serialVersionUID = -1461894203322634898L;
	
	private Long id; 								//订单商品行ID
	private String kid;								//返利链条id
	private SkuDto sku; 							//sku
	private Integer quantity;						//商品sku购买数量
	private Integer totalPrice;						//商品总价
	private MshopDto mshop;							//美店信息
	private Boolean hasComment;     				//商品是否已评价
	private String sourceCode;			   			//来源
	private List<ActivityDto> activities;      	// 活动信息
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
