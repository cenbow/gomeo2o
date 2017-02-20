package cn.com.mx.webapi.common.annotation;

import java.lang.reflect.Method;

/**
 * @Description 登录注解处理 
 * @author wanggang-ds6
 * @date 2016年1月22日 上午11:55:41
 */
public class LoggedInProcessor {
	
	/**
	 * @Description 是否需要登录 
	 * @author wanggang-ds6
	 * @date 2016年1月22日 上午11:54:47
	 * @param obj 类
	 * @param methodName 方法名
	 * @param parameterTypes 参数类型
	 * @return 是否需要登录
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static boolean needLogIn(Object obj, String methodName,  Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
		Method method = obj.getClass().getMethod(methodName, parameterTypes);
		method.setAccessible(true);
		if (!method.isAnnotationPresent(LoggedIn.class)) {
			return false;
		}
		LoggedIn loggedin = method.getAnnotation(LoggedIn.class);
		return loggedin.value();
	}
}
