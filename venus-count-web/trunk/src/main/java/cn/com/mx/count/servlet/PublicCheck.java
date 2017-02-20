package cn.com.mx.count.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 检查程序是否正在执行... 
 * @author yuanchangjun
 * @date 2016年1月13日 下午3:39:24
 */
@Slf4j
@WebServlet("/check")
@SuppressWarnings("all")
public class PublicCheck extends HttpServlet{
	
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
		int flag = Integer.parseInt(request.getParameter("check"));
		JSONObject json = new JSONObject();
		//默认值不允许动,默认不允许执行
		json.put("flag", 1);
		//社交-群组下人数
		if(flag==100){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SOCIAL_GROUP_ALL));
		}else if(flag==0){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SOCIAL_PERSON));
		}else if(flag==1){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SOCIAL_TOPIC));
		}else if(flag==2){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SOCIAL_TOPIC_BACK));
		}else if(flag==3){
			json.put("flag",CacheCount.get(RedisConstants.CHECK_PRODUCT_COLLECT));
		}else if(flag==4){
			json.put("flag",CacheCount.get(RedisConstants.CHECK_PRODUCT_COLLECT_SINGLE));
		}else if(flag==11){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_ITEM_SALE_COUNT_ALL));
		}else if(flag==12){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_ITEM_SALE_COUNT));
		}else if (flag==21) {
			json.put("flag", CacheCount.get(RedisConstants.CHECK_ITEM_ONSHELVES));
		}else if(flag==300){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SNS_POST_ALL));
		}else if(flag==301){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SNS_POST_COMMENT));
		}else if(flag==302){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SNS_POST_ISLIKE));
		}else if(flag==401){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SHOP_COLLECT));
		}else if(flag==402){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SHOP_COLLECT_SINGLE));
		}else if(flag==500){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SHOP_COLLECT));
		}else if(flag==501){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_SHOP_COLLECT_SINGLE));
		}else if(flag==600){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_USER_INFO_SINGLE));
		}else if(flag==601){
			json.put("flag", CacheCount.get(RedisConstants.CHECK_USER_INFO_ALL));
		}
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(json);
		} catch (Exception e) {
			log.error("打印回执结果失败",e);
		}
	}
}