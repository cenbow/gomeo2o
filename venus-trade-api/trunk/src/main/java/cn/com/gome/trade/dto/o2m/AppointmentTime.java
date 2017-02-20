package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class AppointmentTime   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2527431737144361942L;
	private String date;//日期
	private String time1;//开始时间
	private String time2;//结束时间

}
