package cn.com.mx.count.item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.item.constant.ItemConstant;
import cn.com.mx.count.item.template.ItemTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

/**
 * @Description: 商品统计数全量 
 * @author: shanjie
 * @date: 2016年1月13日 下午2:34:51
 */
@Slf4j
@WebServlet("/itemSaleCount")
public class ItemCountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1601197688248943526L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
			CacheCount.set(RedisConstants.CHECK_ITEM_SALE_COUNT_ALL,1L);
			result = ItemTemplate.itemSaleCountHandler(0, ItemConstant.ItemSaleCountEnum.FULL.getType());
			CacheCount.set(RedisConstants.CHECK_ITEM_SALE_COUNT_ALL,0L);
			pw.println(result);
		} catch(Exception e) {
			CacheCount.set(RedisConstants.CHECK_ITEM_SALE_COUNT_ALL,0L);
			log.error("执行商品销量统计异常。" , e);
			pw.println("执行商品销量统计异常。" + e.getMessage());
		}
	}
	
}
