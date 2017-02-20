package cn.com.mx.count.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.user.template.UserTemplate;
import cn.com.mx.count.utils.RedisConstants;
import lombok.extern.slf4j.Slf4j;


/**
 * @Description 单个初始化会员信息到redis 
 * @author jiale
 * @date 2016年3月7日 下午5:47:29
 */
@Slf4j
@WebServlet("/user/initinfosingle")
public class UserServletSingle extends HttpServlet {
	
	private static final long serialVersionUID = -905856129798458976L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		String result = "";
		try {
		    request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    pw = response.getWriter();
		} catch (Exception e) {
			log.error("requestrequest、response",e);
		}
		try {
			CacheCount.set(RedisConstants.CHECK_USER_INITIALIZE_SINGLE,1L);
			//会员基本信息
			String userId = request.getParameter("sendUserId");
			result = UserTemplate.loadsUserInfoByUserId(Long.valueOf(userId));
			CacheCount.set(RedisConstants.CHECK_USER_INITIALIZE_SINGLE,0L);
			pw.println(result);
		} catch(Exception e) {
			CacheCount.set(RedisConstants.CHECK_USER_INITIALIZE_SINGLE,0L);
			log.error("执行会员（单个）初始化数据到redis发生异常。异常信息是：{}" , e);
			pw.println("执行会员（单个）初始化数据到redis发生异常。" + e.getMessage());
		}
	}

}
