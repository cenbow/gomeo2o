package cn.com.mx.count.social.im.service;

import java.util.List;

import cn.com.mx.count.social.im.dto.UserInfo;

public interface ImService {

	/**
	 * @Description 创建圈子
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:09:53
	 * @param uid
	 *            群创建者ID
	 * @param nickName
	 *            群创建者昵称(名称)
	 * @param groupId
	 *            群ID
	 * @param groupName
	 *            群的名称
	 * @param desc
	 *            群描述(非必要参数)
	 * @param content
	 *            通过IM透传的消息内容(非必要参数)
	 * @return
	 */
	public void addGroup(String uid, String nickName, String groupId, String groupName,
			String desc, String content);

	/**
	 * 
	 * @Description 修改圈子
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:18:10
	 * @param uid
	 *            群创建者ID
	 * @param nickName
	 *            群创建者昵称(名称)
	 * @param groupId
	 *            群ID
	 * @param groupName
	 *            群的名称
	 * @param desc
	 *            群描述(非必要参数)
	 * @param content
	 *            通过IM透传的消息内容(非必要参数)
	 * @return
	 */
	public void editGroup(String uid, String nickName, String groupId, String groupName,
			String desc, String content);

	/**
	 * @Description 用户加入群
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:25:04
	 * @param groupId
	 *            群ID
	 * @param uid
	 *            加入的用户id
	 * @param nickName
	 *            加入用户昵称
	 * @param content
	 *            通过IM透传的消息内容(非必要参数)
	 * @return
	 */
	public void joinGroup(String groupId, String uid, String nickName, String content);

	/**
	 * @Description 用户退出群
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:25:04
	 * @param groupId
	 *            群ID
	 * @param uid
	 *            加入的用户id
	 * @param nickName
	 *            加入用户昵称
	 * @param content
	 *            通过IM透传的消息内容(非必要参数)
	 * @return
	 */
	public void quitGroup(String groupId, String uid, String nickName, String content);

	/**
	 * @Description 群主踢人
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:30:14
	 * @param groupId
	 *            群ID
	 * @param uid
	 *            群主id
	 * @param nickName
	 *            群主昵称
	 * @param memberIds
	 *            被踢的成员
	 * @param content
	 *            通过IM透传的消息内容(非必要参数)
	 * @return
	 */
	public void kickGroup(String groupId, String uid, String nickName, List<Long> memberIds,
			String content);

	/**
	 * @Description 添加或者修改用户信息
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:44:33
	 * @param opt
	 *            opt=1添加用户信息;opt=2更新用户信息
	 * @param userInfoList
	 *            用户信息列表
	 * @return
	 */
	public void userInfo(int opt, List<UserInfo> userInfoList);

	/**
	 * @Description 发消息接口
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:50:17
	 * @param senderId
	 *            发送消息的用户ID
	 * @param senderName
	 *            发送消息的用户昵称
	 * @param groupType
	 *            发送类型 单聊类型:groupType=1;群聊类型:groupType=2
	 * @param receiveId
	 *            接收消息用户ID(单聊类型:groupType=1时,必要参数)
	 * @param groupId
	 *            群ID(群聊类型:groupType=2时,必要参数)
	 * @param groupName
	 *            群名称 (群聊类型:groupType=2时,必要参数)
	 * @param content
	 *            消息内容
	 * @return
	 */
	public void notifyMessage(String senderId, String senderName, int groupType,
			String receiveId, String groupId, String groupName, String content);

	/**
	 * @Description 全量广播消息
	 * @author kl_chaizhilei
	 * @date 2016年1月15日 下午4:55:18
	 * @param uid
	 *            用户id
	 * @param nickName
	 *            发送人昵称
	 * @param content
	 *            发送内容
	 * @return
	 */
	public void broadcastMessage(String uid, String nickName, String content);

}
