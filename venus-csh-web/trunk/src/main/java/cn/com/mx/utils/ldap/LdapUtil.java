/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午1:24:18
 */
package cn.com.mx.utils.ldap;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.base.exception.CshException;

/**
 * @Description Ldap操作工具
 * @author guowenbo
 * @date 2016年3月18日 下午1:24:18
 */
@Slf4j
public class LdapUtil extends BaseLdap{
	
	/**
	 * @Description 简单的条件查询 
	 * @author guowenbo
	 * @date 2016年3月18日 下午1:25:27
	 * @param base 基础节点 （dc=meixin,dc=com）
	 * @param scope 查询范围（默认0：遍历，1：单层，2：本节点）
	 * @param resultAttrutes[] 指定查询属性（不需要指定则传递null：查询符合条件的所有属性；）
	 * @param searchFilter 查询条件（属性名=值，如："sAMAccountName=guowenbo" 查询所有sAMAccountName属性值为guowenbo的数据；"objectclass=*"默认查询全部。）
	 * return List<LdapDto>
	 */
	@SuppressWarnings("rawtypes")
	public static List<LdapDto> queryInfo(String base,int scope,String resultAttrutes[],String searchFilter){
		List<LdapDto> dtoList = new ArrayList<LdapDto>();
		SearchControls searchCtls = new SearchControls();
		if(scope==0){
			//默认
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		}else if(scope==1){
			searchCtls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
		}else if(scope==2){
			searchCtls.setSearchScope(SearchControls.OBJECT_SCOPE);
		}else{
			throw CshException.PARAM_IS_ERROR;
		}
		searchCtls.setReturningAttributes(resultAttrutes);
		try {
			NamingEnumeration answer = dc.search(base, searchFilter,
					searchCtls);
			if (answer == null || answer.equals(null)) {
				return dtoList;
			}
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();
				Attributes Attrs = sr.getAttributes();
				if (Attrs != null) {
					try {
						LdapDto dto;
						List<String> valueList;
						for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
							Attribute Attr = (Attribute) ne.next();
							dto = new LdapDto();
							dto.setAttribute(Attr.getID().toString());
							valueList = new ArrayList<String>();
							for (NamingEnumeration e = Attr.getAll(); e.hasMore();) {
								valueList.add(e.next().toString());
							}
							dto.setValue(valueList);
							dtoList.add(dto);
						}
					} catch (NamingException e) {
						throw CshException.LDAP_FILE;
					}
				}
			}
		} catch (Exception e) {
			throw CshException.LDAP_FILE;
		}
		return dtoList;
	}
	
	//普通用户登录验证
	public static boolean checkLdapByUser(String userName,String password){
		Hashtable<String, String> env = new Hashtable<String, String>();
		String LDAP_URL = "ldap://10.69.100.1:389";
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, LDAP_URL);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, userName);
		env.put(Context.SECURITY_CREDENTIALS, password);
		try {
			dc = new InitialDirContext(env);
		} catch (javax.naming.AuthenticationException e) {
			log.error("账户认证失败，账号或密码不正确！");
			return false;
		} catch (Exception e) {
			log.error("账户认证出错：{}",e);
			return false;
		}
		return true;
	}
}
