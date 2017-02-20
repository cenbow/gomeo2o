package cn.com.mx.topicBack.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mx.base.Contants;
import cn.com.mx.topicBack.service.ITopicBackService;
import cn.com.mx.utils.CodeUtil;
import cn.com.mx.utils.ResultModel;
import cn.com.mx.utils.ResultModelData;
import cn.com.mx.utils.web.BaseAction;

/**
 * @Description 话题审核
 * @author yuanchangjun
 * @date 2016年2月22日 下午5:01:35
 */
@Controller
@RequestMapping("/topicBack")
@Slf4j
@SuppressWarnings("all")
public class TopicBackController extends BaseAction {
	
	@Autowired
	ITopicBackService topicBackService;
	
	/**
	 * @Description 查询 圈子审核,未审核,未通过 
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:36:47
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/findTopicBack")  
	@ResponseBody()
	public ResultModelData<Object> findNotAuditedGroup(String aoData){
		JSONObject jsonArray = JSONObject.fromObject(aoData);
		int count = this.topicBackService.findTopicBackCount(jsonArray);
		return new ResultModelData<Object>(jsonArray,count, count,this.topicBackService.findTopicBack(jsonArray));
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
			if(this.topicBackService.toExamine(jsonArray)){
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