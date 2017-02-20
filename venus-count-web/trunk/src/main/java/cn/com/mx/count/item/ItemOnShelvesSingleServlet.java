package cn.com.mx.count.item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.item.template.ItemOnShelvesTemplate;
import cn.com.mx.count.social.topic.Template.GroupTopicPersonNumTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

/**
 * Servlet implementation class ItemOnShelvesSingle
 */
@Slf4j
@SuppressWarnings("all")
@WebServlet("/itemOnShelvesSingle")
public class ItemOnShelvesSingleServlet extends HttpServlet {

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
		Integer type;
		String shopid = request.getParameter("sendShopId");
		try {
			if (StringUtils.isEmpty((String)request.getParameter("type"))) {
				type = 0;
			} else {
				type = Integer.parseInt(request.getParameter("type"));
			}
			CacheCount.set(RedisConstants.CHECK_ITEM_ONSHELVES,1L);
			String result = ItemOnShelvesTemplate.itemSingleCount(shopid, type);
			CacheCount.set(RedisConstants.CHECK_ITEM_ONSHELVES,0L);
			pw.println(result);
		} catch (Exception e) {
			log.error("count fail shopid:{}", shopid, e);
			CacheCount.set(RedisConstants.CHECK_ITEM_ONSHELVES,0L);
			pw.println("执行错误"+e.getMessage()+"");
		}
	}
}
