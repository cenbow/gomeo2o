package cn.com.mx.group.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mx.base.Contants;
import cn.com.mx.group.model.dto.GroupNotAudited;
import cn.com.mx.group.service.IGroupService;
import cn.com.mx.utils.CodeUtil;
import cn.com.mx.utils.ResultModel;
import cn.com.mx.utils.ResultModelData;
import cn.com.mx.utils.web.BaseAction;

/**
 * @Description 群组审核 
 * @author yuanchangjun
 * @date 2016年1月28日 上午10:12:46
 */
@Controller
@RequestMapping("/group")
@Slf4j
public class GroupController extends BaseAction {
	
	@Autowired
	IGroupService groupService;
	
	/**
	 * @Description 查询 圈子审核,未审核,未通过 
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:36:47
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/findNotAuditedGroup")  
	@ResponseBody()
	public ResultModelData<Object> findNotAuditedGroup(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.groupService.findNotAuditedGroupCount(jsonArray);
		List<GroupNotAudited> list = this.groupService.findNotAuditedGroup(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,list);
	}
	
	/**
	 * @Description 查询 修改圈子 
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:36:47
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/findEditGroup")  
	@ResponseBody()
	public ResultModelData<Object> findEditGroup(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.groupService.findEditCount(jsonArray);
		List<GroupNotAudited> list = this.groupService.findEditGroup(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,list);
	}
	
	/**
	 * @Description 审核通过或不通过
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:37:17
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/egis")  
	@ResponseBody()
	public ResultModel<Object> egis(String check,HttpServletRequest request){
		try {
			JSONObject jsonArray = JSONObject.fromObject(check);
			jsonArray.put("auditUserId",request.getSession().getAttribute(Contants.SESSION_USERID));
			if(this.groupService.toExamine(jsonArray)){
				return new ResultModel<Object>(true,CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG,"");
			}else{
				return new ResultModel<Object>(false,CodeUtil.FAIL, CodeUtil.FAIL_MSG, "");
			}
        } catch (Exception e) {
            log.error("未定义错误：审核通过或不通过");
            return new ResultModel<Object>(false,CodeUtil.UNDEFINED, CodeUtil.UNDEFINED_MSG, "");
        }
	}
	
	/**
	 * @Description 修改通过或不通过审核
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:37:17
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/editEgis")  
	@ResponseBody()
	public ResultModel<Object> editEgis(String check,HttpServletRequest request){
		try {
			JSONObject jsonArray = JSONObject.fromObject(check);
			jsonArray.put("auditUserId",request.getSession().getAttribute(Contants.SESSION_USERID));
			if(this.groupService.toEditExamine(jsonArray)){
				return new ResultModel<Object>(true,CodeUtil.SUCCESS, CodeUtil.SUCCESS_MSG,"");
			}else{
				return new ResultModel<Object>(false,CodeUtil.FAIL, CodeUtil.FAIL_MSG, "");
			}
		} catch (Exception e) {
			log.error("未定义错误：审核通过或不通过");
			return new ResultModel<Object>(false,CodeUtil.UNDEFINED, CodeUtil.UNDEFINED_MSG, "");
		}
	}
}