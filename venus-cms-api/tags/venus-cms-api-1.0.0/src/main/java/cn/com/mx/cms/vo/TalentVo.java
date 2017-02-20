package cn.com.mx.cms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 达人推荐
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class TalentVo implements Serializable {

	private static final long serialVersionUID = -8561853149697020573L;
	//达人头像
	private String talentIcon = "";
	//达人类型：美妆达人，运动达人
	private String talentType = "";
	//达人名称
	private String talentName = "";
	//粉丝数
	private int focusNum = 0;
	//个人秀
	private String showUrl = "";
	//是否关注：0未关注，1已关注
	private int isFocus = 0;
	//用户id
	private int userId;
	//商品图url列表
	private List<String> product = new ArrayList<String>();

	public String getTalentIcon() {
		return talentIcon;
	}

	public void setTalentIcon(String talentIcon) {
		this.talentIcon = talentIcon;
	}

	public String getTalentType() {
		return talentType;
	}

	public void setTalentType(String talentType) {
		this.talentType = talentType;
	}

	public String getTalentName() {
		return talentName;
	}

	public void setTalentName(String talentName) {
		this.talentName = talentName;
	}


	public String getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}

	public int getIsFocus() {
		return isFocus;
	}

	public void setIsFocus(int isFocus) {
		this.isFocus = isFocus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<String> getProduct() {
		return product;
	}

	public void setProduct(List<String> product) {
		this.product = product;
	}

	public int getFocusNum() {
		return focusNum;
	}

	public void setFocusNum(int focusNum) {
		this.focusNum = focusNum;
	}

	@Override
	public String toString() {
		return "TalentVo [talentIcon=" + talentIcon + ", talentType=" + talentType + ", talentName=" + talentName + ", focusNum=" + focusNum + ", showUrl=" + showUrl + ", isFocus=" + isFocus + ", userId=" + userId + ", product=" + product + "]";
	}

}
