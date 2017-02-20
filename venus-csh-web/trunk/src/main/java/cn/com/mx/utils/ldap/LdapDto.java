/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午1:38:00
 */
package cn.com.mx.utils.ldap;

import java.util.List;

/**
 * @Description queryInfo-ldap返回实体
 * @author guowenbo
 * @date 2016年3月18日 下午1:38:00
 */
public class LdapDto {

	private String attribute;
	
	private List<String> value;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

	
}
