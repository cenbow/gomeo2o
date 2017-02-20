package cn.com.gome.trade.dto.push;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class AfterSalesOrderMessage implements Serializable {
	private static final long serialVersionUID = -6250960240942329877L;
	
	private PushAfterSalesOrder afterSalesOrder;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
