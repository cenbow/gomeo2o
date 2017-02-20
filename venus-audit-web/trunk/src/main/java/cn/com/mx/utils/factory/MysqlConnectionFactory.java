package cn.com.mx.utils.factory;

import java.sql.Connection;

import com.alibaba.druid.pool.DruidDataSource;

import cn.com.mx.utils.ConfigUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description mysql连接工厂 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午1:51:15
 */

@Slf4j
public class MysqlConnectionFactory {
	
	private static DruidDataSource dataSource = null;

    static {
    	log.info("创建mysql数据源");
        try {
            dataSource = new DruidDataSource();
            dataSource.setDriverClassName(ConfigUtil.get("jdbcDriver"));
            dataSource.setUrl(ConfigUtil.get("jdbcUrl"));
            dataSource.setUsername(ConfigUtil.get("jdbcUsername"));
            dataSource.setPassword(ConfigUtil.get("jdbcPassword"));
            dataSource.setInitialSize(5);
            dataSource.setMinIdle(ConfigUtil.getInt("dbcpMaxIdle"));
            dataSource.setMaxActive(ConfigUtil.getInt("dbcpMaxActive"));
            dataSource.setPoolPreparedStatements(false);
        } catch (Exception e) {
            log.error("创建mysql数据源出错", e);
        }
    }

    /**
     * @Description 获取mysql连接 
     * @author wanggang-ds6
     * @date 2016年1月6日 下午1:53:10
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
           log.error("获取连接失败", e);
        }
        return conn;
    }
}
