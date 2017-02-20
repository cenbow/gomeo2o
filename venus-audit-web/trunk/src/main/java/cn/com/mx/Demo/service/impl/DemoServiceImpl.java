package cn.com.mx.Demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import cn.com.mx.Demo.service.DemoService;
import cn.com.mx.utils.factory.MongoClientFactory;
import cn.com.mx.utils.template.SimpleJedisTemplate;
import cn.com.mx.utils.template.SimpleJedisTemplate.RedisCallback;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisCommands;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {


	@Override
	public String findFromMongo() {
		final List<String> list = new ArrayList<String>();
		Document where = new Document();
		where.append("_id", "1449127636842228");
		FindIterable<Document> fi = MongoClientFactory.getMongoClient()
				.getDatabase("social").getCollection("socialGroup").find(where);
		fi.forEach(new Block<Document>() {
			@Override
			public void apply(Document doc) {
				list.add((String) doc.get("groupName"));				
			}						
		});		
		return list.toString();
	}

	@Override
	public String findFromRedis() {
		SimpleJedisTemplate sst = new SimpleJedisTemplate();
		return sst.execute(new RedisCallback<String>() {
			
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.get("test");
			}
		});
	}

	
	
	
	
}//end of class
