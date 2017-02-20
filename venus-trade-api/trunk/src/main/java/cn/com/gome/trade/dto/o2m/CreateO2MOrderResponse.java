package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreateO2MOrderResponse   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6192460365184070336L;
	private String respCode;//响应码,ok为成功，param.xxx为请求数据格式有误,logic.xxx为逻辑判断有错（比如店铺号不存在或逆向时原订单号不存在等）,error.xxx为系统处理出错
	private String respMsg;//响应信息
	private O2MOrder order;//o2m主订单

}
