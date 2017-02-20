package com.gomeo2o.common.cache;

/**
 * @Description 缓存键工厂 
 * @author wanggang-ds6
 * @date 2015年12月18日 上午9:46:21
 */
public class CacheKeyFactory {
	
	/**
	 * 项目
	 */
	private String project;
	
	/**
	 * 业务
	 */
	private String business;

	/**
	 * @Description 根据项目构建工厂
	 * @param project 项目
	 */
	public CacheKeyFactory(String project) {
		this.project = project;
	}
	
	/**
	 * @Description 根据项目和业务构建工厂
	 * @param project 项目
	 * @param business 业务
	 */
	public CacheKeyFactory(String project, String business) {
		this.project = project;
		this.business = business;
	}
	
	/**
	 * @Description 获取 CacheKey对象
	 * @author wanggang-ds6
	 * @date 2015年12月18日 上午9:58:26
	 * @param id 
	 * @return CacheKey对象
	 */
	public CacheKey newCacheKey(String id) {
		return new CacheKey(this.project, this.business, id);
	}
	
	/**
	 * @Description 获取 CacheKey对象 
	 * @author wanggang-ds6
	 * @date 2015年12月18日 上午9:59:43
	 * @param id id
	 * @param cases 事件
	 * @return CacheKey对象
	 */
	public CacheKey newCacheKey(String id, String... cases) {
		return new CacheKey(this.project, this.business, id, cases);
	}
	
	/**
	 * @Description 获取 CacheKey对象  
	 * @author wanggang-ds6
	 * @date 2015年12月18日 上午10:09:00
	 * @param business 业务
	 * @param id id
	 * @return CacheKey对象
	 */
	public CacheKey newCacheKey(String business, String id) {
		return new CacheKey(this.project, business, id);
	}
	
	/**
	 * @Description 获取 CacheKey对象 
	 * @author wanggang-ds6
	 * @date 2015年12月18日 上午10:10:00
	 * @param business 业务
	 * @param id id
	 * @param cases 事件
	 * @return CacheKey对象
	 */
	public CacheKey newCacheKey(String business, String id, String... cases) {
		return new CacheKey(this.project, business, id, cases);
	}
	
}
