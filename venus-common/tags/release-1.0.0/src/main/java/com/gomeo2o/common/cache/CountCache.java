package com.gomeo2o.common.cache;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCommands;

import com.gomeo2o.common.redis.SimpleJedisTemplate;
import com.gomeo2o.common.redis.SimpleJedisTemplate.RedisCallback;

/**
 * @Description 计数缓存 
 * @author wanggang-ds6
 * @date 2015年12月17日 下午2:35:32
 */
public class CountCache {
	
	@Autowired
	private SimpleJedisTemplate simpleJedisTemplate;

	public void setSimpleJedisTemplate(SimpleJedisTemplate simpleJedisTemplate) {
		this.simpleJedisTemplate = simpleJedisTemplate;
	}

	/**
	 * @Description 计数键是否存在
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:29:40
	 * @param key 计数键
	 * @return true：存在，false：不存在
	 */
	public Boolean exists(CacheKey cacheKey) {
		final String key = cacheKey.getKey();;
		Boolean isExists = simpleJedisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(JedisCommands commands) {
				return commands.exists(key);
			}
		});
		return isExists;	
	}
	
	/**
	 * @Description 计数值增一 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:47:48
	 * @param key 计数键
	 * @return 计数值
	 */
	public long incr(CacheKey cacheKey) {
		final String key = cacheKey.getKey();;
		Long num = simpleJedisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.incr(key);
			}
		});
		return num;	
	}
	
	/**
	 * @Description 计数值加增量 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:51:10
	 * @param key 计数键
	 * @param increment 增量
	 * @return 计数值
	 */
	public long incrBy(CacheKey cacheKey, final long increment) {
		final String key = cacheKey.getKey();;
		Long num = simpleJedisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.incrBy(key, increment);
			}
		});
		return num;	
	}
	
	/**
	 * @Description 计数值减一 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:49:01
	 * @param key 计数键
	 * @return 计数值
	 */
	public long decr(CacheKey cacheKey) {
		final String key = cacheKey.getKey();;
		Long num = simpleJedisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.decr(key);
			}
		});
		return num;	
	}

	/**
	 * @Description 计数值减增量 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:52:35
	 * @param key 计数键
	 * @param increment 增量
	 * @return 计数值
	 */
	public long decrBy(CacheKey cacheKey, final long increment) {
		final String key = cacheKey.getKey();;
		Long num = simpleJedisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.decrBy(key, increment);
			}
		});
		return num;	
	}
	
	/**
	 * @Description 获取计数
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午3:42:27
	 * @param key 计数键
	 * @return 计数值
	 */
	public long get(CacheKey cacheKey) {
		final String key = cacheKey.getKey();;
		String num = simpleJedisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.get(key);
			}
		});
		return num == null ? 0: Long.parseLong(num);
	}
	
	/**
	 * @Description 获取计数 
	 * @author wanggang-ds6
	 * @date 2015年12月18日 下午12:52:30
	 * @param cacheKey 计数键
	 * @param defaultValue 计数值为空时，使用默认值
	 * @return 计数值
	 */
	public Long get(CacheKey cacheKey, Long defaultValue) {
		final String key = cacheKey.getKey();;
		String num = simpleJedisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.get(key);
			}
		});
		if (num == null) {
			return defaultValue;
		} 
		return Long.parseLong(num);
	}
	
	/**
	 * @Description 设置计数值 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:09:15
	 * @param key 计数键
	 * @param value 计数值
	 * @return 状态值
	 */
	public String set(CacheKey cacheKey, final long value) {
		final String key = cacheKey.getKey();;
		String statusCode = simpleJedisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.set(key, value + "");
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 设置计数 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:39:25
	 * @param key 计数键
	 * @param value 计数值
	 * @param isExists true:只有存在时才操作,false:只有不存在时才操作
	 * @param milliseconds 过期毫秒时间
	 * @return 状态值
	 */
	public String set(CacheKey cacheKey, final long value, final boolean isExists, final long milliseconds) {
		final String key = cacheKey.getKey();;
		String statusCode = simpleJedisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.set(key, value + "", 
						isExists ? "XX" : "NX" , 
						"PX", 
						milliseconds);
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 设置计数过期 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:25:10
	 * @param key 计数键
	 * @param milliseconds 毫秒
	 * @return 状态值
	 */
	public Long pexpire(CacheKey cacheKey, final long milliseconds) {
		final String key = cacheKey.getKey();;
		Long statusCode = simpleJedisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.pexpire(key, milliseconds);
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 删除计数 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:54:44
	 * @param key 计数键
	 * @return 状态值
	 */
	public Long del(CacheKey cacheKey) {
		final String key = cacheKey.getKey();;
		Long statusCode = simpleJedisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.del(key);
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 重置计数为0 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午4:57:36
	 * @param key 计数键
	 * @return 状态值
	 */
	public String reset(CacheKey cacheKey) {
		return set(cacheKey, 0);
	}
	
}
