package cn.com.gome.trade.enums;

import io.terminus.ecp.trade.enums.Status;

public enum MessageNotifyTypeEnum {
	NotifySellerDelivery(1,UserType.BUYER,Status.PAID,MessageAlertType.OrderCreateNotifyToSeller,"提醒卖家发货");
	private final Integer messageType;
	private final UserType userType;
	private final Status orderStatus;
	private final MessageAlertType messageAlertType;
	private final String description;
	private MessageNotifyTypeEnum(Integer messageType,UserType userType,Status orderStatus,MessageAlertType messageAlertType,String description){
		this.messageType = messageType;
		this.userType = userType;
		this.orderStatus = orderStatus;
		this.messageAlertType = messageAlertType;
		this.description = description;
	}
	public int messageType(){
		return this.messageType;
	}
	public UserType userType(){
		return this.userType;
	}
	public Status status(){
		return this.orderStatus;
	}
	public MessageAlertType messageAlertType(){
		return this.messageAlertType;
	}
	public String description(){
		return this.description;
	}
	public static MessageNotifyTypeEnum fromType(Integer messageType){
		for(MessageNotifyTypeEnum type:MessageNotifyTypeEnum.values()){
			if(type.messageType.equals(messageType)){
				return type;
			}
		}
		return null;
	}
	
	public enum UserType{
		BUYER(1),
		SELLER(2);
		private final int type;
		private UserType(int type){
			this.type=type;
		}
	}

}
