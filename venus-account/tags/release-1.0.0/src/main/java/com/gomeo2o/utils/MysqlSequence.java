/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: wangyunpeng
 * @date: 2015年4月8日上午9:27:56
 */
package com.gomeo2o.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 使用mysql单表构建序列 <br>
CREATE TABLE `account_sequnce` ( <br>
  `name` varchar(32) NOT NULL, <br>
  `value` bigint(32) NOT NULL DEFAULT '0', <br>
  PRIMARY KEY (`name`) <br>
) ENGINE=InnoDB DEFAULT CHARSET=utf8; <br>
 * @author: wangyunpeng
 * @modifier: gongjiaming
 * @date: 2015年4月20日
 */
public class MysqlSequence {
	private static final Logger log = LoggerFactory.getLogger(MysqlSequence.class);
	private long blockSize;
	private long startValue;
	private long currentValue;
	private long endValue;
	private String seqName;
	private DataSource dataSource;

	public MysqlSequence(DataSource dataSource, String seqName) {
		//定义一次队列取多少序列
		this.blockSize = 20;
		this.startValue = 0L;
		this.currentValue = 0L;
		this.endValue = 0L;
		this.seqName = seqName;
		this.dataSource = dataSource;
	}

	/**
	* @Description:　获取下一个步长 
	* @author: wangyunpeng
	* @date: 2015年4月8日下午2:56:35
	*/
	private void getNextBlock() {
		Long value = getPersistenceValue();
		if (value == null) {
			try {
				value = newPersistenceValue();
			} catch (Exception e) {
				log.error("newPersistenceValue error!");
				value = getPersistenceValue();
			}
		}
		boolean b = saveValue(value.longValue()) == 1;
		if (b) {
			this.startValue = value.longValue();
			this.currentValue = value.longValue();
			this.endValue = value.longValue() + this.blockSize;
			log.info(startValue + "-" + currentValue + "-" + endValue);
		}

	}

	/**
	* @Description:　获取当前序列值
	* @author: wangyunpeng
	* @date: 2015年4月8日下午2:56:49
	* @return
	*/
	private Long getPersistenceValue() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = this.dataSource.getConnection();
			statement = connection.prepareStatement("select value from account_sequnce where name = ?");
			statement.setString(1, this.seqName);
			resultSet = statement.executeQuery();
			if (resultSet.next())
				return Long.valueOf(resultSet.getLong("value"));
		} catch (Exception e) {
			log.error("getPersistenceValue error!", e);
			throw new RuntimeException("getPersistenceValue error!", e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					log.error("close resultset error!", e);
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					log.error("close statement error!", e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("close connection error!", e);
				}
			}
		}
		return null;
	}

	/**
	* @Description:　更新数据库 
	* @author: wangyunpeng
	* @date: 2015年4月8日下午2:57:11
	* @param value
	* @return
	*/
	private int saveValue(long value) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.dataSource.getConnection();
			statement = connection.prepareStatement("update account_sequnce set value = ?  where name = ? and value = ?");
			statement.setLong(1, value + this.blockSize);
			statement.setString(2, this.seqName);
			statement.setLong(3, value);
			return statement.executeUpdate();
		} catch (Exception e) {
			log.error("newPersistenceValue error!", e);
			throw new RuntimeException("newPersistenceValue error!", e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					log.error("close statement error!", e);
				}
			}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("close connection error!", e);
				}
		}
	}

	/**
	* @Description:　初始化记录
	* @author: wangyunpeng
	* @date: 2015年4月8日下午3:01:21
	* @return
	*/
	private Long newPersistenceValue() {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.dataSource.getConnection();
			statement = connection.prepareStatement("insert into account_sequnce (value,name) values (?,?)");
			statement.setLong(1, this.startValue);
			statement.setString(2, this.seqName);
			statement.executeUpdate();
		} catch (Exception e) {
			log.error("newPersistenceValue error!", e);
			throw new RuntimeException("newPersistenceValue error!", e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					log.error("close statement error!", e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("close connection error!", e);
				}
			}
		}
		return Long.valueOf(this.startValue);
	}

	/**
	* @Description:　获取序列 
	* @author: wangyunpeng
	* @date: 2015年4月8日下午3:03:32
	* @return
	*/
	public synchronized long get() {
		if (this.startValue == 0)
			getNextBlock();
		if (this.currentValue == this.endValue)
			getNextBlock();
		return ++this.currentValue;
	}
}
