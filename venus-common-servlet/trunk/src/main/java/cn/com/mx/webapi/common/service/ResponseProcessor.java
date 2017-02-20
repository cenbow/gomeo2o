package cn.com.mx.webapi.common.service;

import io.terminus.ecp.config.center.ConfigCenter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.mx.webapi.common.constant.PublicParamsConstant;
import cn.com.mx.webapi.common.exceptions.code.BaseCodeException;
import cn.com.mx.webapi.common.exceptions.code.C301Exception;
import cn.com.mx.webapi.common.exceptions.code.C302Exception;
import cn.com.mx.webapi.common.model.PublicParams;
import cn.com.mx.webapi.common.model.ResponseModel;
import cn.com.mx.webapi.common.utils.ParametersPrinter;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 应答处理 
 * @author wanggang-ds6
 * @date 2016年1月27日 上午11:55:34
 */
@Slf4j
@Component
public class ResponseProcessor {
		
	@Autowired
	private ConfigCenter configCenter;
	
	/**
	 * @Description 拼接应答 
	 * @author wanggang-ds6
	 * @date 2016年1月27日 下午12:00:16
	 * @param req
	 * @param resp
	 * @param responseModel
	 * @throws IOException 
	 */
	public void process(HttpServletRequest req, HttpServletResponse resp, ResponseModel responseModel) throws IOException {
		PublicParams model = (PublicParams) req.getAttribute(PublicParamsConstant.PUBLIC_PARAMS_NAME);	
		String accept = null;
		if (model != null) {
			accept = model.getAccept();
		}
		resp.setCharacterEncoding("UTF-8");
		if (accept != null && accept.indexOf(PublicParamsConstant.ACCEPT_TYPE_JAVASCRIPT) > -1) {
			resp.setHeader("Content-type", "application/javascript");	
			responseModel.setStatus(resp.getStatus());
			resp.setStatus(200);
			resp.getWriter().write(model.getJsonp() + "(" + JSONObject.toJSONString(responseModel) + ")");
		} else {
			resp.setHeader("Content-type", "application/json");
			resp.getWriter().write(JSONObject.toJSONString(responseModel));	
		}
	
		// 记录结果
		ParametersPrinter.setResponseModel(responseModel);
		ParametersPrinter.setResponseCode(resp.getStatus());
	}
	
	/**
	 * @Description 设置重定向返回信息 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午2:18:41
	 * @param hsReq
	 * @param hsResp
	 * @param e
	 * @throws IOException 
	 */
	public void modifyRedirectResponse(HttpServletRequest hsReq, HttpServletResponse hsResp, Exception e) throws IOException {
		if (e instanceof C301Exception) {
			C301Exception c301e = (C301Exception) e;
			log.info("重定向", c301e);
			hsResp.setStatus(c301e.getCode());
			hsResp.sendRedirect(c301e.getRedirectPath());
			
			// 记录结果
			ParametersPrinter.setResponseRedirect(c301e.getRedirectPath());
		} else if (e instanceof C302Exception) {
			C302Exception c302e = (C302Exception) e;
			log.info("302重定向", c302e);
			hsResp.setStatus(c302e.getCode());			
			hsResp.sendRedirect(c302e.getRedirectPath());
			
			// 记录结果
			ParametersPrinter.setResponseRedirect(c302e.getRedirectPath());
		}
		process(hsReq, hsResp, new ResponseModel());
	}
	
	/**
	 * @Description 设置异常返回信息 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午2:28:05
	 * @param hsReq
	 * @param hsResp
	 * @param e
	 * @throws IOException
	 */
	public void modifyExceptionResponse(HttpServletRequest hsReq, HttpServletResponse hsResp, Exception e) throws IOException {
		ResponseModel responseModel = new ResponseModel();
		boolean isPrintDebug = isPrintDebug();
		if (e instanceof BaseCodeException) {
			BaseCodeException bce = (BaseCodeException) e;
			log.error("过滤器捕获code异常", bce);
			hsResp.setStatus(bce.getCode());
			responseModel.setMessage(bce.getMessage());			
		} else {
			log.error("过滤器捕获异常", e);
			hsResp.setStatus(500);
			responseModel.setMessage("服务端异常！");
			if (isPrintDebug) {
				responseModel.setDebug(e.getMessage() + ":" + Arrays.asList(e.getStackTrace()));
			}
		}
		process(hsReq, hsResp, responseModel);
	}
	
	/**
	 * @Description 是否打印调试信息 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 下午2:13:34
	 * @return
	 */
	private boolean isPrintDebug() {
		String debugStatus = configCenter.get(PublicParamsConstant.WEBAPI_DEBUG_STATUS);
		if (debugStatus != null && debugStatus.trim().length() > 0 
				&& debugStatus.trim().equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
}
