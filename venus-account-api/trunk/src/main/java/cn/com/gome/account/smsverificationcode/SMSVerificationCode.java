package cn.com.gome.account.smsverificationcode;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

/**
 * @author  wangzhenpeng
 * @date 2016年7月23日 上午11:09:18
 * @version 1.0
 */
@Data
public class SMSVerificationCode implements Serializable {

	private static final long serialVersionUID = 8265564737580819016L;
	private String verifyToken = null;				// 校验流程token
	private String verifyCode = null;				// 校验码


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
}
