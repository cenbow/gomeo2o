package cn.com.mx.badword.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mx.badword.CJFBeanFactory;
import cn.com.mx.badword.ChineseJF;
import cn.com.mx.badword.Sensitive.SensitiveWord;
import cn.com.mx.badword.utils.SpecialCharacters;

/**
 * @Description badWord 
 * @author zhangyihang
 * @date 2016年2月17日 16:44:47
 */
/**
 * Servlet implementation class BadWordServlet
 */
@WebServlet("/BadWordServlet")
public class BadWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置界面的乱码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String sensitive = request.getParameter("sensitive");
		// 获得繁体-简体转换器
		ChineseJF chinesdJF = CJFBeanFactory.getChineseJF();
		String janText = chinesdJF.chineseFan2Jan(sensitive);
		String sens = SpecialCharacters.StringFilter(sensitive);
		Iterator<String> it = SensitiveWord.initMap().getSensitiveWord(sens + janText, 1).iterator();
		while (it.hasNext()) {
			String str = it.next();
			sensitive = sensitive.replaceAll(str, "<font color='red'>"+str+"</font>");
		}
		response.getWriter().print(sensitive);
	}

}
