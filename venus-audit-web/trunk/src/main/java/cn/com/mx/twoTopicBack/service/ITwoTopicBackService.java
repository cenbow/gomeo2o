package cn.com.mx.twoTopicBack.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.com.mx.twoTopicBack.dto.TwoTopicBackDto;

/**
 * @Description 二级回复审核 
 * @author yuanchangjun
 * @date 2016年3月1日 下午12:26:15
 */
public interface ITwoTopicBackService {
	
	/**
	 * @Description 二级回复查询
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午2:23:17
	 * @param jsonArray
	 * @return
	 */
	List<TwoTopicBackDto> findTwoTopicBack(JSONObject jsonArray);
	
	/**
	 * @Description 审核二级回复数量 
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午12:27:10
	 * @param jsonArray
	 * @return
	 */
	int findTwoTopicBackCount(JSONObject jsonArray);
	
	/**
	 * @Description 审核二级回复  
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午12:27:03
	 * @param jsonArray
	 * @return
	 */
	boolean toExamine(JSONObject jsonArray);
	
}
