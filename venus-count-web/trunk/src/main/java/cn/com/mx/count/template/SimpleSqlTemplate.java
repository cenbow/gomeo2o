package cn.com.mx.count.template;

import java.sql.Connection;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.factory.MysqlConnectionFactory;

/**
 * @Description sql模板 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午5:25:09
 */
@Slf4j
public class SimpleSqlTemplate {

	/**
	 * @Description 执行查询 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午5:45:04
	 * @param action 回调
	 * @return 结果
	 */
	public <T> T execute(SqlCallback<T> action) {
		Connection connection = null;
		try {
			connection = MysqlConnectionFactory.getConnection();
			return action.done(connection);
		} catch (Exception e) {
			throw e;
		} finally {
			if (connection != null) {
                try {
                	connection.close();
                } catch (Exception e) {
                	log.error("关闭Connection出错", e);
                }
            }
		}		
	}
	
	/**
	 * @Description 回调代码 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午5:30:51
	 * @param <T>
	 */
	public static abstract interface SqlCallback<T> {
		T done(Connection connection);
	}
}
