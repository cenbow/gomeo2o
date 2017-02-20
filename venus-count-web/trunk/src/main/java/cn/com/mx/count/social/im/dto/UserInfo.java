package cn.com.mx.count.social.im.dto;

import java.io.Serializable;

/**
 * 
 * @Description: 用户信息 
 * @author: xuguoqi
 * @date: 2016年1月18日 下午3:56:15
 */
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 1969065896240944056L;
	
	private long uid;  //用户id
    private String nickName; //用户名称
    private int deviceType; //app设备类型
    private String deviceToken; //app设备token

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

}
