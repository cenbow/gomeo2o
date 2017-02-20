package cn.com.gome.account.accountassets;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class AccountAssetsResp implements Serializable {

	private static final long serialVersionUID = -3566386341084694932L;
	
	private Long gomeMoneyAmount;  				// 用户总共国美币余额
	private Long useableGomeMoneyAmount;  		// 用户交易可使用的国美币余额
	private Long historyGomeMoneyAmount;  		// 历史国美币总额
	private Long withdrawableGomeMoneyAmount; 	// 用户可提现国美币余额
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
