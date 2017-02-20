package cn.com.mx.count.shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.shop.template.ProductCollectCountTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

/**
 * @Description 商品收藏统计 
 * @author zhaochenyu
 * @date 2016年1月15日 上午11:27:28
 */
@Slf4j
@WebServlet("/proCollect")
public class ProductCollectCountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3186087649363198590L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			String type = request.getParameter("type");
			CacheCount.set(RedisConstants.CHECK_PRODUCT_COLLECT, 1L);
			String returnValue = ProductCollectCountTemplate.setOrGetPorductCollectToRedis(type, "0",null);
			CacheCount.set(RedisConstants.CHECK_PRODUCT_COLLECT, 0);
			pw.println(returnValue);
		} catch (Exception e) {
			CacheCount.set(RedisConstants.CHECK_PRODUCT_COLLECT, 0);
			log.error("打印回执结果失败",e);
		}
	}

	
}
