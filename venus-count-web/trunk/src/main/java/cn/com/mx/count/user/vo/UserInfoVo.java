package cn.com.mx.count.user.vo;

import java.util.Date;

/**
 * @Description 会员基本信息 
 * @author jiale
 * @date 2016年3月3日 下午4:40:14
 */
public class UserInfoVo {

	private String mobile;	//手机号
	private String email;	//邮箱号
	private Date birthday;	//出生日期
	private String nickname;	//昵称
	private Integer gender;	//性别
	private String facePicUrl;	//会员头像
	private Long membershipRefereeId;	//会员推荐人id（本地的UserId）
	private String xpopRefereeId;	//商家推荐人Id
	private String referralCode;	//自己的推荐码
	private String userSign;	//用户签名
	private ExpertInfoVo expertInfoVo;	//用户达人信息
	private Integer roleId;	//用户角色
	private String imId;	//IM账号
	private String mobileActivated;	//手机绑定状态
	private String emailActivated;	//邮箱绑定状态
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getFacePicUrl() {
		return facePicUrl;
	}
	public void setFacePicUrl(String facePicUrl) {
		this.facePicUrl = facePicUrl;
	}
	public Long getMembershipRefereeId() {
		return membershipRefereeId;
	}
	public void setMembershipRefereeId(Long membershipRefereeId) {
		this.membershipRefereeId = membershipRefereeId;
	}
	public String getXpopRefereeId() {
		return xpopRefereeId;
	}
	public void setXpopRefereeId(String xpopRefereeId) {
		this.xpopRefereeId = xpopRefereeId;
	}
	public String getReferralCode() {
		return referralCode;
	}
	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}
	public String getUserSign() {
		return userSign;
	}
	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}
	public ExpertInfoVo getExpertInfoVo() {
		return expertInfoVo;
	}
	public void setExpertInfoVo(ExpertInfoVo expertInfoVo) {
		this.expertInfoVo = expertInfoVo;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getImId() {
		return imId;
	}
	public void setImId(String imId) {
		this.imId = imId;
	}
	public String getMobileActivated() {
		return mobileActivated;
	}
	public void setMobileActivated(String mobileActivated) {
		this.mobileActivated = mobileActivated;
	}
	public String getEmailActivated() {
		return emailActivated;
	}
	public void setEmailActivated(String emailActivated) {
		this.emailActivated = emailActivated;
	}
	
}
