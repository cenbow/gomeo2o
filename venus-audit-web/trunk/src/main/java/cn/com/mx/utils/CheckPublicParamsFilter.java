package cn.com.mx.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.util.NestedServletException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CheckPublicParamsFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		res.setContentType("application/json;charset=utf-8");
		try{
			chain.doFilter(req, res);	
		}catch(NestedServletException e){//捕获参数注入异常
			Throwable throwable = e.getCause();
			// 基本类型数据绑定异常
			if (throwable instanceof TypeMismatchException) {
				res.getWriter().write(new StringBuilder("{\"success\":false,\"code\":")
				.append(CodeUtil.PAMAS_ERROR).append(",\"message\":\"")
				.append(CodeUtil.PAMAS_ERROR_MSG).append(":")
				.append(((TypeMismatchException) throwable).getValue())
				.append("\",\"data\":\"\"}").toString());
				log.error(CodeUtil.RESULT_PARAMS_ERR, e);
				
				return;
			// 对象数据绑定异常
			} else if (throwable instanceof BindException) {
				BindingResult br = ((BindException) throwable).getBindingResult();
				List<ObjectError> list = br.getAllErrors();
				if (list.size() > 0) {
					FieldError fieldError = (FieldError) list.get(0);
					if (fieldError != null) {
						res.getWriter().write(new StringBuilder("{\"success\":false,\"code\":")
						.append(CodeUtil.PAMAS_ERROR).append(",\"message\":\"")
						.append(CodeUtil.PAMAS_ERROR_MSG).append(":")
						.append(fieldError.getObjectName())
						.append(":").append(fieldError.getField())
						.append(":").append(fieldError.getRejectedValue())
						.append("\",\"data\":\"\"}").toString());
						log.error(CodeUtil.RESULT_PARAMS_ERR, e);
						return;
					}
				}
			} 
			
			String errorMsg = e.getMessage().replaceAll("\"", "'");
			res.getWriter().write(new StringBuilder("{\"success\":false,\"code\":")
			.append(CodeUtil.PAMAS_ERROR).append(",\"message\":\"")
			.append(CodeUtil.PAMAS_ERROR_MSG).append(":").append(errorMsg)
			.append("\",\"data\":\"\"}").toString());
			log.error(CodeUtil.RESULT_PARAMS_ERR, e);
		}catch(Exception e){//捕获未定义异常
			res.getWriter().write(CodeUtil.REFULT_UNDEFINED_ERR);
			log.error(CodeUtil.REFULT_UNDEFINED_ERR, e);
		}	
	}

	public void destroy() {}
}
