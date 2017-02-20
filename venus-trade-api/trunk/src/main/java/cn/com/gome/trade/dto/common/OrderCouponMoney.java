package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class OrderCouponMoney implements Serializable {
	private static final long serialVersionUID = -1769045569523223355L;
	private Integer platformCouponMoney = 0;		//平台优惠券金额
	private Integer shopCouponMoney = 0;			//店铺优惠券金额
	private Integer onePurchaseMoney = 0;			//下单立减金额
	private Integer shopDiscountMoney = 0;			//直降金额

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
