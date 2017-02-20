package cn.com.mx.webapi.servlet.demo;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;

public class ExceptionMessage extends BaseExceptionMessage {

	protected ExceptionMessage(String message) {
		super(message);
	}
	
	public static final ExceptionMessage ONLY_NOTHING_THETHING_CAN_BE = new  ExceptionMessage("Only Nothing theThing can be.");

}
