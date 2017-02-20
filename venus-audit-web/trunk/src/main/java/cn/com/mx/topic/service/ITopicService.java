package cn.com.mx.topic.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.com.mx.topic.dto.TopicDto;

/**
 * @Description 话题审核接口  
 * @author yuanchangjun
 * @date 2016年2月22日 下午4:59:30
 */
public interface ITopicService {
	
	/**
	 * @Description 未审,审核,审核未通过 话题 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午4:59:05
	 * @param jsonArray
	 * @return
	 */
	List<TopicDto> findTopic(JSONObject jsonArray);
	
	/**
	 * @Description 未审,审核,审核未通过 话题  数量 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午4:59:18
	 * @param jsonArray
	 * @return
	 */
	int findTopicCount(JSONObject jsonArray);
	
	/**
	 * @Description 审核通过和审核不通过 
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:51:36
	 * @param jsonArray
	 * @return
	 */
	boolean toExamine(JSONObject jsonArray);
	
}
