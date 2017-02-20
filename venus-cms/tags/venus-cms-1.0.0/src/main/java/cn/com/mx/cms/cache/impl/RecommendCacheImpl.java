package cn.com.mx.cms.cache.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCommands;
import cn.com.mx.cms.cache.IRecommendCache;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.utils.JsonUtil;
import cn.com.mx.cms.utils.KeyUtil;

import com.gomeo2o.common.redis.SimpleJedisTemplate;
import com.gomeo2o.common.redis.SimpleJedisTemplate.RedisCallback;
import com.google.common.collect.Maps;

/**
 * 
 * Description: 推荐位缓存实现
 * 
 * @author duwei
 * @date 2015年11月28日 下午4:20:08
 * @version V1.0
 */
@Slf4j
@Service
public class RecommendCacheImpl implements IRecommendCache {

	@Autowired
	private SimpleJedisTemplate simpleJedisTemplate;

	/**
	 * @Description 写推荐位缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午2:59:29
	 * @param 推荐位类型
	 * @param dto
	 *            推荐位dto
	 */
	@Override
	public void writeRecommendDto(final String recommendType, final List<RecommendDto> dtos) {
		if (dtos == null || recommendType == null) {
			return;
		}
		try {
			simpleJedisTemplate.execute(new RedisCallback<Long>() {
				public Long doInRedis(JedisCommands commands) {
					return commands.hset(KeyUtil.RECOMMEND_KEY, recommendType, JsonUtil.toJson(dtos));
				}
			});
		} catch (Exception e) {
			log.error("设置推荐位缓存异常!", e);
		}

	}

	/**
	 * 
	 * @Description 读推荐位缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午2:59:48
	 * @return
	 */
	@Override
	public Map<String, List<RecommendDto>> getRecommendDto() {
		try {
			return simpleJedisTemplate.execute(new RedisCallback<Map<String, List<RecommendDto>>>() {
				public Map<String, List<RecommendDto>> doInRedis(JedisCommands commands) {
					Map<String, String> allRec = commands.hgetAll(KeyUtil.RECOMMEND_KEY);
					if (allRec == null || allRec.isEmpty()) {
						return null;
					}
					return converts(allRec, RecommendDto.class);
				}
			});
		} catch (Exception e) {
			log.error("获取推荐位缓存异常!", e);
		}
		return null;
	}
	
	@Override
	public void deleteRecommendDto(final String recommendType) {
		try {
			simpleJedisTemplate.execute(new RedisCallback<Long>() {
				public Long doInRedis(JedisCommands commands) {
					return commands.hdel(KeyUtil.RECOMMEND_KEY, recommendType);
				}
			});
		} catch (Exception e) {
			log.error("删除具体推荐位缓存异常!", e);
		}

	}
	
	@Override
	public void deleteRecommendDto() {
		try {
			simpleJedisTemplate.execute(new RedisCallback<Long>() {
				public Long doInRedis(JedisCommands commands) {
					return commands.del(KeyUtil.RECOMMEND_KEY);
				}
			});
		} catch (Exception e) {
			log.error("删除所有推荐位缓存异常!", e);
		}

	}

	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<String, List<RecommendDto>> converts(Map<String, String> allRec, Class cls) {
		Map<String, List<RecommendDto>> ret = Maps.newConcurrentMap();
		for (Iterator<String> iterator = allRec.keySet().iterator(); iterator.hasNext();) {
			String next = iterator.next();
			String s = allRec.get(next);
			List<RecommendDto> list = JsonUtil.toObjArray(s, cls);
			ret.put(next, list);
		}
		return ret;
	}

	/**
	 * 
	 * @Description 读推荐位缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午2:59:48
	 * @return
	 */
	@Override
	public List<RecommendDto> getRecommendDto(final String recommendType) {
		try {
			return simpleJedisTemplate.execute(new RedisCallback<List<RecommendDto>>() {
				public List<RecommendDto> doInRedis(JedisCommands commands) {
					String allRec = commands.hget(KeyUtil.RECOMMEND_KEY, recommendType);
					return JsonUtil.toObjArray(allRec, RecommendDto.class);
				}
			});
		} catch (Exception e) {
			log.error("获取推荐位缓存异常!", e);
		}
		return null;
	}

}
