package cn.com.mx.cms.entity;

import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

public class RecommendDataEntity extends BaseEntity {

	private static final long serialVersionUID = -5192154790068543144L;

	private String recommendData;

	private Long recommendMetadataId;

	private Integer isDelete;

	private Date createTime;

	private Date updateTime;

	private String createOperator;

	private String updateOperator;


	public String getRecommendData() {
		return recommendData;
	}

	public void setRecommendData(String recommendData) {
		this.recommendData = recommendData;
	}

	public Long getRecommendMetadataId() {
		return recommendMetadataId;
	}

	public void setRecommendMetadataId(Long recommendMetadataId) {
		this.recommendMetadataId = recommendMetadataId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator == null ? null : createOperator.trim();
	}

	public String getUpdateOperator() {
		return updateOperator;
	}

	public void setUpdateOperator(String updateOperator) {
		this.updateOperator = updateOperator == null ? null : updateOperator.trim();
	}
}