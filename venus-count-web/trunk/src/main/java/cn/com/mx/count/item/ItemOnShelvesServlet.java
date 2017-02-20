package cn.com.mx.count.item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.item.template.ItemOnShelvesTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

/**
 * Servlet implementation class ItemOnShelvesServlet
 */
@Slf4j
@WebServlet("/itemOnShelves")
@SuppressWarnings("all")
public class ItemOnShelvesServlet extends HttpServlet {

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
			CacheCount.set(RedisConstants.CHECK_ITEM_ONSHELVES,1L);
			String result = ItemOnShelvesTemplate.itemOnShelvesCount();
			CacheCount.set(RedisConstants.CHECK_ITEM_ONSHELVES,0L);
			pw.println(result);
		} catch (Exception e) {
			log.error("打印回执结果失败",e);
			CacheCount.set(RedisConstants.CHECK_ITEM_ONSHELVES,0L);
			pw.println("执行错误"+e.getMessage()+"");
		}
	}
}
