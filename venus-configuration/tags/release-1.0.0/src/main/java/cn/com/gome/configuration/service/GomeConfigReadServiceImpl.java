/**
 * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
 * 
 * @Description TODO
 * @author mojianli
 * @date 2015年12月2日 下午4:29:19
 */
package cn.com.gome.configuration.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import cn.com.gome.configuration.dao.GomeConfigDao;
import io.terminus.common.model.PageInfo;
import io.terminus.common.model.Paging;
import io.terminus.ecp.common.util.Params;
import io.terminus.ecp.config.model.Config;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 配置中心写服务接口实现
 * @author mojianli
 * @date 2015年12月2日 下午4:29:19O
 */
@Service
@Slf4j
@Configuration
public class GomeConfigReadServiceImpl implements GomeConfigReadService {

    @Autowired
    private GomeConfigDao gomeConfigDao;

    /**
     * @Description 分页查询配置
     * @author mojianli
     * @date 2015年12月3日 下午4:08:03
     * @param criteria
     * @return
     */
    @Override
    public Response<Paging<Config>> pagingConfigs(Integer pageNo, Integer pageSize, Map<String, Object> criteria) {
        Response<Paging<Config>> resp = new Response<Paging<Config>>();
        try {
            PageInfo page = new PageInfo(pageNo, pageSize);
            if (criteria == null) {
                criteria = Maps.newHashMap();
            }
            criteria.put("offset", page.getOffset());
            criteria.put("limit", page.getLimit());
            Map<String, Object> nonNullAndEmpty = prepareCriteria(criteria);
            resp.setResult(gomeConfigDao.pagingConfigs(nonNullAndEmpty));
        } catch (Exception e) {
            log.error("failed to find Config as pageNo={}, pageSize={}, criteria={}, cause: {}", pageNo, pageSize,
                    criteria, e);
            resp.setError("Config.find.fail");
        }
        return resp;
    }

    /**
     * @Description 组装查询条件
     * @author mojianli
     * @date 2015年12月3日 下午4:08:03
     * @param criteria
     * @return
     */
    private Map<String, Object> prepareCriteria(Map<String, Object> criteria) {
        if (criteria.get("configKey") != null) {
            String configKey = String.valueOf(criteria.get("configKey"));
            if (!Strings.isNullOrEmpty(configKey)) {
                criteria.put("configKey", configKey);
            }
        }
        if (criteria.get("configValue") != null) {
            String configValue = String.valueOf(criteria.get("configValue"));
            if (!Strings.isNullOrEmpty(configValue)) {
                criteria.put("configValue", configValue);
            }
        }
        if (criteria.get("configDescription") != null) {
            String configDescription = String.valueOf(criteria.get("configDescription"));
            if (!Strings.isNullOrEmpty(configDescription)) {
                criteria.put("configDescription", configDescription);
            }
        }

        return Params.filterNullOrEmpty(criteria);
    }



}
