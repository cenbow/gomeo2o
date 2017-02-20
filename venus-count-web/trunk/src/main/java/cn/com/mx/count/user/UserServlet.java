package cn.com.mx.count.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.user.template.UserTemplate;
import cn.com.mx.count.utils.RedisConstants;

/**
 * @Description 批量初始化会员信息到redis
 * @author jiale
 * @date 2016年3月3日 下午2:44:27
 */
@Slf4j
@WebServlet("/user/initinfo")
public class UserServlet extends HttpServlet {
       
	private static final long serialVersionUID = 2063235461180660516L;

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
			CacheCount.set(RedisConstants.CHECK_USER_INITIALIZE_ALL,1L);
			//会员基本信息
			result = UserTemplate.loadsAllUsersInfo();
			CacheCount.set(RedisConstants.CHECK_USER_INITIALIZE_ALL,0L);
			pw.println(result);
		} catch(Exception e) {
			CacheCount.set(RedisConstants.CHECK_USER_INITIALIZE_ALL,0L);
			log.error("执行会员全量初始化数据到redis发生异常。异常信息是：{}" , e);
			pw.println("执行会员全量初始化数据到redis发生异常。" + e.getMessage());
		}
	}

}
