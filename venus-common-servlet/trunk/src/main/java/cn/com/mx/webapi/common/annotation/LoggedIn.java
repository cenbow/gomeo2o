package cn.com.mx.webapi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 是否需要登录 
 * @author wanggang-ds6
 * @date 2016年1月21日 下午3:25:32
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggedIn {
	
	/**
	 * @Description 缺省需要登录 
	 * @author wanggang-ds6
	 * @date 2016年1月22日 上午11:10:27
	 * @return true
	 */
	boolean value() default true; 
}
