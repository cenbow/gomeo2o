package cn.com.mx.count.user.vo;

import java.util.List;

/**
 * @Description 会员达人信息 
 * @author jiale
 * @date 2016年3月3日 下午4:40:41
 */
public class ExpertInfoVo {
	private Integer auditStatus;	//达人审核状态
	private List<Category> categoryList;	//达人种类list
	
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

}
