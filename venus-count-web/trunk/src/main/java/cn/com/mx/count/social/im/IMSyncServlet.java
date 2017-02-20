/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月21日 下午1:52:01
 */
package cn.com.mx.count.social.im;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.social.im.Template.IMSyncTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

/**
 * @Description IM同步会员数据数据
 * @author kl_chaizhilei
 * @date 2016年1月21日 下午1:52:01
 */
@Slf4j
@WebServlet("/imsyncdata")
public class IMSyncServlet extends HttpServlet {

	private static final long serialVersionUID = 8248258604175952942L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			pw = response.getWriter();
		} catch (Exception e) {
			log.error("requestrequest、response", e);
		}
		
		int type = Integer.parseInt(request.getParameter("type"));
		String result = "";
		try {
			if(type==0){
				CacheCount.set(RedisConstants.CHECK_IM_GROUP,1L);
				result = IMSyncTemplate.syncGroupTemplate();
				CacheCount.set(RedisConstants.CHECK_IM_GROUP,0L);
		    }else if(type==1){
		    	CacheCount.set(RedisConstants.CHECK_IM_GROUP_PERSON,1L);
		    	result = IMSyncTemplate.syncPersonTemplate();
		    	CacheCount.set(RedisConstants.CHECK_IM_GROUP_PERSON,0L);
		    }
			pw.println("执行结果完毕,"+result);
		} catch (Exception e) {
			CacheCount.set(RedisConstants.CHECK_IM_GROUP,0L);
			CacheCount.set(RedisConstants.CHECK_IM_GROUP_PERSON,0L);
			pw.println("执行错误" + e.getMessage() + "");
		}
	}
}
