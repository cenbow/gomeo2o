package cn.com.gome.trade.dto.orderquery;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.SellerDto;
import cn.com.gome.trade.dto.common.ShopDto;

@Data
public class WaitPayOrder implements Serializable {
	private static final long serialVersionUID = -1461894203322634898L;
	
	private Long id;          					//订单ID
	private Integer orderType;					//订单类型
	private Integer payType;					//支付类型，线上支付
	private SellerDto seller; 					//供应商信息
	private ShopDto shop;     					//供应商店铺信息
	private Integer orderAmount;				//订单金额
	private Integer paymentAmount;				//订单实付金额
	private List<WaitPayOrderItem> orderItems;	//订单商品行信息
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
