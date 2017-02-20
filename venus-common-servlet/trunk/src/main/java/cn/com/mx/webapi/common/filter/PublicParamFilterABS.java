package cn.com.mx.webapi.common.filter;

import java.lang.reflect.Method;
import java.net.URLDecoder;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import cn.com.mx.webapi.common.constant.PublicParamsConstant;
import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;
import cn.com.mx.webapi.common.exceptions.code.C406Exception;
import cn.com.mx.webapi.common.exceptions.code.C422Exception;
import cn.com.mx.webapi.common.model.PublicParams;

public abstract class PublicParamFilterABS {
	public void publicParam(ServletRequest sr){
		HttpServletRequest req = (HttpServletRequest)sr;
		String pathInfo = req.getPathInfo(); 
		PublicParams model = new PublicParams();
		setValue(req,model,PublicParamsConstant.X_GOMEPLUS_TOKEN,PublicParamsConstant.QUERY_PARAM_X_GOMEPLUS_TOKEN,"setToken",String.class,pathInfo,false);
		setValue(req,model,PublicParamsConstant.X_GOMEPLUS_ACCESSTOKEN,PublicParamsConstant.QUERY_PARAM_X_GOMEPLUS_ACCESSTOKEN,"setAccessToken",String.class,pathInfo,false);
		setValue(req,model,PublicParamsConstant.X_GOMEPLUS_DEVICE,PublicParamsConstant.QUERY_PARAM_X_GOMEPLUS_DEVICE,"setDevice",String.class,pathInfo,false);
		setValue(req,model,PublicParamsConstant.X_GOMEPLUS_APP,PublicParamsConstant.QUERY_PARAM_X_GOMEPLUS_APP,"setApp",String.class,pathInfo,false);
		setValue(req,model,PublicParamsConstant.X_GOMEPLUS_NET,PublicParamsConstant.QUERY_PARAM_X_GOMEPLUS_NET,"setNet",String.class,pathInfo,false);
		setValue(req,model,PublicParamsConstant.ACCEPT,PublicParamsConstant.QUERY_PARAM_ACCEPT,"setAccept",String.class,pathInfo,false);
		setValue(req,model,PublicParamsConstant.TRACEID,PublicParamsConstant.QUERY_PARAM_TRACEID,"setTraceId",String.class,pathInfo,false);
		setValue(req,model,PublicParamsConstant.JSONP,PublicParamsConstant.QUERY_PARAM_JSONP,"setJsonp",String.class,pathInfo,false);
		req.setAttribute(PublicParamsConstant.PUBLIC_PARAMS_NAME, model);
		checkAccept(model);
	}
	private void setValue(HttpServletRequest req, PublicParams model, String key,String queryParamKey,String methodName,Class<?> keyType,String pathInfo,boolean isNullAble) {
		try {
			String value = null;
			if (req.getParameter(queryParamKey) != null) {
				value = req.getParameter(queryParamKey);
			} else {
				if (req.getHeader(key) != null) {
					value = req.getHeader(key);
				}
			}
			if(isNullAble&&value==null){
				throw new C422Exception(BaseExceptionMessage.CHECK_DATA_FAILED.setArgs(key));
			}
			if(value!=null){
				value = URLDecoder.decode(value, "UTF-8");
				setvalueByInvokeMethod(req, model, pathInfo, keyType, key, value,methodName);
			}
		} catch (Exception ex) {
			throw new C422Exception(BaseExceptionMessage.CHECK_DATA_FAILED.setArgs(key));
		}
	}
	private void setvalueByInvokeMethod(HttpServletRequest req, PublicParams model,
			String pathInfo, Class<?> keyType, String key, String value,String methodName)
			throws Exception {
		Method method = model.getClass().getMethod(methodName,
				keyType);
		if ("Integer".equals(keyType.getSimpleName())) {
			method.invoke(model,Integer.valueOf(value));
		} else if ("Long".equals(keyType.getSimpleName())) {
			method.invoke(model,Long.valueOf(value));
		} else if ("String".equals(keyType.getSimpleName())) {
			method.invoke(model,value);
		} else {
			throw new RuntimeException("unhandled exception !");
		}

	}
	private void checkAccept(PublicParams model){
		String accept = model.getAccept();
		if(accept.indexOf(PublicParamsConstant.ACCEPT_TYPE_JAVASCRIPT)<0
				&&accept.indexOf(PublicParamsConstant.ACCEPT_TYPE_JSON)<0
					&&accept.indexOf(PublicParamsConstant.ACCEPT_TYPE_ANYTHING)<0
						&&accept.indexOf(PublicParamsConstant.ACCEPT_TYPE_APPLICATION_ANYTHING)<0){
			throw new C406Exception(BaseExceptionMessage.NOT_ACCEPTABLE);
		}
	}
}
