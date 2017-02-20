///**
// * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
// * 
// * @Description TODO
// * @author mojianli
// * @date 2015年12月4日 下午3:28:15
// */
//package cn.com.gome.configuration.dao;
//
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//
//import java.util.Map;
//import java.util.Random;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.google.common.collect.Maps;
//
//import cn.com.gome.configuration.BaseDaoTest;
//import io.terminus.ecp.config.model.Config;
//
///**
// * @Description TODO
// * @author mojianli
// * @date 2015年12月4日 下午3:28:15
// */
//public class GomeConfigDaoTest extends BaseDaoTest {
//
//    @Autowired
//    private GomeConfigDaoImpl gomeConfigDao;
//    Config config = new Config();
//    private String testkey;
//
//    @Before
//    public void mock() {
//        Random random = new Random();
//        testkey = "abc" + random.nextLong();
//        config.setKey(testkey);
//        config.setValue("value");
//        assertTrue(gomeConfigDao.create(config));
//    }
//
//    @Test
//    public void testCreate() {
//
//    }
//
//    @Test
//    public void testPagingConfigs() {
//
//        Map<String, Object> criteria = Maps.newHashMap();
//        criteria.put("offset", 1);
//        criteria.put("limit", 10);
//        assertThat(gomeConfigDao.pagingConfigs(criteria), notNullValue());
//    }
//
//    // @Test
//    // public void testListAll() {
//    // assertThat(configDao.listAll(), notNullValue());
//    // }
//    //
//    // @Test
//    // public void testSearchByKey(){
//    // assertTrue(configDao.searchByKey("mail").size() > 1);
//    // assertThat(configDao.searchByKey(testkey).get(0).getValue(), is("value"));
//    // assertThat(configDao.searchByKey(testkey).get(0).getCreatedAt(), notNullValue());
//    // assertThat(configDao.searchByKey(testkey).get(0).getUpdatedAt(), notNullValue());
//    // }
//    //
//    // @Test
//    // public void testUpdate(){
//    // config.setScope("zoo");
//    // assertThat(config.getScope(), is("zoo"));
//    // configDao.update(config);
//    // assertThat(configDao.findByKey(testkey).getScope(), is("zoo"));
//    // }
//
//}
