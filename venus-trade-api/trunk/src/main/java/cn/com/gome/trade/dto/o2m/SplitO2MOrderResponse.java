package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;
@Data
public class SplitO2MOrderResponse implements Serializable{
	
	private static final long serialVersionUID = 5393593852689229732L;
	String respCode;
	String respMsg;
	SplitO2MOrder order;
	

}
