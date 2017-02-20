/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月15日 上午10:36:25
 */
package cn.com.mx.count.sns.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
 * @Description 爱生活帖子单条初始化
 * @author kl_chaizhilei
 * @date 2016年1月15日 上午10:36:25
 */

@Slf4j
@WebServlet("/snsSingle")
public class SnsLovelifePostSingleServlet extends HttpServlet {

	private static final long serialVersionUID = 1423822033895045559L;

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
		long result = 0l;
		int type = Integer.parseInt(request.getParameter("type"));
		int see = Integer.parseInt(request.getParameter("see"));
		try {
			String postId = request.getParameter("postId");
			if (type == 0) {
				CacheCount.set(RedisConstants.CHECK_SNS_POST_COMMENT, 1L);
				result = SnsLovelifePostNumTemplate.snsCommentSingleNum(postId, see);
				CacheCount.set(RedisConstants.CHECK_SNS_POST_COMMENT, 0L);
			} else if (type == 1) {
				CacheCount.set(RedisConstants.CHECK_SNS_POST_ISLIKE, 1L);
				result = SnsLovelifePostNumTemplate.snsLikeSingleNum(postId, see);
				CacheCount.set(RedisConstants.CHECK_SNS_POST_ISLIKE, 0L);
			}
			if (see == 0) {
				pw.println("执行结果完毕,postId" + postId + ";共统计了" + result + "结果");
			} else {
				pw.println("查询结果完毕,postId:" + postId + ";共查询出" + result + "结果");
			}
		} catch (Exception e) {
			log.error("打印回执结果失败", e);
			if (type == 1) {
				CacheCount.set(RedisConstants.CHECK_SNS_POST_COMMENT, 0L);
			} else if (type == 2) {
				CacheCount.set(RedisConstants.CHECK_SNS_POST_ISLIKE, 0L);
			}
			pw.println("执行错误" + e.getMessage() + "");
		}
	}

}
