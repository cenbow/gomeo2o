package cn.com.mx.utils.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.Block;

import cn.com.mx.utils.factory.MongoClientFactory;

/**
 * @Description mongdodb公共查询 
 * @author yuanchangjun
 * @date 2016年1月12日 下午12:31:12
 */
public class MongoDbTemplate {
	/**
	 * 
	 * @Description 获取公共的mongdb 
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:08:05
	 * @param property 属性
	 * @param where 条件
	 * @param dataBase 数据池
	 * @param collection 集合名
	 * @return list == null ? list
	 */
	@SuppressWarnings("rawtypes")
	public static List getResultForMongo(final String property,final Document where,final String dataBase,String collection) {
		final List<Object> list = new ArrayList<Object>();
		MongoClientFactory.getMongoClient().getDatabase(dataBase).getCollection(collection).find(where).forEach(new Block<Document>() {
			@Override
			public void apply(Document doc) {
				list.add(doc.get(property));				
			}						
		});
		return list;
	}
	
	/**
	 * @Description 根据参数获取mongdb中某一个集合的数量 
	 * @author yuanchangjun
	 * @date 2016年1月12日 上午11:37:49
	 * @param where 条件
	 * @param dataBase 数据池
	 * @param collection 集合名
	 * @return 数量
	 */
	public static long getResultCount(final Document where,final String dataBase,String collection) {
		return MongoClientFactory.getMongoClient().getDatabase(dataBase).getCollection(collection).count(where);
	}
	
	/**
	 * @Description 获取mongodb固定字段的值
	 * @author kl_chaizhilei
	 * @date 2016年1月21日 下午3:40:47
	 * @param properties 属性字段
	 * @param where 过滤条件
	 * @param dataBase 数据库名称
	 * @param collection  链接名称
	 * @return
	 */
	public static List<Map<String, Object>> getResultForMongo(final List<String> properties,final Document where,final String dataBase,String collection) {
		final List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		MongoClientFactory.getMongoClient().getDatabase(dataBase).getCollection(collection).find(where).forEach(new Block<Document>() {
			@Override
			public void apply(Document doc) {
				Map<String,Object> map = new HashMap<String, Object>();
				for (String property : properties) {
					map.put(property, doc.get(property));
				}
				list.add(map);
			}						
		});
		return list;
	}

}
