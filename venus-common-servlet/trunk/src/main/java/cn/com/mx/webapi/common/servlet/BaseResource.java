package cn.com.mx.webapi.common.servlet;

import cn.com.mx.webapi.common.constant.PublicParamsConstant;
import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;
import cn.com.mx.webapi.common.exceptions.code.C405Exception;
import cn.com.mx.webapi.common.exceptions.code.C422Exception;
import cn.com.mx.webapi.common.model.ResponseModel;
import cn.com.mx.webapi.common.service.CheckService;
import cn.com.mx.webapi.common.service.RequestProcessor;
import cn.com.mx.webapi.common.service.ResponseProcessor;
import cn.com.mx.webapi.common.utils.ParametersPrinter;
import cn.com.mx.webapi.common.utils.ResourceParameters;
import cn.com.mx.webapi.common.utils.ValidateProLoadService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanggang-ds6
 * @Description 控制层基类
 * @date 2016年1月22日 上午11:06:38
 */
@Slf4j
public abstract class BaseResource extends HttpServlet {

    @Autowired
    private CheckService checkService;

    @Autowired
    ValidateProLoadService validateProLoadService;

    @Autowired
    private RequestProcessor requestProcessor;

    @Autowired
    private ResponseProcessor responseProcessor;

    //wyp 2016-03-31 validate param
//    @Autowired
//    protected ConfigCenter configCenter;
//    protected static final String KEY_PATH = "validpath.";
//    protected static final String KEY_REGULAR = "validreg.";
    protected static final String OPTIONAL = "^\\[\\w+\\]$";
    protected static final String MIDBRACKETS = "\\[|\\]";

    /**
     * @author wanggang-ds6
     * @Description 方法枚举
     * @date 2016年1月22日 上午11:06:54
     */
    public enum MethodEnum {
        get, post, put, delete;
    }

    private static final long serialVersionUID = -4555021483800227968L;

    /**
     * @param config
     * @throws ServletException
     * @Description 初始化
     * @author wanggang-ds6
     * @date 2016年1月22日 上午11:06:08
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 用于支持自动注入
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = ctx.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp, MethodEnum.get);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp, MethodEnum.delete);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp, MethodEnum.post);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp, MethodEnum.put);
    }

    /**
     * @param req        请求
     * @param resp       响应
     * @param methodEnum 方法
     * @throws IOException
     * @Description 处理
     * @author wanggang-ds6
     * @date 2016年1月22日 上午11:03:59
     */
    private void process(HttpServletRequest req, HttpServletResponse resp, MethodEnum methodEnum) throws IOException {
        // 校验数据
        requestProcessor.beforeProcess(req, methodEnum);
        // 解析请求
        ResourceParameters servletParam = requestProcessor.getParameter(req);
        //wyp 2016-04-01 modify
//        JSONObject jsonBody = requestProcessor.getRequestJsonBody(req);
        String jsonStr = servletParam.getString(PublicParamsConstant.REQUEST_BODY);
        //todo may by add json schema validate should be here!
        JSONObject jsonBody = JSONObject.parseObject(jsonStr);


//        String path = req.getServletPath(); ///venus-account-servlet

        String uri = req.getRequestURI();
//        String[] tmp = uri.split("/");
        String[] uris = parseUrl(uri);
        String module = uris[0];
        String resource = uris[1];
        String method = req.getMethod();//get post put delete
        //wyp 2016-03-31 添加入参校验，待完善，先取消验证
        validateServletParam(servletParam, module, resource, method);
        validateJsonStr(jsonStr, module, resource, method);

        // 记录参数
        ParametersPrinter.setRequestBody(jsonBody);
        ParametersPrinter.setRequestParam(servletParam);
        try {
            Map<String, Object> rtnMap = new HashMap<String, Object>();
            if (methodEnum == MethodEnum.get) {
                checkService.checkLogin(servletParam, this, "get", ResourceParameters.class);
                rtnMap = get(servletParam);
            } else if (methodEnum == MethodEnum.post) {
                checkService.checkLogin(servletParam, this, "post", ResourceParameters.class, JSONObject.class);
                rtnMap = post(servletParam, jsonBody);
            } else if (methodEnum == MethodEnum.put) {
                checkService.checkLogin(servletParam, this, "put", ResourceParameters.class, JSONObject.class);
                rtnMap = put(servletParam, jsonBody);
            } else if (methodEnum == MethodEnum.delete) {
                checkService.checkLogin(servletParam, this, "delete", ResourceParameters.class);
                rtnMap = delete(servletParam);
            }
            ResponseModel responseModel = new ResponseModel(rtnMap);
            // 处理应答
            responseProcessor.process(req, resp, responseModel);
        } finally {
            // 处理解析参数
            requestProcessor.afterProcess(jsonBody, servletParam);
        }
    }

    protected void validateJsonStr(String jsonStr, String module, String resource, String method) {
        log.info("validateJsonStr param is {}, {}, {}, {}",  module, module, resource, method, jsonStr);
    }

    private void validateServletParam(ResourceParameters servletParam, String module, String resource, String method) {
        log.info("validateServletParam param is {}, {}, {}, {}", servletParam, module, module, resource, method);
        String resKey = resource + "." + method;
        String keytmp = null;
        try {
            keytmp = validateProLoadService.getValue(module, resKey, "");
        } catch (IllegalStateException e) {
            log.error("{} path is not valid!", resKey, e);
            return;
        }
        String[] keys = StringUtils.isEmpty(keytmp) ? null : keytmp.split(",");
        if(null == keys)
            return;
        String value = null;
        String regular = null;
        boolean isOption = false;//是否可选
        for (String key : keys) {
            isOption = key.matches(OPTIONAL);
            if (isOption) {
                key = key.replaceAll(MIDBRACKETS, "");
                regular = validateProLoadService.getValue(module, resource + "." + key, "");
                value = servletParam.getString(key);
                if (StringUtils.isEmpty(value)) {
                    continue;
                } else {
                    if (!value.matches(regular)) {
                        throw new C422Exception(new BaseExceptionMessage("%s value is %s!", key, value));
                    }
                }

            } else {
                regular = validateProLoadService.getValue(module, resource+"."+key, "");
                value = servletParam.getString(key);
                if (StringUtils.isEmpty(value) || !value.matches(regular)) {
                    throw new C422Exception(new BaseExceptionMessage("%s value is [%s]!", key, value));
                }
            }
        }
    }

    /**
     * 解析URI获取模块名、资源名
     * @param requestURI
     * @return [0]moduleName, [1]resourceName
     */
    private String[] parseUrl(String requestURI) {
        String[] tmp = requestURI.split("/");
        log.info("requestURI is {}", tmp);
        if(null == tmp || tmp.length < 3) {
            throw new C422Exception(new BaseExceptionMessage("request uri error [{}]!", requestURI));
        } else {
            return new String[] {tmp[tmp.length-2], tmp[tmp.length-1]};
        }
    }
/*
    protected void validateJsonBody(JSONObject jsonBody, String path) {
        log.info("validateJsonBody param is {}, {}", jsonBody, path);

    }


    private void validateJsonStr(String jsonStr) {
        //JsonNode jsonSchema = JsonLoader.fromResource("/json/custom-fmt.json");
    }

    protected void validateServletParam(ResourceParameters servletParam, String path) {
        log.info("validateServletParam param is {}, {}", servletParam, path);
        String pathtmp = path.substring(1);
        String keytmp = null;
        try {
            keytmp = configCenter.get(KEY_PATH + pathtmp);
        } catch (IllegalStateException e) {
            log.error("{} path is not valid!",pathtmp, e);
            return;
        }
        String[] keys = StringUtils.isEmpty(keytmp) ? new String[]{""} : keytmp.split(",");
        String value = null;
        String regular = null;
        boolean isOption = false;//是否可选
        for (String key : keys) {
            isOption = key.matches(OPTIONAL);
            regular = configCenter.get(KEY_REGULAR + key);
            if (isOption) {
                value = servletParam.getString(key);
                if (StringUtils.isEmpty(value)) {
                    continue;
                } else {
                    if (!value.matches(regular)) {
                        throw new C422Exception(new BaseExceptionMessage("%s value is %s!", key, value));
                    }
                }

            } else {
                value = servletParam.getString(key);
                if (StringUtils.isEmpty(value) || !value.matches(regular)) {
                    throw new C422Exception(new BaseExceptionMessage("%s value is [%s]!", key, value));
                }
            }
        }
    }
*/

    public Map<String, Object> get(ResourceParameters resourceParameters) {
        throw new C405Exception();
    }

    public Map<String, Object> post(ResourceParameters resourceParameters, JSONObject body) {
        throw new C405Exception();
    }

    public Map<String, Object> put(ResourceParameters resourceParameters, JSONObject body) {
        throw new C405Exception();
    }

    public Map<String, Object> delete(ResourceParameters resourceParameters) {
        throw new C405Exception();
    }


}
