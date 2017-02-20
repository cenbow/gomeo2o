/**
 * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
 * 
 * @Description TODO
 * @author mojianli
 * @date 2016年1月12日 下午5:13:34
 */
package cn.com.mx.count.im;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mx.count.bean.ReturnBean;
import cn.com.mx.count.im.template.ImFansTemplate;
import cn.com.mx.count.sns.post.template.SnsLovelifePostNumTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description IM关注粉丝数计数请求Servlet
 * @author mojianli
 * @date 2016年1月12日 下午5:13:34
 */
@Slf4j
@WebServlet("/imFans/syncNumSingle")
public class ImFansSingleServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = -8475094872275573925L;

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
            CacheCount.set(RedisConstants.CHECK_IM_FANS_SINGLE, 1L);
            int seeFlag = Integer.parseInt(req.getParameter("seeFlag"));
            String userId = req.getParameter("sendUserId");
            long result = ImFansTemplate.syncImFansNumSingle(seeFlag, userId);
            CacheCount.set(RedisConstants.CHECK_IM_FANS_SINGLE, 0L);
            if (seeFlag == 0) {
                pw.println("执行结果完毕,用户：" + userId + "统计的粉丝数为" + result);
            } else {
                pw.println("查询结果完毕,用户：" + userId + "查询的粉丝数为" + result);
            }
        } catch (Exception e) {
            log.error("打印回执结果失败", e);
            CacheCount.set(RedisConstants.CHECK_IM_FANS_SINGLE, 0L);
            pw.println("执行错误" + e.getMessage() + "");
        }
    }
}
