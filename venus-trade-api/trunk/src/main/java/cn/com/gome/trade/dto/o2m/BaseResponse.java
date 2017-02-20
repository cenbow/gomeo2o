package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 7153224232345630156L;
	String respCode;//响应码,ok为成功
    String respMsg;//响应信息

}
