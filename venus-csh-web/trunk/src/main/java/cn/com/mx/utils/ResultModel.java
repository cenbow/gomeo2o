package cn.com.mx.utils;

import java.io.Serializable;

/**
 * 
 * @Description Controller层返回数据实体类 
 * @author wangchangye
 * @date 2016年1月28日 下午1:45:57
 * @param <T>
 */
public class ResultModel<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处理结果
	 */
	private Boolean success = true;  
	
	/**
	 * 	响应码：0为成功，其他：失败（六位数正整形） 默认SUCCESS
	 */
	private int code = CodeUtil.SUCCESS;
	
	/**
	 * 	响应信息，默认SUCCESS_MSG
	 */
	private String message = CodeUtil.SUCCESS_MSG;
	
	/**
	 * 	返回数据, 如果没有返回数据时，可定义为String类型，赋予""空值
	 */
	private T data;
	
	public ResultModel(){
		
	}
	
	public ResultModel(Boolean success, int code, String message, T data){
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}	
	
}
