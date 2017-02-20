package cn.com.mx.utils.factory;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import cn.com.mx.utils.ConfigUtil;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @Description redis工厂 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午5:50:56
 */
@Slf4j
public class RedisFactory {
	
	// 匹配集群地址格式
	private static Pattern pattern = Pattern.compile("^.+[:]\\d{1,5}\\s*$");
	
	// redis集群实例
	private static JedisCluster jedisCluster = null;
	
	// reids池
	private static JedisPool jedisPool = null;
	
	// 是否为集群
	private static boolean isCluster = ConfigUtil.getBoolean("isCluster");
	

	public static JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public static JedisPool getJedisPool() {
		return jedisPool;
	}
	
	public static boolean isCluster() {
		return isCluster;
	}

	static {
		log.info("构建redis实例");
		try {
			// 池配置
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setMaxTotal(ConfigUtil.getInt("redisMaxTotal"));
			poolConfig.setMaxIdle(ConfigUtil.getInt("redisMaxIdle"));
			poolConfig.setMaxWaitMillis(ConfigUtil.getLong("redisMaxWaitMillis"));
			poolConfig.setTestOnBorrow(ConfigUtil.getBoolean("redisTestOnBorrow"));
			
			int redisTimeout = ConfigUtil.getInt("redisTimeout");
			if (!isCluster) {
				poolConfig.setTestWhileIdle(true);
				poolConfig.setMinEvictableIdleTimeMillis(60000);
				poolConfig.setTimeBetweenEvictionRunsMillis(30000);
				poolConfig.setNumTestsPerEvictionRun(-1);
							
				String redisHost = ConfigUtil.get("redisHost");
				int redisPort = ConfigUtil.getInt("redisPort");				
				String redisPassword = ConfigUtil.get("redisPassword");
				jedisPool = new JedisPool(poolConfig, redisHost, redisPort, redisTimeout, redisPassword);
			} else {				
				int redisMaxRedirections = ConfigUtil.getInt("redisMaxRedirections");
				Set<HostAndPort> jedisClusterNodes = getClusterNodes(ConfigUtil.get("redisServers"));	
				jedisCluster = new JedisCluster(jedisClusterNodes, redisTimeout, redisMaxRedirections, poolConfig);
			}		
		} catch (Exception e) {
			log.error("构建redis实例失败", e);
		}	
	}
	
	/**
	 * @Description 获取集群节点列表 
	 * @author wanggang-ds6
	 * @date 2015年11月12日 上午10:42:22
	 * @return 集群节点列表 
	 */
	private static Set<HostAndPort> getClusterNodes(String redisServers) {
		if (redisServers == null || redisServers.length() == 0) {
			throw new IllegalArgumentException("redisServers不能为空！");
		}
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		String[] addressArray = redisServers.split(",");
		for (String address : addressArray) {
			boolean isIpPort = pattern.matcher(address).matches();
			if (!isIpPort) {
				throw new IllegalArgumentException("ip或 port不合法！");
			}
			String[] ipAndPort = address.split(":");
			HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
			jedisClusterNodes.add(hap);
		}	
		return jedisClusterNodes;
	}
	
}
