package cn.com.gome.account.paymentpassword;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class PaymentPasswordReq implements Serializable {

	private static final long serialVersionUID = 6206932743632393139L;
	private String paymentPassword; // 支付密码，6位数字
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
