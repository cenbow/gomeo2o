/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月12日 上午10:17:57
 */
package cn.com.mx.count.sns.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.sns.post.template.SnsLovelifePostNumTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

/**
 * @Description sns相关数据初始化
 * @author kl_chaizhilei
 * @date 2016年1月12日 上午10:17:57
 */
@Slf4j
@WebServlet("/snsinit")
public class SnsLovelifePostNumServlet extends HttpServlet {

	private static final long serialVersionUID = -4527356476944554768L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter pw = null;
	    try {
	        request.setCharacterEncoding("utf-8");
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        pw = response.getWriter();
        } catch (Exception e) {
            log.error("request、response",e);
        }
		
		try {
            CacheCount.set(RedisConstants.CHECK_SOCIAL_GROUP_ALL,1L);
            String result = SnsLovelifePostNumTemplate.snsLovelifePostAllNumTemplate();
            CacheCount.set(RedisConstants.CHECK_SOCIAL_GROUP_ALL,0L);
            pw.println(result);
        } catch (Exception e) {
            log.error("打印回执结果失败",e);
            CacheCount.set(RedisConstants.CHECK_SOCIAL_GROUP_ALL,0L);
            pw.println("执行错误"+e.getMessage()+"");
        }
	}

}
