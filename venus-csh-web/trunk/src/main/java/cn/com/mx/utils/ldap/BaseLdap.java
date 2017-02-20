/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author Administrator
 * @date 2016年3月18日 下午1:29:12
 */
package cn.com.mx.utils.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description ldap 
 * @author guowenbo
 * @date 2016年3月18日 下午1:29:12
 */
@Slf4j
public class BaseLdap {

	//上下文，可由此进行简单操作
	public static DirContext dc = null;
	
	static {
		Hashtable<String, String> env = new Hashtable<String, String>();
		String LDAP_URL = "ldap://10.69.100.1:389";
		String adminName = "cn=fuwuyanfarenzheng,ou=系统账号,dc=meixin,dc=com";
		String adminPassword = "binYB\\W_Uc\\Q";
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, LDAP_URL);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, adminName);
		env.put(Context.SECURITY_CREDENTIALS, adminPassword);
		try {
			dc = new InitialDirContext(env);
		} catch (javax.naming.AuthenticationException e) {
			log.error("账户认证失败，账号或密码不正确！");
		} catch (Exception e) {
			log.error("账户认证出错：{}",e);
		}
	}
}
