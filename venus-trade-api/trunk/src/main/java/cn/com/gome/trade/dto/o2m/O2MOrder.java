package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class O2MOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3008127216419230096L;
	private Long orderId;//成功后返回的O2M主订单ID
	private Integer status;//订单状态 
	private List<SubOrder> subOrders;//成功后返回的O2M子订单列表
	
	public static enum Status{
		CANCELED(-10,-6,"已取消"),
		WATING_BUYER_PAY(0,0,"未付款"),
		PAID(10,1,"已付款"),
		DELIVERED(20,2,"已发货"),
		DONE(30,3,"确认收货");
		private final int outValue;
		private final int inValue;
		private final String description;
		
		private Status(int o2mValue,int mValue,String description){
			this.outValue=o2mValue;
			this.inValue=mValue;
			this.description=description;
		}
		
		public int inValue(){
			return this.inValue;
		}
		public int outValue(){
			return this.outValue;
		}
		public static Status fromInvalue(int value){
			for(Status s:Status.values()){
				if(value==s.inValue)
					return s;
			}
			return null;
		}
	}

}
