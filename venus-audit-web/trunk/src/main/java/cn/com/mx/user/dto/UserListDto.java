/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年2月23日 下午4:18:36
 */
package cn.com.mx.user.dto;

import java.io.Serializable;

/**
 * @Description 展示管理用户列表
 * @author kl_chaizhilei
 * @date 2016年2月23日 下午4:18:36
 */
public class UserListDto implements Serializable {

	private static final long serialVersionUID = -8234006011506034101L;

	private String id;

	private String account;

	private String createrName;

	private String createTime;

	private int status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
