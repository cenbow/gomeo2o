package io.terminus.ecp.config.model;

import java.io.Serializable;

import lombok.Data;


/**
 * @Description: 返回编码
 * @date: 2016年1月14日 下午4:27:18
 * @param <T>
 */
@Data
public class ApiConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codeId;
	
	public String busiCode ;
	
	public String httpStatus ;
	
	public String remark;
	
	public String message;
	
	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	
	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CodeModel [busiCode=" + busiCode + ", httpStatus=" + httpStatus
				+ "]";
	}
	
	
}
