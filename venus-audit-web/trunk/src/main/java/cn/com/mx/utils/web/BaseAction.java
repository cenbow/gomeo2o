package cn.com.mx.utils.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

/**
 * @Description 后续扩展 
 * @author yuanchangjun
 * @date 2016年1月28日 下午3:16:41
 */
public class BaseAction implements InitializingBean,ServletContextAware{
	
	protected Map<String,String> params = new HashMap<String,String>();
	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}