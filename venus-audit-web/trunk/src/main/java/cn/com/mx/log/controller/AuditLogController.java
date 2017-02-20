package cn.com.mx.log.controller;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mx.log.service.IAuditLogService;
import cn.com.mx.utils.ResultModelData;
import cn.com.mx.utils.web.BaseAction;

/**
 * @Description 审核日志 
 * @author yuanchangjun
 * @date 2016年1月28日 上午10:12:46
 */
@Controller
@RequestMapping("/log")
@Slf4j
@SuppressWarnings("all")
public class AuditLogController extends BaseAction {
	
	@Autowired
	IAuditLogService auditLogService;
	
	/**
	 * @Description 查询 圈子审核日志
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:42:32
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/groupLog")  
	@ResponseBody()
	public ResultModelData<Object> findNotAuditedGroup(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.auditLogService.findGroupLogCount(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,this.auditLogService.findGroupLog(jsonArray));
	}
	
	/**
	 * @Description 查询修改圈子审核日志
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:42:32
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/editGroupLog")  
	@ResponseBody()
	public ResultModelData<Object> findEditGroup(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.auditLogService.findGroupLogCount(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,this.auditLogService.findGroupLog(jsonArray));
	}
	
	/**
	 * @Description 查询 话题审核日志
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:42:32
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/topicLog")  
	@ResponseBody()
	public ResultModelData<Object> findTopicLog(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.auditLogService.findTopicLogCount(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,this.auditLogService.findTopicLog(jsonArray));
	}
	
	/**
	 * @Description 查询 话题回复审核日志
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:42:32
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/topicBackLog")  
	@ResponseBody()
	public ResultModelData<Object> findTopicBackLog(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.auditLogService.findTopicBackLogCount(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,this.auditLogService.findTopicBackLog(jsonArray));
	}
	
	/**
	 * @Description 查询 话题回复审核日志
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:42:32
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/twoTopicBackLog")  
	@ResponseBody()
	public ResultModelData<Object> findTwoTopicBackLog(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.auditLogService.findTwoTopicBackLogCount(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,this.auditLogService.findTwoTopicBackLog(jsonArray));
	}
}