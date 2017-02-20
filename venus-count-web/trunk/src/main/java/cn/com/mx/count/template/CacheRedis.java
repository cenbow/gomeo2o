package cn.com.mx.count.template;
import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.JedisCommands;
import cn.com.mx.count.template.SimpleJedisTemplate.RedisCallback;
import cn.com.mx.count.user.constant.UserRedisConstants;
import cn.com.mx.count.user.vo.UserInfoVo;


public class CacheRedis implements Serializable{
	
	private static final long serialVersionUID = -5007038872650868329L;
	
	public static void createUserInfo(final long userId,final UserInfoVo userInfoVo){
    	final String key = UserRedisConstants.getUserBasicInfoKey(String.valueOf(userId));
    	new SimpleJedisTemplate().execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				String json = userInfoVo == null ? "" : JSON.toJSONString(userInfoVo);
				commands.set(key, json);
				return "";
			}
        });
    }

}
