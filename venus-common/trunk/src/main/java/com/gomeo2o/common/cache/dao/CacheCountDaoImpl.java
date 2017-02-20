package com.gomeo2o.common.cache.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.gomeo2o.common.cache.CacheKey;
import com.gomeo2o.common.cache.CountCache;

/**
 * @Description 缓存计数Dao实现 
 * @author wanggang-ds6
 * @date 2015年12月23日 下午2:31:45
 */
public class CacheCountDaoImpl implements CacheCountDao {
	
	@Autowired
	private CountCache countCache;

	@Override
	public Boolean exists(String project, String business, String id,
			String... cases) {
		return countCache.exists(new CacheKey(project, business, id, cases));
	}

	@Override
	public long incr(String project, String business, String id,
			String... cases) {
		return countCache.incr(new CacheKey(project, business, id, cases));
	}

	@Override
	public long incrBy(long increment, String project, String business,
			String id, String... cases) {
		return countCache.incrBy(new CacheKey(project, business, id, cases), increment);
	}

	@Override
	public long decr(String project, String business, String id,
			String... cases) {
		return countCache.decr(new CacheKey(project, business, id, cases));
	}

	@Override
	public long decrBy(long increment, String project, String business,
			String id, String... cases) {
		return countCache.decrBy(new CacheKey(project, business, id, cases), increment);
	}

	@Override
	public long get(String project, String business, String id, String... cases) {
		return countCache.get(new CacheKey(project, business, id, cases));
	}

	@Override
	public Long get(Long defaultValue, String project, String business,
			String id, String... cases) {
		return countCache.get(new CacheKey(project, business, id, cases), defaultValue);
	}

	@Override
	public String set(long value, String project, String business, String id,
			String... cases) {
		return countCache.set(new CacheKey(project, business, id, cases), value);
	}

	@Override
	public String set(long value, boolean isExists, long milliseconds,
			String project, String business, String id, String... cases) {
		return countCache.set(new CacheKey(project, business, id, cases), value, isExists, milliseconds);
	}

	@Override
	public Long pexpire(long milliseconds, String project, String business,
			String id, String... cases) {
		return countCache.pexpire(new CacheKey(project, business, id, cases), milliseconds);
	}

	@Override
	public Long del(String project, String business, String id, String... cases) {
		return countCache.del(new CacheKey(project, business, id, cases));
	}

	@Override
	public String reset(String project, String business, String id,
			String... cases) {
		return countCache.reset(new CacheKey(project, business, id, cases));
	}

}
