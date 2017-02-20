package cn.com.mx.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import cn.com.mx.utils.factory.MongoClientFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

public class MongoDbUtil {
	
	private static String mongodbName = ConfigUtil.get("mongodbName");
	/**
	 * 
	 * @Description 获取公共的mongdb 
	 * @author yuanchangjun
	 * @date 2016-01-28 10:20:26
	 * @param where 条件
	 * @param collection 集合名
	 * @return 
	 */
	public static FindIterable<Document> getResultForMongo(String collection,final Document where,JSONObject jsonArray,int order,String field) {
		if(order!=0){
			//降序或升序
			return MongoClientFactory.getMongoClient().getDatabase(mongodbName).getCollection(collection).find(where).skip(jsonArray.getInt("iDisplayStart")).limit(jsonArray.getInt("iDisplayLength")).sort(new BasicDBObject(field,1));
		}else{
			return MongoClientFactory.getMongoClient().getDatabase(mongodbName).getCollection(collection).find(where).skip(jsonArray.getInt("iDisplayStart")).limit(jsonArray.getInt("iDisplayLength"));
		}
	}
	
	
	/**
	 * @Description 获取某个表内的字段 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午5:37:45
	 * @param collection
	 * @param where
	 * @param field
	 * @return
	 */
	public static List<Object> getResultObject(String collection,final Document where,final String field) {
		final List<Object> list = new ArrayList<Object>();
		MongoClientFactory.getMongoClient().getDatabase(mongodbName).getCollection(collection).find(where).forEach(new Block<Document>() {
			@Override
			public void apply(Document doc) {
			   list.add(doc.get(field));
			}	
		});
		return list;
	}
	
	/**
	 * @Description 获取总条数 
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:30:56
	 * @param collection
	 * @param where
	 * @return
	 */
	public static int getResultCount(String collection,final Document where) {
		return new Long(MongoClientFactory.getMongoClient().getDatabase(mongodbName).getCollection(collection).count(where)).intValue();
	}
}
