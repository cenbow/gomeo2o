/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description 账户用户国美币限额统计信息redis Dao
 * @author fengxin
 * @date 2015年11月16日 上午11:55:25
 */
package com.gomeo2o.service.account.dao.redis;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.JedisCommands;

import com.gomeo2o.common.redis.SimpleJedisTemplate;
import com.gomeo2o.common.redis.SimpleJedisTemplate.RedisCallback;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.utils.Constants;

/**
 * @Description 账户用户国美币限额统计信息redis Dao
 * @author fengxin
 * @date 2015年11月16日 上午11:55:25
 */
@Slf4j
@Repository("virtualTotalInfoDao")
public class VirtualTotalInfoDao {
	
	@Autowired
    private SimpleJedisTemplate simpleJedisTemplate;
	
	/**
	 * @Description 创建redis Key
	 * @author fengxin
	 * @date 2015年11月16日 下午2:45:29
	 * @param dealType
	 * @return key
	 */
	public String createAccountRedisKey(String dealType,String userId){
		if(Constants.PAY_LIMIT_TYPE.equals(dealType)){
			return "account:pay:limit:"+userId;
		}else if(Constants.ADVACNE_LIMIT_TYPE.equals(dealType)){
			return "account:advance:limit:"+userId;
		}else{
			throw AccountException.UN_KNOW_LIMIT_TYPE;
		}
	}
	/**
	 * @Description 修改用户单日或者当日交易额度信息
	 * @author fengxin
	 * @date 2015年11月17日 上午11:25:59
	 * @param dealType
	 * @param userId
	 * @param field
	 * @param value
	 */
	public void updateDayOrMonthTop(final String dealType,final String userId,final String field,final BigDecimal value){		
		simpleJedisTemplate.execute(new RedisCallback<String>() {
			String key = createAccountRedisKey(dealType, userId);
			@Override
			public String doInRedis(JedisCommands commands) {			
				commands.hincrBy(key, field, value.longValue());
				return "";
			}		
		});
	}
	/**
	 * @Description 获取指定用户指定交易类型昨天上限数据
	 * @author fengxin
	 * @date 2015年11月16日 下午4:35:42
	 * @param dealType
	 * @param userId
	 * @return 昨天交易数据汇总数据
	 */
	public BigDecimal queryUserDayTopLimit(final String dealType,final String userId){
		return simpleJedisTemplate.execute(new RedisCallback<BigDecimal>() {
			String key = createAccountRedisKey(dealType, userId);
			String field  = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			@Override
			public BigDecimal doInRedis(JedisCommands commands) {			
				if(!commands.hexists(key, field)){
					commands.hdel(key, getYesterday());
					commands.hset(key, field, "0");
				}
				return new BigDecimal(commands.hget(key, field));
			}		
		});
	}
	/**
	 * @Description 获取指定用户指定交易类型上月上限数据
	 * @author fengxin
	 * @date 2015年11月16日 下午4:36:12
	 * @param dealType
	 * @param userId
	 * @return 上月交易数据汇总信息
	 */
	public BigDecimal queryUserMonthTopLimit(final String dealType,final String userId){
		return simpleJedisTemplate.execute(new RedisCallback<BigDecimal>() {
			String key = createAccountRedisKey(dealType, userId);
			String field  = new SimpleDateFormat("yyyy-MM").format(new Date());
			@Override
			public BigDecimal doInRedis(JedisCommands commands) {			
				if(!commands.hexists(key, field)){
					commands.hdel(key, getLastMonth());
					commands.hset(key, field, "0");
				}
				return new BigDecimal(commands.hget(key, field));
			}		
		});
	}
	
	/**
	 * @Description 获取指定用户指定交易类型昨天上限交易次数
	 * @author fengxin
	 * @date 2015年11月16日 下午4:36:41
	 * @param dealType
	 * @param userId
	 * @return 交易次数
	 */
	public Integer queryUserDayNoLimit(final String dealType,final String userId){
		return simpleJedisTemplate.execute(new RedisCallback<Integer>() {
			String key = createAccountRedisKey(dealType, userId);
			String field  = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"dealNo";
			@Override
			public Integer doInRedis(JedisCommands commands) {			
				if(!commands.hexists(key, field)){
					commands.hdel(key, getYesterday()+"dealNo");
					commands.hset(key, field, "0");
				}
				return Integer.valueOf(commands.hget(key, field));
			}		
		});
	}
	/**
	 * @Description 修改用户当日交易次数
	 * @author fengxin
	 * @date 2015年11月16日 下午5:43:32
	 * @param dealType
	 * @param userId
	 */
	public void updateUserDayNoLimit(final String dealType,final String userId,final long value){
		simpleJedisTemplate.execute(new RedisCallback<String>() {
			String key = createAccountRedisKey(dealType, userId);
			String field  = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"dealNo";
			@Override
			public String doInRedis(JedisCommands commands) {			
				commands.hincrBy(key, field, value);
				return "";
			}		
		});
	}
	/**
	 * @Description 获取昨天日期
	 * @author fengxin
	 * @date 2015年11月16日 下午3:45:31
	 * @return
	 */
	public String getYesterday(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	/**
	 * @Description 获取上月日期
	 * @author fengxin
	 * @date 2015年11月16日 下午3:45:52
	 * @return
	 */
	public String getLastMonth(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return new SimpleDateFormat("yyyy-MM").format(cal.getTime());
	}
	

}
