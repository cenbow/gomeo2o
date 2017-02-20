/**
 * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
 * 
 * @Description TODO
 * @author mojianli
 * @date 2015年12月3日 上午10:55:59
 */
package cn.com.gome.configuration.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import io.terminus.common.model.Paging;
import io.terminus.common.mysql.dao.MyBatisDao;
import io.terminus.ecp.config.dao.ConfigDao;
import io.terminus.ecp.config.model.Config;

/**
 * @Description 配置中心dao
 * @author mojianli
 * @date 2015年12月3日 上午10:55:59
 */
@Repository
public class GomeConfigDaoImpl extends MyBatisDao<Config> implements GomeConfigDao {

    public Paging<Config> pagingConfigs(Map<String,Object> criteria) {
        
        Long total = getSqlSession().selectOne(sqlId("countConfig"), criteria);
        if (total == 0L){
            return new Paging(Long.valueOf(0L), Collections.emptyList());
        }
        List<Config> data = getSqlSession().selectList(sqlId("pagingConfig"), criteria);
        return new Paging<Config>(total, data);
    }

}
