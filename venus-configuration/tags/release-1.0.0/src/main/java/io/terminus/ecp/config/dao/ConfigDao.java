/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.dao;

import io.terminus.common.model.Paging;
import io.terminus.common.mysql.dao.MyBatisDao;
import io.terminus.ecp.config.model.Config;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 2:03 PM  <br>
 * Author: xiao
 */
@Repository
public class ConfigDao extends MyBatisDao<Config> {


    /**
     * 以配置项名查找配置
     * @param key 键
     * @return 配置项
     */
    public Config findByKey(String key){
        return getSqlSession().selectOne(sqlId("findByKey"),  key);
    }

    public Paging<Config> pagingConfigs(Integer offset, Integer limit){
        Long total = (Long)this.getSqlSession().selectOne(this.sqlId("count"));
        if(total<1L){
            return new Paging(Long.valueOf(0L), Collections.emptyList());
        } else {
            Map criteria=new HashMap();
            criteria.put("offset", offset);
            criteria.put("limit", limit);
            List datas = this.getSqlSession().selectList(this.sqlId("paging"), criteria);
            return new Paging(total, datas);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Config find(long id){
        return getSqlSession().selectOne(sqlId("find"), id);
    }
    /**
     * 根据配置名进行Like查询
     * @param key 配置名
     * @return 配置项
     */
    public List<Config> searchByKey(String key){
        //BAD CODE
        return getSqlSession().selectList(sqlId("searchByKey"), "%" + key + "%");
    }


}
