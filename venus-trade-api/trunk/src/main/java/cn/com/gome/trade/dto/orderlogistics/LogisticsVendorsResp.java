package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;

@Data
public class LogisticsVendorsResp implements Serializable {
	private static final long serialVersionUID = 7438283576251791641L;
	
	List<LogisticsVendor> logisticsVendors = Lists.newArrayList();
	private Long total;            //总数
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
