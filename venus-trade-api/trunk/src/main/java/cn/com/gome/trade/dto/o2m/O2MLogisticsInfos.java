package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class O2MLogisticsInfos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1828994867885230112L;
	private List<O2MLogisticsInfo> messages;
}
