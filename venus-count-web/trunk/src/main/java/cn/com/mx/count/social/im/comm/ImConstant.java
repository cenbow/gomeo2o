package cn.com.mx.count.social.im.comm;

/**
 * 
 * @Description: IM服务的常量 
 * @author: xuguoqi
 * @date: 2016年1月18日 上午10:16:35
 */
public interface ImConstant {
	/**
	 * 公共参数
	 */
	public static final String APP_SERVER_NAME = "bs-venus-social";//调用im服务的server_name
	
	/**
	 * http请求
	 */
	public static final String CHARSET = "UTF-8";//编码集
	
	public static final int RETRY_COUNT = 3;//重试次数
	
	public static final int MAX_CONN_PER_ROUTE = 64;//单个请求最大连接数
	
	public static final int MAX_CONN_TOTAL = 128;//允许的最大链接数
	
	public static final int SOCKET_TIME_OUT = 3000;//最大响应超时时间
	
	public static final int CONNECT_TIME_OUT = 3000;//最大请求超时时间
	
	
	/**
	 * 圈子
	 */
	public static final String IM_ADD_GROUP ="group/addGroup.json";//创建圈子
	
	public static final String IM_EDIT_GROUP ="group/editGroup.json";//修改圈子
	
	public static final String IM_JOIN_GROUP ="group/joinGroup.json";//加入圈子
	
	public static final String IM_QUIT_GROUP ="group/quitGroup.json";//用户退出圈子
	
	public static final String IM_KICK_GROUP ="group/quitGroup.json";//群主踢人
	
	/**
	 * 用户
	 */
	public static final String IM_USER_INFO ="user/userInfo.json";//添加或者修改用户信息
	
	/**
	 * 消息
	 */
	public static final String IM_NOTIFY_MESSAGE ="message/notifyMessage.json";//发消息接口
	
	public static final String IM_BROADCAST_MESSAGE ="message/broadcastMessage.json";//全量广播消息接口
	

}
