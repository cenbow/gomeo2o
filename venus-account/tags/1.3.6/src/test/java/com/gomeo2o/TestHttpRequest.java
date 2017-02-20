/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年9月29日 下午2:54:53
 */
package com.gomeo2o;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * @Description: java模拟http请求  来源于一个第三方的jar https://github.com/kevinsawicki/http-request/
 * 	<dependency>
 *		<groupId>com.github.kevinsawicki</groupId>
 *		<artifactId>http-request</artifactId>
 *		<version>5.6</version>
 *	<dependency>
 * @author: fengxin
 * @date: 2015年9月29日 下午2:54:53
 */
public class TestHttpRequest {
	
	private static final String URL="http://www.baidu.com";
	/**
	 * 
	 * @Description: java模拟get请求 
     * @author: fengxin
     * @date: 2015年9月29日 下午3:03:13
     * @return void    
	 */
	public static void testPostRequest(){
		int responseCode = HttpRequest.get(URL).code();
		String response = HttpRequest.get(URL).body();
		System.out.println("状态码："+responseCode+";返回结果："+response);
	}
	/**
	 * 
	 * @Description: java模拟post请求
     * @author: fengxin
     * @date: 2015年9月29日 下午3:03:46
     * @return void    
	 */
	public static void testGetRequest(){
		String parameter ="";
		int responseCode = HttpRequest.post(URL).send(parameter.toString()).code();
		String response = HttpRequest.post(URL).send(parameter.toString()).body();
		System.out.println("状态码："+responseCode+";返回结果："+response);
	}
	/**
	 * @Description: TODO 
	 * @author: fengxin
	 * @date: 2015年9月29日 下午2:54:53
	 * @param args
	 * @return void    
	 * @throws
	 */
	public static void main(String[] args) {
		//testPostRequest();
		testGetRequest();

	}

}
