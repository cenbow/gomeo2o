/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午10:43:25
 */
package cn.com.mx.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 后台登陆人员
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午10:43:25
 */
/**
 * @Description TODO
 * @author kl_chaizhilei
 * @date 2016年2月23日 上午11:22:54
 */
public class User implements Serializable {

	private static final long serialVersionUID = -6715715367230778826L;

	private String id;

	private String account;

	private String password;

	private String tel;

	private int status;

	private String createOperator;

	private Date createTime;

	private String updateOperator;

	private Date updateTime;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateOperator() {
		return updateOperator;
	}

	public void setUpdateOperator(String updateOperator) {
		this.updateOperator = updateOperator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", tel=" + tel + ", status="
				+ status + ", createOperator=" + createOperator + ", createTime=" + createTime + ", updateOperator="
				+ updateOperator + ", updateTime=" + updateTime + "]";
	}

}
