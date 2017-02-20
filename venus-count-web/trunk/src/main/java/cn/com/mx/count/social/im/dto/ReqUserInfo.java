package cn.com.mx.count.social.im.dto;


import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Description: 用户信息 Request model 
 * @author: xuguoqi
 * @date: 2016年1月18日 下午3:56:03
 */
public class ReqUserInfo extends BaseRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6779949999090333659L;
	private int opt; //1：添加用户操作   2：更新用户操作
    private List<UserInfo> userInfoList;

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
