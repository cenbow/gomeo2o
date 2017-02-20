package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class ConsigneeInfo   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6664080048056202963L;
	private String name;//收货人姓名
	private String  phone1;//收货人电话1
	private String phone2;//收货人电话2
	private O2MAddress address;//o2m地址
    
}
