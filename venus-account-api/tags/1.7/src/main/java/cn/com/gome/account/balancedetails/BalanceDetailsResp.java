package cn.com.gome.account.balancedetails;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class BalanceDetailsResp implements Serializable {

	private static final long serialVersionUID = -7598310591348539084L;
	
	private Long id;					// 返利id或者余额提现id
	private Integer type;				// 收支明细类型，1:返利2:消费3:退款4提现
	private Long detailNo;   			//Long，不为空，流水号
	private Long recordTime;			// 记录成功日期
	private Integer money;				// 收支金额
	private Integer flag;				// 0:出账 1:入账
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
