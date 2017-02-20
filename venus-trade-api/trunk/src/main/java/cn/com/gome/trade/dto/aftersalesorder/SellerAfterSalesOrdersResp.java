package cn.com.gome.trade.dto.aftersalesorder;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;

import lombok.Data;

/**
 * 
 * @Description TODO 卖家售后单列表返回
 * @author wangjiatian
 * @date 2016年7月21日 下午1:52:52
 */
@Data
public class SellerAfterSalesOrdersResp implements Serializable {
	
	private static final long serialVersionUID = -36484675490272570L;
	private List<SellerAfterSalesOrder> afterSalesOrders = Lists.newArrayList();
	private Long total;            //总订单数
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
