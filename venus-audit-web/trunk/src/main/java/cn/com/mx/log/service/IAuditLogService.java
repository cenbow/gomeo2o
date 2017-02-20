package cn.com.mx.log.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.com.mx.group.entity.GroupLog;
import cn.com.mx.topic.entity.TopicLog;
import cn.com.mx.topicBack.entity.TopicBackLog;
import cn.com.mx.twoTopicBack.entity.TwoTopicBackLog;


/**
 * @Description 群组审核日志
 * @author yuanchangjun
 * @date 2016年1月28日 上午10:13:58
 */
public interface IAuditLogService {
	
	/**
	 * @Description 查询群组审核日志
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:48:06
	 * @return
	 */
	List<GroupLog> findGroupLog(JSONObject jsonArray);
	
	/**
	 * @Description 查询群组审核日志数量 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:38:52
	 * @param jsonArray
	 * @return
	 */
	int findGroupLogCount(JSONObject jsonArray);
	
	/**
	 * @Description 查询话题审核日志
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午12:00:15
	 * @param jsonArray
	 * @return
	 */
	List<TopicLog> findTopicLog(JSONObject jsonArray);
	
	/**
	 * @Description 查询话题审核日志数量 
	 * @author yuanchangjun
	 * @date 2016年2月23日 上午11:59:58
	 * @param jsonArray
	 * @return
	 */
	int findTopicLogCount(JSONObject jsonArray);
	
	/**
	 * @Description 查询话题回复审核日志
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午12:00:15
	 * @param jsonArray
	 * @return
	 */
	List<TopicBackLog> findTopicBackLog(JSONObject jsonArray);
	
	/**
	 * @Description 查询话题回复审核日志数量 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午4:05:17
	 * @param jsonArray
	 * @return
	 */
	int findTopicBackLogCount(JSONObject jsonArray);
	
	/**
	 * @Description 查询二级回复审核日志 
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午1:50:38
	 * @param jsonArray
	 * @return
	 */
	List<TwoTopicBackLog> findTwoTopicBackLog(JSONObject jsonArray);
	
	/**
	 * @Description 查询二级回复审核日志数量  
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午1:50:41
	 * @param jsonArray
	 * @return
	 */
	int findTwoTopicBackLogCount(JSONObject jsonArray);
}
