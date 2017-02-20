package cn.com.mx.group.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.com.mx.group.model.dto.GroupNotAudited;


/**
 * @Description 群组审核接口 
 * @author yuanchangjun
 * @date 2016年1月28日 上午10:13:58
 */
public interface IGroupService {
	
	/**
	 * @Description 查询[未审,审核,审核未通过]核群组 
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:48:06
	 * @return
	 */
	List<GroupNotAudited> findNotAuditedGroup(JSONObject jsonArray);
	
	/**
	 * @Description 查询修改[未审,审核,审核未通过]核群组 
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:48:06
	 * @return
	 */
	List<GroupNotAudited> findEditGroup(JSONObject jsonArray);
	
	/**
	 * @Description 查询修改[未审,审核,审核未通过]核群组数量
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:48:19
	 * @return
	 */
	int findEditCount(JSONObject jsonArray);
	/**
	 * @Description 查询[未审,审核,审核未通过]核群组数量
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:48:19
	 * @return
	 */
	int findNotAuditedGroupCount(JSONObject jsonArray);
	
	/**
	 * @Description 审核通过和审核不通过 
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:51:36
	 * @param jsonArray
	 * @return
	 */
	boolean toExamine(JSONObject jsonArray);
	/**
	 * @Description 修改圈子审核通过和审核不通过 
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:51:36
	 * @param jsonArray
	 * @return
	 */
	boolean toEditExamine(JSONObject jsonArray);
	
}
