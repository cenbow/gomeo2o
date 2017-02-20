package cn.com.mx.count.social.topic.Template;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.bson.Document;

import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.template.MongoDbTemplate;
import cn.com.mx.count.utils.ConfigUtil;
import cn.com.mx.count.utils.RedisConstants;

import com.mongodb.BasicDBObject;

/**
 * @Description  群组人数,群组下话题数,群组下话题回复数 模版 
 * @author yuanchangjun
 * @date 2016年1月12日 下午12:37:03
 */
@Slf4j
@SuppressWarnings("all")
public class GroupTopicPersonNumTemplate {

	
	private static String mongodbName = ConfigUtil.get("mongodbName");
	
	
	public static String GroupTopicPersonAllNumTemplate(){
		String result="";
		List<String> list = MongoDbTemplate.getResultForMongo("_id", new Document().append("state", 0).append("auditState", 2), mongodbName, "socialGroup");
		if(list!=null&&list.size()>0){
			result+="总群数:"+list.size()+"";
			for (String groupId : list) {
				try {
					//统计群下面的人
					CacheCount.set(RedisConstants.groupPerson(groupId),MongoDbTemplate.getResultCount(new Document().append("groupId", String.valueOf(groupId)).append("isTrue", new BasicDBObject().append("$lt", 3)), mongodbName, "socialGroupPersons"));
				} catch (Exception e) {
					log.error("统计某个群下面的人",e);
				}
				//统计群下面的话题
				try {
					CacheCount.set(RedisConstants.groupTopic(groupId),MongoDbTemplate.getResultCount(new Document().append("groupId", String.valueOf(groupId)).append("states", 0).append("auditState", 2), mongodbName, "socialTopic"));
				} catch (Exception e) {
					log.error("统计群下面的话题",e);
				}
			}
		}else{
			log.error("获取所有群组失败,为能拿到所有的socialGroup数据 {}",list);
		}
		
		//统计群下面的话题回复
		List<Object> listTopic = MongoDbTemplate.getResultForMongo("_id", new Document().append("states", 0).append("auditState", 2), "social", "socialTopic");
		if(listTopic!=null&&listTopic.size()>0){
			result+="总话题数:"+listTopic.size()+"";
			for (Object topicId : listTopic) {
				try {
					CacheCount.set(RedisConstants.groupTopicBack(String.valueOf(topicId)),MongoDbTemplate.getResultCount(new Document().append("topicId", String.valueOf(topicId)).append("states", 0).append("auditState", 2), mongodbName, "socialTopicPerson"));
				} catch (Exception e) {
					log.error("统计某个话题下面的全部回复",e);
				}
			}
		}else{
			log.error("统计群组下面每个话题的话题回复数失败,为能拿到所有的话题数据 {}",list);
		}
		return result+"执行完毕";
	} 
	
	/**
	 * @Description 统计群组下面的人 (单个)
	 * @author yuanchangjun
	 * @date 2016年1月13日 上午10:49:21
	 * @param 参数控制设置单条还是设置单个
	 * @param see
	 * @return
	 */
	public static long GroupPersonSingleNumTemplate(String sendGroupId,int see){
		if(sendGroupId!=null&&see==0){
			try {
				CacheCount.set(RedisConstants.groupPerson(sendGroupId),MongoDbTemplate.getResultCount(new Document().append("groupId", sendGroupId).append("isTrue", new BasicDBObject().append("$lt", 3)), mongodbName, "socialGroupPersons"));
			} catch (Exception e) {
				log.error("统计某个群下面的人",e);
			}
		}
		return CacheCount.get(RedisConstants.groupPerson(sendGroupId));
	}
	
	/**
	 * @Description 统计群下面的话题(单个) 
	 * @author yuanchangjun
	 * @date 2016年1月13日 上午10:54:55
	 * @param sendGroupId
	 * @param see
	 * @return
	 */
	public static long GroupTopicSingleNumTemplate(String sendGroupId,int see){
		if(sendGroupId!=null&&see==0){
			try {
				CacheCount.set(RedisConstants.groupTopic(sendGroupId),MongoDbTemplate.getResultCount(new Document().append("groupId", sendGroupId).append("states", 0).append("auditState", 2), mongodbName, "socialTopic"));
			} catch (Exception e) {
				log.error("统计群下面的话题",e);
			}
		}
		return CacheCount.get(RedisConstants.groupTopic(sendGroupId));
	}
	
	/**
	 * @Description 统计群下面的话题(单个) 
	 * @author yuanchangjun
	 * @date 2016年1月13日 上午10:57:43
	 * @param sendTopicId
	 * @param see
	 * @return
	 */
	public static long GroupTopicBackSingleNumTemplate(String sendTopicId,int see){
		if(sendTopicId!=null&&see==0){
			try {
				CacheCount.set(RedisConstants.groupTopicBack(sendTopicId),MongoDbTemplate.getResultCount(new Document().append("topicId", sendTopicId).append("states", 0).append("auditState", 2), mongodbName, "socialTopicPerson"));
			} catch (Exception e) {
				log.error("统计群下面的话题",e);
			}
		}
		return CacheCount.get(RedisConstants.groupTopicBack(sendTopicId));
	}
}