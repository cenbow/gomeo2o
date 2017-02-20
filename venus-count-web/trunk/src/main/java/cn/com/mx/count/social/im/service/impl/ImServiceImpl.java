package cn.com.mx.count.social.im.service.impl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.social.im.comm.ImConstant;
import cn.com.mx.count.social.im.dto.ImResultEntity;
import cn.com.mx.count.social.im.dto.ReqGroup;
import cn.com.mx.count.social.im.dto.ReqMessage;
import cn.com.mx.count.social.im.dto.ReqUserInfo;
import cn.com.mx.count.social.im.dto.UserInfo;
import cn.com.mx.count.social.im.http.HttpClientUtils;
import cn.com.mx.count.social.im.service.ImService;
import cn.com.mx.count.utils.ConfigUtil;
import cn.com.mx.count.utils.UUIDUtils;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @Description: 与im服务交互实现
 * @author: xuguoqi
 * @date: 2016年1月18日 上午11:48:25
 */
@Slf4j
public class ImServiceImpl implements ImService {


	@Override
	public void addGroup(String uid, String nickName, String groupId, String groupName,
			String desc, String content) {
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		ReqGroup reqGroup = new ReqGroup();
		reqGroup.setRequestId(UUIDUtils.creatUUID());
		reqGroup.setAppServerName(ImConstant.APP_SERVER_NAME);
		try {
			reqGroup.setUid(Long.parseLong(uid));
		} catch (Exception e) {
			log.error("类型转换错误 e={}", e);
		}
		reqGroup.setNickName(nickName);
		reqGroup.setGroupId(groupId);
		reqGroup.setGroupName(groupName);
		reqGroup.setDesc(desc);
		reqGroup.setContent(content);
		String url = this.getRequestUrl(ImConstant.IM_ADD_GROUP);
		Object json = JSON.toJSON(reqGroup);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (0 != resultEntity.getResultCode()) {
			log.error("调用addGroup服务失败:{}", resultEntity);
		}
	}

	@Override
	public void editGroup(String uid, String nickName, String groupId, String groupName,
			String desc, String content) {
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		ReqGroup reqGroup = new ReqGroup();
		reqGroup.setRequestId(UUIDUtils.creatUUID());
		reqGroup.setAppServerName(ImConstant.APP_SERVER_NAME);
		try {
			reqGroup.setUid(Long.parseLong(uid));
		} catch (Exception e) {
			log.error("类型转换错误 e={}", e);
		}
		reqGroup.setNickName(nickName);
		reqGroup.setGroupId(groupId);
		reqGroup.setGroupName(groupName);
		reqGroup.setDesc(desc);
		reqGroup.setContent(content);
		String url = this.getRequestUrl(ImConstant.IM_EDIT_GROUP);
		Object json = JSON.toJSON(reqGroup);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (0 != resultEntity.getResultCode()) {
			log.error("调用editGroup服务失败:{}", resultEntity);
		}
	}

	@Override
	public void joinGroup(String groupId, String uid, String nickName, String content) {
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		ReqGroup reqGroup = new ReqGroup();
		reqGroup.setRequestId(UUIDUtils.creatUUID());
		reqGroup.setAppServerName(ImConstant.APP_SERVER_NAME);
		try {
			reqGroup.setUid(Long.parseLong(uid));
		} catch (Exception e) {
			log.error("类型转换错误 e={}", e);
		}
		reqGroup.setNickName(nickName);
		reqGroup.setGroupId(groupId);
		reqGroup.setContent(content);
		String url = this.getRequestUrl(ImConstant.IM_JOIN_GROUP);
		Object json = JSON.toJSON(reqGroup);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (0 != resultEntity.getResultCode()) {
			log.error("调用joinGroup服务失败:{}", resultEntity);
		}
	}

	@Override
	public void quitGroup(String groupId, String uid, String nickName, String content) {
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		ReqGroup reqGroup = new ReqGroup();
		reqGroup.setRequestId(UUIDUtils.creatUUID());
		reqGroup.setAppServerName(ImConstant.APP_SERVER_NAME);
		try {
			reqGroup.setUid(Long.parseLong(uid));
		} catch (Exception e) {
			log.error("类型转换错误 e={}", e);
		}
		reqGroup.setNickName(nickName);
		reqGroup.setGroupId(groupId);
		reqGroup.setContent(content);
		String url = this.getRequestUrl(ImConstant.IM_QUIT_GROUP);
		Object json = JSON.toJSON(reqGroup);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (0 != resultEntity.getResultCode()) {
			log.error("调用quitGroup服务失败:{}", resultEntity);
		}
	}

	@Override
	public void kickGroup(String groupId, String uid, String nickName, List<Long> memberIds,
			String content) {
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		ReqGroup reqGroup = new ReqGroup();
		reqGroup.setRequestId(UUIDUtils.creatUUID());
		reqGroup.setAppServerName(ImConstant.APP_SERVER_NAME);
		try {
			reqGroup.setUid(Long.parseLong(uid));
		} catch (Exception e) {
			log.error("类型转换错误 e={}", e);
		}
		reqGroup.setNickName(nickName);
		reqGroup.setGroupId(groupId);
		reqGroup.setContent(content);
		reqGroup.setMemberIds(memberIds);
		String url = this.getRequestUrl(ImConstant.IM_KICK_GROUP);
		Object json = JSON.toJSON(reqGroup);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (0 != resultEntity.getResultCode()) {
			log.error("调用kickGroup服务失败:{}", resultEntity);
		}
	}

	/**
	 * 
	 * @Description: 添加或者修改用户信息 
     * @author: xuguoqi
     * @date: 2016年1月18日 下午3:40:25
     * @param opt opt=1添加用户信息;opt=2更新用户信息
     * @param userInfoList
     * @return
	 */
	@Override
	public void userInfo(int opt, List<UserInfo> userInfoList) {
		
		//获取httpClient实例
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		//数据封装
		ReqUserInfo userInfo = new ReqUserInfo();
		userInfo.setRequestId(UUIDUtils.creatUUID());
		userInfo.setAppServerName(ImConstant.APP_SERVER_NAME);
		userInfo.setOpt(opt);
		userInfo.setUserInfoList(userInfoList);
		//发送请求
		String url = this.getRequestUrl(ImConstant.IM_USER_INFO);
		Object json = JSON.toJSON(userInfo);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (null==resultEntity || 0 != resultEntity.getResultCode()) {
			log.error("调用userInfo服务失败:{}", resultEntity);
		}

	}
	
	/**
	 * 
	 * @Description: 发送消息实现 
     * @author: xuguoqi
     * @date: 2016年1月18日 下午3:31:34
     * @param senderId
     * @param senderName
     * @param groupType
     * @param receiveId
     * @param groupId
     * @param groupName
     * @param content
     * @return
	 */
	@Override
	public void notifyMessage(String senderId, String senderName, int groupType,
			String receiveId, String groupId, String groupName, String content) {
		
		//获取httpClient实例
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		//数据封装
		ReqMessage msg = new ReqMessage();
		msg.setRequestId(UUIDUtils.creatUUID());
		msg.setAppServerName(ImConstant.APP_SERVER_NAME);
		try {
			msg.setSenderId(Long.parseLong(senderId));
			msg.setReceiveId(Long.parseLong(receiveId));
		} catch (Exception e) {
			log.error("类型转换错误 e={}", e);
		}
		msg.setSenderName(senderName);
		msg.setGroupType(groupType);
		msg.setGroupName(groupName);
		msg.setGroupId(groupId);
		msg.setContent(content);
		//发送请求
		String url = this.getRequestUrl(ImConstant.IM_NOTIFY_MESSAGE);
		Object json = JSON.toJSON(msg);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (0 != resultEntity.getResultCode()) {
			log.error("调用notifyMessage服务失败:{}", resultEntity);
		}
	}

	/**
	 * 
	 * @Description: 全站广播
	 * @author: xuguoqi
	 * @date: 2016年1月18日 上午11:51:04
	 * @param uid
	 * @param nickName
	 * @param content
	 * @return
	 */
	@Override
	public void broadcastMessage(String uid, String nickName, String content) {
		
		//获取httpClient实例
		HttpClientUtils httpClientUtils = null;
		try {
			httpClientUtils = HttpClientUtils.getInstance();
		} catch (Exception e) {
			log.error("实例化IM-HttpClient失败,异常:{}", e);
		}
		
		//数据封装
		ReqMessage reqMessage = new ReqMessage();
		reqMessage.setRequestId(UUIDUtils.creatUUID());
		reqMessage.setAppServerName(ImConstant.APP_SERVER_NAME);
		try {
			reqMessage.setSenderId(Long.parseLong(uid));
		} catch (Exception e) {
			log.error("类型转换错误 e={}", e);
		}
		reqMessage.setSenderName(nickName);
		reqMessage.setContent(content);
		
		//发送请求
		String url = this.getRequestUrl(ImConstant.IM_BROADCAST_MESSAGE);
		Object json = JSON.toJSON(reqMessage);
		String result = httpClientUtils.post(url, json);
		ImResultEntity resultEntity = JSON.parseObject(result, ImResultEntity.class);
		if (0 != resultEntity.getResultCode()) {
			log.error("调用broadcastMessage服务失败:{}", resultEntity);
		}

	}
	
	/**
	 * @Description 获取请求的完整路径
	 * @author kl_chaizhilei
	 * @date 2016年1月18日 下午3:12:18
	 * @param path 请求路径
	 * @return
	 */
	private String getRequestUrl(String path) {
		return ConfigUtil.get("im.host") + path;
	}

}
