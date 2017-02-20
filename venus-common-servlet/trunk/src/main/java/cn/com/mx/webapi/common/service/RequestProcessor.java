package cn.com.mx.webapi.common.service;

import cn.com.mx.webapi.common.constant.PublicParamsConstant;
import cn.com.mx.webapi.common.exceptions.code.C400Exception;
import cn.com.mx.webapi.common.exceptions.code.C415Exception;
import cn.com.mx.webapi.common.servlet.BaseResource;
import cn.com.mx.webapi.common.servlet.BaseResource.MethodEnum;
import cn.com.mx.webapi.common.utils.ParametersPrinter;
import cn.com.mx.webapi.common.utils.ResourceParameters;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author wanggang-ds6
 * @Description 请求处理
 * @date 2016年1月27日 上午11:41:59
 */
@Component
public class RequestProcessor {

    /**
     * @param req
     * @Description 请求前处理
     * @author wanggang-ds6
     * @date 2016年1月29日 上午11:29:06
     */
    public void beforeProcess(HttpServletRequest req, MethodEnum methodEnum) {

        // get和delete没有ContentType
        if (methodEnum == BaseResource.MethodEnum.get
                || methodEnum == BaseResource.MethodEnum.delete) {
            return;
        }

        // 如果请求实体
        String contentType = req.getContentType();
        if (contentType.indexOf(PublicParamsConstant.CONTENT_TYPE_JSON) < 0
                && contentType.indexOf(PublicParamsConstant.CONTENT_TYPE_FORM) < 0
                && contentType.indexOf(PublicParamsConstant.CONTENT_TYPE_MULTIPART) < 0) {
            throw new C415Exception();
        }
    }

    /**
     * @param req 请求
     * @return body
     * @Description 获取请求中的body中的json数据
     * @author wanggang-ds6
     * @date 2016年1月22日 上午10:45:29
     */
    public JSONObject getRequestJsonBody(HttpServletRequest req) {
        try {

            // 如果请求实体
            String contentType = req.getContentType();
            if (contentType != null && contentType.indexOf(PublicParamsConstant.CONTENT_TYPE_JSON) < 0) {
                return null;
            }

            BufferedReader reader = req.getReader();
            String input = null;
            StringBuffer requstBody = new StringBuffer("");
            while ((input = reader.readLine()) != null) {
                requstBody.append(input);
            }
            //todo add json schema validate here!
            if (requstBody.length() > 0) {
                return JSONObject.parseObject(requstBody.toString());
            }
            return null;
        } catch (Exception e) {
            throw new C400Exception(e);
        }
    }

    private String getRequestJsonStr(HttpServletRequest req) {
        try {
            // 如果请求实体
            String contentType = req.getContentType();
            if (contentType != null && contentType.indexOf(PublicParamsConstant.CONTENT_TYPE_JSON) < 0) {
                return null;
            }

            BufferedReader reader = req.getReader();
            String input = null;
            StringBuffer requstBody = new StringBuffer("");
            while ((input = reader.readLine()) != null) {
                requstBody.append(input);
            }
            return requstBody.toString();
        } catch (Exception e) {
            throw new C400Exception(e);
        }
    }

    /**
     * @param req 请求
     * @return 参数map
     * @Description 获取参数
     * @author wanggang-ds6
     * @date 2016年1月22日 上午11:47:12
     */
    public ResourceParameters getParameter(HttpServletRequest req) {
        try {
            ResourceParameters servletParam = ResourceParameters.newInstance();
            // 获取parameterMap
            Iterator<Entry<String, String[]>> iterator = req.getParameterMap().entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String[]> entry = iterator.next();
                if (entry.getValue().length > 1) {
                    servletParam.put(entry.getKey(), Arrays.asList(entry.getValue()));
                } else {
                    servletParam.put(entry.getKey(), entry.getValue()[0]);
                }
            }
            // 获取attributeName
            Enumeration<String> enumeration = req.getAttributeNames();
            while (enumeration.hasMoreElements()) {
                String attributeName = enumeration.nextElement();
                servletParam.put(attributeName, req.getAttribute(attributeName));
            }
            // 为特殊需求需要，增加request本身
            servletParam.put(PublicParamsConstant.REQUEST_ENTITY, req);
            servletParam.put(PublicParamsConstant.REQUEST_BODY, getRequestJsonStr(req));
            return servletParam;
        } catch (Exception e) {
            throw new C400Exception(e);
        }
    }

    /**
     * @param body
     * @param parameters
     * @Description 请求完处理逻辑
     * @author wanggang-ds6
     * @date 2016年1月27日 上午11:51:14
     */
    public void afterProcess(JSONObject body, ResourceParameters parameters) {
        // 删除request本身
        parameters.remove(PublicParamsConstant.REQUEST_ENTITY);

        // 记录参数
        ParametersPrinter.setRequestBody(body);
        ParametersPrinter.setRequestParam(parameters);
    }
}
