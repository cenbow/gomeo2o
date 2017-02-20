package cn.com.mx.topicBack.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.com.mx.topicBack.dto.TopicBackDto;

/**
 * @Description 话题审核接口  
 * @author yuanchangjun
 * @date 2016年2月22日 下午4:59:30
 */
public interface ITopicBackService {
	
	/**
	 * @Description 审核话题回复
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午2:23:17
	 * @param jsonArray
	 * @return
	 */
	List<TopicBackDto> findTopicBack(JSONObject jsonArray);
	
	/**
	 * @Description 审核话题回复数量 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午2:23:06
	 * @param jsonArray
	 * @return
	 */
	int findTopicBackCount(JSONObject jsonArray);
	
	/**
	 * @Description 审核话题回复 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午2:22:52
	 * @param jsonArray
	 * @return
	 */
	boolean toExamine(JSONObject jsonArray);
	
}
