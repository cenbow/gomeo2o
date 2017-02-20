package cn.com.mx.webapi.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by neowyp on 2016/4/5.
 */
@Component
@Slf4j
public class ValidateProLoadService {
    private final static Map<String, Properties> proMap = new HashMap<String, Properties>();
    private final static String PATH_PREFIX = "validate/regexp/";
    private final static String PATH_SUFFIX = ".properties";

    /**
     * 载入配置文件
     *
     * @param module
     */
    private void loadProperties(String module) {
        if (proMap.containsKey(module)) {
            return;
        } else {
            InputStream fis = null;
            try {
                Properties prop = new Properties();// 属性集合对象
//                String path = "/" + PATH_PREFIX + module + PATH_SUFFIX;
                String path = PATH_PREFIX + module + PATH_SUFFIX;
                log.info("resource stream path is :{}!", path);
                fis = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);// 属性文件输入流，默认service
                prop.load(fis);// 将属性文件流装载到Properties对象中
                proMap.put(module, prop);
            } catch (Exception e) {
                log.error("load properties [{}] error!", module, e);
            } finally {
                try {
                    fis.close();// 关闭流
                } catch (Exception e) {
                    log.error("finally close file!", e);
                }

            }

        }
    }

    /**
     * 获取key value
     *
     * @param module
     * @param key
     * @param defultValue
     * @return
     */
    public String getValue(String module, String key, String defultValue) {
        log.info("get key value [{}, {}, {}]", module, key, defultValue);
        loadProperties(module);
        Properties prop = proMap.get(module);
        if (null == prop) {
            log.info("not has this module [{}].", module);
            return defultValue;
        } else {
            log.info("module [{}] key [{}] value [{}].", module, key, prop.getProperty(key, defultValue));
            return prop.getProperty(key, defultValue);
        }
    }

    public static void main(String[] args) {
        try {
            InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("validate/regexp/social.properties");
            fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("/app.properties");
            URL url = Thread.currentThread().getContextClassLoader().getResource("app.properties");
            log.info("");
            ValidateProLoadService proLoadService = new ValidateProLoadService();
            proLoadService.getValue("social", "group.GET", "");
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
