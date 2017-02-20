/**
 * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
 * 
 * @Description TODO
 * @author mojianli
 * @date 2016年1月11日 下午5:05:25
 */
package cn.com.mx.count.im;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mx.count.im.template.ImFriendTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description IM关注好友数计数请求Servlet
 * @author mojianli
 * @date 2016年1月11日 下午5:05:25
 */
@Slf4j
@WebServlet("/imFriend/syncNum")
public class ImFriendServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 7490620236875751198L;

    /**
     * 
     * @Description 请求doGet方法
     * @author mojianli
     * @date 2016年1月11日 下午5:07:30
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = null;
        try {
            req.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            pw = resp.getWriter();
        } catch (Exception e) {
            log.error("request、response", e);
        }

        try {
            CacheCount.set(RedisConstants.CHECK_IM_FRIEND_ALL, 1L);
            String result = ImFriendTemplate.syncImFriendNum();
            CacheCount.set(RedisConstants.CHECK_IM_FRIEND_ALL, 0L);
            pw.println(result);
        } catch (Exception e) {
            log.error("打印回执结果失败", e);
            CacheCount.set(RedisConstants.CHECK_IM_FRIEND_ALL, 0L);
            pw.println("执行错误" + e.getMessage() + "");
        }
    }
}
