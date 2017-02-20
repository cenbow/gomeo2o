package cn.com.mx.count.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.shop.template.ShopCollectTemplate;
import cn.com.mx.count.social.topic.Template.GroupTopicPersonNumTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;
/**
 * 
 * @Description 统计收藏的店铺数
 * @author yangjun-ds1
 * @date 2016年1月15日 上午10:43:28
 */
@Slf4j
@WebServlet("/shop")
@SuppressWarnings("all")
public class ShopCollectServlet extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//TODO 这里预留可以做一些参数的初始化
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
			try {
				CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT,1L);
				String result = ShopCollectTemplate.getResultForTemp();
				CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT,0L);
				pw.println(result);
			} catch (Exception e) {
				log.error("打印回执结果失败",e);
				CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT,0L);
				pw.println("执行错误"+e.getMessage()+"");
			}
		} catch (Exception e) {
			log.error("打印回执结果失败",e);
		}
	}
}