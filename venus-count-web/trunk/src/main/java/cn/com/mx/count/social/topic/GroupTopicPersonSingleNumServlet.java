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
 * @Description 单条处理 
 * @author yuanchangjun
 * @date 2016年1月13日 上午10:44:41
 */
@Slf4j
@WebServlet("/topicSingle")
@SuppressWarnings("all")
public class GroupTopicPersonSingleNumServlet extends HttpServlet{

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
		long result =0l;
		int type = Integer.parseInt(request.getParameter("type"));
		int see = Integer.parseInt(request.getParameter("see"));
		try {
		    String sendGroupId = request.getParameter("sendGroupId");
		    if(type==0){
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_PERSON,1L);
		    	result=GroupTopicPersonNumTemplate.GroupPersonSingleNumTemplate(sendGroupId,see);
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_PERSON,0L);
		    }else if(type==1){
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_TOPIC,1L);
		    	result=GroupTopicPersonNumTemplate.GroupTopicSingleNumTemplate(sendGroupId,see);
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_TOPIC,0L);
		    }else if(type==2){
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_TOPIC_BACK,1L);
		    	result=GroupTopicPersonNumTemplate.GroupTopicBackSingleNumTemplate(sendGroupId,see);
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_TOPIC_BACK,0L);
		    }
			if(see==0){
				pw.println("执行结果完毕,"+sendGroupId+"参数共统计了"+result+"结果");
			}else{
				pw.println("查询结果完毕,"+sendGroupId+"参数共查询出"+result+"结果");
			}
		} catch (Exception e) {
			log.error("打印回执结果失败",e);
			if(type==0){
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_PERSON,0L);
		    }else if(type==1){
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_TOPIC,0L);
		    }else if(type==2){
		    	CacheCount.set(RedisConstants.CHECK_SOCIAL_TOPIC_BACK,0L);
		    }
			pw.println("执行错误"+e.getMessage()+"");
		}
	}
}