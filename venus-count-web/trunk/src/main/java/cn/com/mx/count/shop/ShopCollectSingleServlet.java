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
@WebServlet("/shopSingle")
@SuppressWarnings("all")
public class ShopCollectSingleServlet extends HttpServlet{
	
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
			long result =0l;
			int see = Integer.parseInt(request.getParameter("seeFlag"));
			try {
			    String shopId = request.getParameter("shopId");		    
				if(see == 0){
					CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT_SINGLE,1L);
					result = ShopCollectTemplate.getResultByParam(see,shopId);
					CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT_SINGLE,0L);
					pw.println("执行结果完毕,店铺"+shopId+"共被收藏了"+result+"次");
				}else{
					CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT_SINGLE,1L);
					result = ShopCollectTemplate.getResultByParam(see,shopId);
					CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT_SINGLE,0L);
					pw.println("查询完毕,店铺"+shopId+"已被收藏的次数"+result+"次");
				}
			} catch (Exception e) {
				log.error("打印回执结果失败",e);
				CacheCount.set(RedisConstants.CHECK_SHOP_COLLECT_SINGLE,0L);
				pw.println("执行错误"+e.getMessage()+"");
			}
		} catch (Exception e) {
			log.error("打印回执结果失败",e);
		}
	}
}