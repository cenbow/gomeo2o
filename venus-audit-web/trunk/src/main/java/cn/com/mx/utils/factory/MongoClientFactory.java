package cn.com.mx.utils.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

import cn.com.mx.utils.ConfigUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description mongoClient工厂 
 * @author wanggang-ds6
 * @date 2016年1月7日 上午11:29:18
 */
@Slf4j
public class MongoClientFactory {
	
	// 匹配集群地址格式
	private static Pattern pattern = Pattern.compile("^.+[:]\\d{1,5}\\s*$");
	
	// mongoClient实例
	private static MongoClient mongoClient = null;
	
	public static MongoClient getMongoClient() {
		return mongoClient;
	}

	static {
		log.info("创建mongoClient实例");
		try {
			List<ServerAddress> addresses = getClusterNodes(ConfigUtil.get("mongodbReplica"));		
			MongoClientOptions options = new MongoClientOptions.Builder()
					.socketKeepAlive(true) // 是否保持长链接
					.connectTimeout(5000) // 链接超时时间
					.socketTimeout(5000) // read数据超时时间
					.readPreference(ReadPreference.primary()) // 最近优先策略
					.connectionsPerHost(30) // 每个地址最大请求数
					.maxWaitTime(1000 * 60 * 2) // 长链接的最大等待时间
					.threadsAllowedToBlockForConnectionMultiplier(50) // 一个socket最大的等待请求数
					.writeConcern(WriteConcern.NORMAL).build();
			mongoClient = new MongoClient(addresses, options);
		} catch (Exception e) {
			log.error("创建mongoClient实例失败", e);
		}		
	}	
	
	/**
	 * @Description 获取集群节点列表 
	 * @author wanggang-ds6
	 * @date 2015年11月12日 上午10:42:22
	 * @return 集群节点列表 
	 */
	private static List<ServerAddress> getClusterNodes(String mongoServers) {
		if (mongoServers == null || mongoServers.length() == 0) {
			throw new IllegalArgumentException("mongodbServers不能为空！");
		}
		List<ServerAddress> addresses = new ArrayList<ServerAddress>();
		String[] addressArray = mongoServers.split(",");
		for (String address : addressArray) {
			boolean isIpPort = pattern.matcher(address).matches();
			if (!isIpPort) {
				throw new IllegalArgumentException("ip或 port不合法！");
			}
			String[] ipAndPort = address.split(":");
			ServerAddress sa = new ServerAddress(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
			addresses.add(sa);
		}	
		return addresses;
	}
	
}
