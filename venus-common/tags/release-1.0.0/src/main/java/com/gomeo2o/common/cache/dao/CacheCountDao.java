package com.gomeo2o.common.cache.dao;

/**
 * @Description 缓存计数Dao 
 * @author wanggang-ds6
 * @date 2015年12月23日 下午2:15:39
 */
public interface CacheCountDao {	
	
	/**
	 * @Description 计数键是否存在 
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:22:24
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return true：存在，false：不存在
	 */
	public Boolean exists(String project, String business, String id, String... cases);
	
	/**
	 * @Description 计数值增一  
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:22:59
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 计数值
	 */
	public long incr(String project, String business, String id, String... cases);
	
	/**
	 * @Description 计数值加增量 
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:23:22
	 * @param increment 增量
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 计数值
	 */
	public long incrBy(long increment, String project, String business, String id, String... cases);
	
	/**
	 * @Description 计数值减一  
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:23:51
	 * @param increment 增量
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 计数值
	 */
	public long decr(String project, String business, String id, String... cases);
	
	/**
	 * @Description 计数值减增量 
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:24:10
	 * @param increment 增量
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 计数值
	 */
	public long decrBy(long increment, String project, String business, String id, String... cases);
		
	/**
	 * @Description 获取计数 
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:24:38
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 计数值
	 */
	public long get(String project, String business, String id, String... cases);
	
	/**
	 * @Description 获取计数 
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:24:56
	 * @param defaultValue 计数值为空时，使用默认值
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 计数值
	 */
	public Long get(Long defaultValue, String project, String business, String id, String... cases);
	
	/**
	 * @Description 设置计数值  
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:25:17
	 * @param value 计数值
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 状态值
	 */
	public String set(long value, String project, String business, String id, String... cases);
	
	/**
	 * @Description 设置计数  
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:26:01
	 * @param value 计数值
	 * @param isExists true:只有存在时才操作,false:只有不存在时才操作
	 * @param milliseconds 过期毫秒时间
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 状态值
	 */
	public String set(long value, boolean isExists, long milliseconds, String project, String business, String id, String... cases);
	
	/**
	 * @Description 设置计数过期  
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:26:23
	 * @param milliseconds 毫秒
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 状态值
	 */
	public Long pexpire(long milliseconds, String project, String business, String id, String... cases);
	
	/**
	 * @Description 删除计数  
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:27:06
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 状态值
	 */
	public Long del(String project, String business, String id, String... cases);
	
	/**
	 * @Description 重置计数为0  
	 * @author wanggang-ds6
	 * @date 2015年12月23日 下午2:27:28
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 * @return 状态值
	 */
	public String reset(String project, String business, String id, String... cases);
	
}
