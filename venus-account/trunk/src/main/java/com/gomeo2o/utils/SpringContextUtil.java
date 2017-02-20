/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: guowenbo
 * @date: 2015年5月26日 下午8:26:53
 */
package com.gomeo2o.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: 工具 
 * @author: guowenbo
 * @date: 2015年5月26日 下午8:26:53
 */
public class SpringContextUtil implements ApplicationContextAware {
	
    private static ApplicationContext applicationContext;  
 
	public void setApplicationContext(ApplicationContext applicationContext) {  
	     SpringContextUtil.applicationContext = applicationContext;  
	}  
  
    public static ApplicationContext getApplicationContext() {  
        return applicationContext;  
    }  
  
	public static Object getBean(String name) throws BeansException {  
	    return applicationContext.getBean(name);  
	}  

}
