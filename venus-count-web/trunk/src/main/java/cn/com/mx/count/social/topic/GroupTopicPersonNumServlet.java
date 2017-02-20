package cn.com.mx.count.social.topic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.social.topic.Template.GroupTopicPersonNumTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;
/**
 * 
 * @Description 群组人数,群组下话题数,群组下话题回复数 
 * @author yuanchangjun
 * @date 2016年1月12日 上午10:43:28
 */
@Slf4j
@WebServlet("/topic")
@SuppressWarnings("all")
public class GroupTopicPersonNumServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5428929766386311284L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		PrintWriter pw = null;
		try {
		    request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    pw = response.getWriter();
		} catch (Exception e) {
			log.error("requestrequest、response",e);
		}
		try {
			CacheCount.set(RedisConstants.CHECK_SOCIAL_GROUP_ALL,1L);
			String result = GroupTopicPersonNumTemplate.GroupTopicPersonAllNumTemplate();
			CacheCount.set(RedisConstants.CHECK_SOCIAL_GROUP_ALL,0L);
			pw.println(result);
		} catch (Exception e) {
			log.error("打印回执结果失败",e);
			CacheCount.set(RedisConstants.CHECK_SOCIAL_GROUP_ALL,0L);
			pw.println("执行错误"+e.getMessage()+"");
		}
	}
}