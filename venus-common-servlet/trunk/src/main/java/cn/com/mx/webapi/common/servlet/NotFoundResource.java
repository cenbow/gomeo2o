package cn.com.mx.webapi.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mx.webapi.common.model.ResponseModel;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 匹配所有未发现的资源 
 * <p>url-pattern匹配规则和顺序：
 * 		<p> 1.精确路径匹配
 * 		<p> 2.最长路径匹配
 * 		<p> 3.扩展匹配
 * 		<p> 4.缺省匹配
 * @author wanggang-ds6
 * @date 2016年1月25日 上午10:25:20
 */
@WebServlet("/*")
public class NotFoundResource extends HttpServlet {

	private static final long serialVersionUID = -7992726432075272497L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}
	
	/**
	 * @Description 处理所有未发现的请求 ，返回403
	 * @author wanggang-ds6
	 * @date 2016年1月25日 上午10:31:08
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().write(JSONObject.toJSONString(new ResponseModel()));
		resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}

}
