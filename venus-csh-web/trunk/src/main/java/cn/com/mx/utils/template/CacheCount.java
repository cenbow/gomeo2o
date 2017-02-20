package cn.com.mx.utils.template;

import java.io.Serializable;

import cn.com.mx.utils.template.SimpleJedisTemplate.RedisCallback;
import redis.clients.jedis.JedisCommands;

/**
 * @Description 公共设置redis 
 * @author yuanchangjun
 * @date 2016年1月12日 下午12:17:10
 */
public class CacheCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9076061442119318866L;

	/**
	 * @Description 计数键是否存在 
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:18:40
	 * @param key
	 * @return
	 */
	public static Boolean exists(final String key) {
		Boolean isExists = new SimpleJedisTemplate().execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(JedisCommands commands) {
				return commands.exists(key);
			}
		});
		return isExists;	
	}
	
	/**
	 * @Description 计数值增1
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:18:21
	 * @param key
	 * @return
	 */
	public static long incr(final String key) {
	   Long num = new SimpleJedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.incr(key);
			}
		});
		return num;	
	}
	
	/**
	 * @Description 计数值加增量  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:18:10
	 * @param key
	 * @param increment
	 * @return
	 */
	public static long incrBy(final String key, final long increment) {
		Long num = new SimpleJedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.incrBy(key, increment);
			}
		});
		return num;	
	}
	
	/**
	 * @Description 计数值减一  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:18:00
	 * @param key
	 * @return
	 */
	public static long decr(final String key) {
		Long num = new SimpleJedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.decr(key);
			}
		});
		return num;	
	}
	
	/**
	 * @Description 计数值减增量  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:17:50
	 * @param key
	 * @param increment
	 * @return
	 */
	public static long decrBy(final String key, final long increment) {
		Long num = new SimpleJedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.decrBy(key, increment);
			}
		});
		return num;	
	}
	
	/**
	 * @Description 获取计数 
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:17:42
	 * @param key
	 * @return
	 */
	public static long get(final String key) {
		String num = new SimpleJedisTemplate().execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.get(key);
			}
		});
		return num == null ? 0: Long.parseLong(num);
	}
	
	/**
	 * @Description 获取计数  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:17:33
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static Long get(final String key, Long defaultValue) {
		String num = new SimpleJedisTemplate().execute(new RedisCallback<String>() {
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
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:17:23
	 * @param key
	 * @param value
	 * @return
	 */
	public static String set(final String key, final long value) {
		String statusCode = new SimpleJedisTemplate().execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.set(key, value + "");
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 设置计数  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:17:06
	 * @param key
	 * @param value
	 * @param isExists
	 * @param milliseconds
	 * @return
	 */
	public static String set(final String key, final long value, final boolean isExists, final long milliseconds) {
		String statusCode = new SimpleJedisTemplate().execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.set(key, value + "", isExists ? "XX" : "NX" , "PX", milliseconds);
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 设置计数过期  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:16:56
	 * @param key
	 * @param milliseconds
	 * @return
	 */
	public static Long pexpire(final String key, final long milliseconds) {
		Long statusCode = new SimpleJedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.pexpire(key, milliseconds);
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 删除计数  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:16:48
	 * @param key
	 * @return
	 */
	public static Long del(final String key) {
		Long statusCode = new SimpleJedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(JedisCommands commands) {
				return commands.del(key);
			}
		});
		return statusCode;
	}
	
	/**
	 * @Description 重置计数为0  
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:16:39
	 * @param key
	 * @return
	 */
	public static String reset(final String key) {
		return set(key, 0);
	}
}
